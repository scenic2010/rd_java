package scenic.net.proxy;/* Written and copyright 2001 Benjamin Kohl.
 * Distributed under the GNU General Public License; see the README file.
 * This code comes with NO WARRANTY.
 * More Information and documentation: HTTP://jhttp2.sourceforge.net
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.net.BindException;

import java.io.*;

import java.util.Vector;
import java.util.Properties;
import java.util.Date;

/**
 * JHTTPP2 - light-weight Java HTTP Proxy Server
 * @author Benjamin Kohl
 * 
 */
public class HttpServer implements Runnable {
	private final String VERSION = "0.4.25";
	//special
	private final String V_SPECIAL = " [05/11/2001]";

	private final String HTTP_VERSION = "HTTP/1.1";

	private String http_useragent = "Mozilla/4.0 (compatible; MSIE 4.0; WindowsNT 5.0)";

	/**
	 * log文件的名称
	 */
	private final String MAIN_LOGFILE = "Jhttpp2_main.log";
	/**
	 * 默认端口是 8088
	 */
	public int port = 8088;
	public InetAddress proxy;
	public int proxy_port = 0;

	/**
	 * 服务器监听
	 */
	private ServerSocket serverSocket;

	private boolean enable_cookies_by_default = true;

	public static boolean error;
	public static String error_msg;

	public boolean use_proxy = false;
	public static boolean block_urls = true;
	public boolean filter_http = false;
	public boolean debug = false;
	public boolean log_access = false;

	public HttpServer() {
		try {
			new BufferedWriter(new FileWriter(MAIN_LOGFILE, true));

			serverSocket = new ServerSocket(port);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			
			while (true) {
				Socket socket = serverSocket.accept();
				new HTTPSession(this, socket);
			}
			
		} catch (Exception e) {e.printStackTrace();}
	}

	/**
	 * Tests what method is used with the reqest
	 * 
	 * @return -1 if the server doesn't support the method
	 */
	public int getHttpMethod(String d) {
		if (startsWith(d, "GET") || startsWith(d, "HEAD"))
			return 0;
		if (startsWith(d, "POST") || startsWith(d, "PUT"))
			return 1;
		if (startsWith(d, "CONNECT"))//connect
			return 2;
		if (startsWith(d, "OPTIONS"))
			return 3;
		
		//No match... Following methods are not implemented yet: || startsWith(d,"TRACE")
		return -1;
	}

	public boolean startsWith(String src, String what) {
		int tarLenth = what.length();
		int srcLength = src.length();
		return srcLength >= tarLenth ? src.substring(0, tarLenth).equals(what) : false;
	}

	/**
	 *@return the Server response-header field
	 */
	public String getHTTPServerIdentification() {
		return "jHTTPp2/" + getServerVersion();
	}

	/**
	 * @return the HTTP version used by jHTTPp2
	 */
	public String getHttpVersion() {
		return HTTP_VERSION;
	}

	/**
	 * the User-Agent header field
	 * 
	 * @since 0.2.17
	 * @return User-Agent String
	 */
	public String getUserAgent() {
		return http_useragent;
	}

	public void addBytesRead(long read) {
	}

	/**
	 * Functions for the jHTTPp2 statistics: How many connections Bytes
	 * read/written
	 * 
	 * @since 0.3.0
	 */
	public void addBytesWritten(int written) {
	}

	public void increaseNumConnections() {
	}

	public void decreaseNumConnections() {
	}

	public boolean enableCookiesByDefault() {
		return this.enable_cookies_by_default;
	}

	private String getServerVersion() {
		return VERSION + V_SPECIAL;
	}

}
