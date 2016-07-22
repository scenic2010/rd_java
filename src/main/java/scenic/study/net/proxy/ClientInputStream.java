package scenic.study.net.proxy;/* Written and copyright 2001 Benjamin Kohl.
 * Distributed under the GNU General Public License; see the README file.
 * This code comes with NO WARRANTY.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * File: Jhttpp2BufferedFilterStream.java
 * 
 * @author Benjamin Kohl
 */
public class ClientInputStream extends BufferedInputStream {
	private String strBuf;
	/**
	 * 每次读取一行的时候，该行字符的长度
	 */
	private int lreadLenth = 0;
	
	/**
	 * 头信息的长度 (with body, if one)
	 */
	private int header_length = 0;
	
	/**
	 * The length of the (optional) body of the actual request 
	 * 实际请求内容的长度
	 */
	private int content_len = 0;
	
	/**
	 * This is set to true with requests with bodies, like "POST"
	 */
	private boolean isBody = false;

	private static HttpServer htppServer;
	private InetAddress remote_host;
	private boolean isSSL = false;
	private int statuscode;

	public String url;
	public String method;
	public int remote_port = 0;
	private boolean cookies_enabled;

	public int getHeaderLength() {
		return header_length;
	}

	public InetAddress getRemoteHost() {
		return remote_host;
	}
	
	public ClientInputStream(HttpServer server, scenic.study.net.proxy.HTTPSession connection,
							 InputStream a) {
		super(a);
		ClientInputStream.htppServer = server;
	}

	/**
	 * Handler for the actual HTTP request
	 * 
	 * @exception java.io.IOException
	 */
	public int read(byte[] bu) throws IOException {
		statuscode = scenic.study.net.proxy.HTTPSession.SC_OK;
		
		// if (!filter) return super.read(a);
		if (isSSL){
			return super.read(bu);
		}
		
		cookies_enabled = htppServer.enableCookiesByDefault();
		String requestString = "";
		header_length = 0;
		
		boolean start_line = true;
		
		//读取请求的第一行
		//reads the first line
		strBuf = getLine(); 
		//I think this should also do requests with empty lines before and after the header
		//作者认为在该行的前后还应该有一个空行
		 
		//读取每一行进行解析
		while (lreadLenth > 2) {
			if (start_line) {
				start_line = false;
				
				//for startline
				forReadTheHeadOfHttp();
			} else {
				//Content-Length parsing
				forRequestContent();
			}
			if (strBuf != null) {
				requestString += strBuf;
				header_length += lreadLenth;
			}
			
			strBuf = getLine();
		}
		
		// adds last line (should be an empty line) to the header
		requestString += strBuf;
		// String
		header_length += lreadLenth;
		if (header_length == 0) {
			//header_length=0, setting status to SC_CONNECTION_CLOSED
			statuscode = scenic.study.net.proxy.HTTPSession.SC_CONNECTION_CLOSED;
		}

		for (int i = 0; i < header_length; i++){
			bu[i] = (byte) requestString.charAt(i);
		}

		if (isBody) {
			// read the body, if "Content-Length" given
			int post_data = 0;
			while (post_data < content_len) {
				bu[header_length + post_data] = (byte) read(); // writes data into the array
				post_data++;
			}
			
			header_length += content_len; // add the body-length to the header-length
			isBody = false;
		}

		boolean temp1 = (statuscode == scenic.study.net.proxy.HTTPSession.SC_OK);
		
		// return -1  with an error
		return temp1 ? header_length : -1;
//		return header_length ;
	}
	/**
	 * @return boolean whether the actual connection was established with the
	 *         CONNECT method.
	 * @since 0.2.21
	 */
	public boolean isTunnel() {
		return isSSL;
	}

	/**
	 * @return status-code for the actual request
	 * @since 0.3.5
	 */
	public int getStatusCode() {
		return statuscode;
	}

	/**
	 * Content-Length parsing
	 */
	private void forRequestContent() {
		// Content-Length parsing
		if (htppServer.startsWith(strBuf.toUpperCase(), "CONTENT-LENGTH")) {
			doContent_length(); //重要
		}else if (htppServer.startsWith(strBuf, "Proxy-Connection:")) {
			// (Proxy-)Connection header fields
			doProxy_Connection(); //重要
		}else if (htppServer.startsWith(strBuf, "Cookie:")) {
			// else if (server.startsWith(buf,"Connection:")) { if(!server.use_proxy) { buf="Connection: Keep-Alive\r\n"; //usealways keep-alive lread=buf.length(); } else buf=null; }
			// cookie crunch section
			doCookie();
		}else if (htppServer.filter_http) {
			// Http-Header filtering section
			doReferer();
		}
	}

	private void doReferer() {
		if (htppServer.startsWith(strBuf, "Referer:")) {// removes "Referer"
			strBuf = null;
		} else if (htppServer.startsWith(strBuf, "User-Agent")) // changes User-Agent
		{
			strBuf = "User-Agent: " + htppServer.getUserAgent() + "\r\n";
			lreadLenth = strBuf.length();
		}
	}

	private void doCookie() {
		if (!cookies_enabled){
			//如果是禁用cookie的话。
			strBuf = null;
		}
	}

	private void doProxy_Connection() {
		if (!htppServer.use_proxy)
			strBuf = null;
		else {
			strBuf = "Proxy-Connection: Keep-Alive\r\n";
			lreadLenth = strBuf.length();
		}
	}

	private void doContent_length() {
		//content-length 的值
		String clen = strBuf.substring(16);
		
		if (clen.indexOf("\r") != -1){
			clen = clen.substring(0, clen.indexOf("\r"));
		}else if (clen.indexOf("\n") != -1){
			clen = clen.substring(0, clen.indexOf("\n"));
		}
		
		content_len = Integer.parseInt(clen);
		
		if (!isSSL){
			isBody = true; // Note: in HTTP/1.1 any method can have a body, not only "POST"
		}
	}
	
	/**
	 * 读取HTTP请求的第一行，并且处理
	 */
	private boolean forReadTheHeadOfHttp() {
		//首先确定是用GET，还是POST方法请求
		int methodID = htppServer.getHttpMethod(strBuf);
		
		switch (methodID) {
		case -1:
			//不支持的请求方法，可以暂时不用考虑
			statuscode = scenic.study.net.proxy.HTTPSession.SC_NOT_SUPPORTED;
			return false;
		case 2:
			//用CONNECT方法请求
			isSSL = true;
		default: //GET POST 请求
			//获取远程的地址，主要是解析第一行 
			InetAddress address = parseRequest(strBuf);
		
			if (!isSSL) {
				
				/* creates a new request without the hostname */
				//这里的strBuf 一般是    ：GET / HTTP/1.1  或者是   GET /web/expires_10_min/qzone_info_text.js HTTP/1.1    POST /CDGServer3/TestConnectService HTTP/1.1
				strBuf = method + " " + url + " " + htppServer.getHttpVersion() + "\r\n";
				
				//此时这里是记录了HTTP请求的 第一行的长度
				lreadLenth = strBuf.length();
			}

			//此时的remote_host变量的值一般是null 
			//!address.equals(remote_host) 的值绝大多数都是true
			if (!address.equals(remote_host)) {
				//STATE_CONNECT_TO_NEW_HOST 要连接到一个新的地址
				
				statuscode = scenic.study.net.proxy.HTTPSession.SC_CONNECTING_TO_HOST;
				remote_host = address;
			}

			// ------------------------- url blocking (only "GET" method) -------------------------
//			boolean temp3 = HttpServer.block_urls && methodID == 0;
//			//这里可以没有的，可能是缓存
//			if (temp3) {
//				if (htppServer.debug)
//					System.out.println("Searching match...");//寻找匹配的
//				
//				
//				String tempUrl = this.remote_host_name + url;
//				URLMatch match = htppServer.findMatch(tempUrl);
//				
//				if (match != null) {
//					if (htppServer.debug)
//						System.out.println("Match found!"); //找到了
//					
//					cookies_enabled = match.getCookiesEnabled();
//					
//					if (match.getActionIndex() == -1)
//						break;
//					
//					OnURLAction action = (OnURLAction) htppServer.getURLActions().elementAt(match.getActionIndex());
//					
//					if (action.onAccesssDeny()) {
//						statuscode = HTTPSession.SC_URL_BLOCKED;
//						if (action.onAccessDenyWithCustomText())
//							errordescription = action.getCustomErrorText();
//					}
//					/*
//					 * if (action.shouldLog()) {
//					 * System.out.println("Logging not implemented!");
//					 * // might be a special log file. } if
//					 * (action.shouldSendHTTPRequest()) { //.... }
//					 */
//					if (action.onAccessRedirect()) {
//						statuscode = HTTPSession.SC_MOVED_PERMANENTLY;//permanently
//						errordescription = action.newLocation();
//					}
//				}// end if match!=null)
//			}// end if (server.block...
		}// end switch
		return true;
	}

	/**
	 * reads a line
	 * @exception java.io.IOException
	 */
	private String getLine() throws IOException {
		int l = 0;
		String line = "";
		lreadLenth = 0;
		while (l != '\n') {
			l = read();
			if (l != -1) {
				line += (char) l;
				lreadLenth++;
			} else
				break;
		}
		return line;
	}

	/**
	 * Parser for the first (!) line from the HTTP request<BR>
	 * Sets up the URL, method and remote hostname.
	 * 
	 * @return an InetAddress for the hostname, null on errors with a
	 *         statuscode!=SC_OK
	 */
	private InetAddress parseRequest(String firstLine) {
		String remoteHostName;
		url = "";
		/*
		  	firstLine is 		GET http://static.tieba.baidu.com/tb/img/pv.gif?fr=tb0_forum&st_mod=index&st_type=pv&t=1314447467887 HTTP/1.1

				remoteHostName is 		   static.tieba.baidu.com/tb/img/pv.gif?fr=tb0_forum&st_mod=index&st_type=pv&t=1314447467887 HTTP/1.1

				remoteHostName 			   static.tieba.baidu.com/tb/img/pv.gif?fr=tb0_forum&st_mod=index&st_type=pv&t=1314447467887
				url is 											 /tb/img/pv.gif?fr=tb0_forum&st_mod=index&st_type=pv&t=1314447467887
				remote_host_name is 	   static.tieba.baidu.com
		 */
		
		//  去掉   GET http:// 
		if (isSSL) {
			remoteHostName = firstLine.substring(8);
		} else {
			// first word in the line
			method = firstLine.substring(0, firstLine.indexOf(" "));
			
			// removes "http://"  去掉 GET http://         firstLine类似    GET http://static.tieba.baidu.com/tb/img/pv.gif?fr=tb0_forum&st_mod=index&st_type=pv&t=1314447467887 HTTP/1.1
			remoteHostName = firstLine.substring(firstLine.indexOf(":") + 3); 
		}
		
		//去掉    HTTP/1.1          remoteHostName类似     static.tieba.baidu.com/tb/img/pv.gif?fr=tb0_forum&st_mod=index&st_type=pv&t=1314447467887 HTTP/1.1
		remoteHostName = remoteHostName.substring(0, remoteHostName.indexOf(" ")); 
		
		//获取 url
		// locate the first slash   
		// 现在remoteHostName类似于  static.tieba.baidu.com/tb/img/pv.gif?fr=tb0_forum&st_mod=index&st_type=pv&t=1314447467887
		int posSplitUrlAndHost = remoteHostName.indexOf("/");   
		if (posSplitUrlAndHost != -1) {
			// saves path without hostname
			url = remoteHostName.substring(posSplitUrlAndHost); 
			
			remoteHostName = remoteHostName.substring(0, posSplitUrlAndHost); 
		} else{
			// occurs with this request: GET http://localhost HTTP/1.1 (is this correct???)
			url = "/"; 
		}
		
		// check for the portnumber
		// 检查端口
		//remoteHostName类似于  static.tieba.baidu.com 或者是  static.tieba.baidu.com:88
		int posForCheckPort = remoteHostName.indexOf(":"); 
		if (posForCheckPort != -1) {
			String thePostFormURL = remoteHostName.substring(posForCheckPort + 1);
			//thePostFormURL 类似 88
			thePostFormURL = thePostFormURL.indexOf(" ") != -1 ? thePostFormURL.substring(0, thePostFormURL.indexOf(" ")) : thePostFormURL;
			remote_port = Integer.parseInt(thePostFormURL);
			//分离的端口 此时类似于  static.tieba.baidu.com
			remoteHostName = remoteHostName.substring(0, posForCheckPort);
		} else{
			remote_port = 80;
		}
		
		InetAddress address = null;

		try {
			address = InetAddress.getByName(remoteHostName);
		} catch (UnknownHostException e_u_host) {
		}
		
		return address;
	}
}
