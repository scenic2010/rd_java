package scenic.study.net.proxy;/* Written and copyright 2001 Benjamin Kohl.
 * Distributed under the GNU General Public License; see the README file.
 * This code comes with NO WARRANTY.
 */

import java.net.Socket;
import java.net.InetAddress;

import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * One HTTP connection
 * 
 * @author Benjamin Kohl
 */
public class HTTPSession extends Thread {

	/**
	 * 成功
	 */
	public static final int SC_OK = 0;
	/**
	 * 获取远程的主机名称和IP地址
	 */
	public static final int SC_CONNECTING_TO_HOST = 1;
	public static final int SC_HOST_NOT_FOUND = 2;
	public static final int SC_URL_BLOCKED = 3;
	public static final int SC_CLIENT_ERROR = 4;
	public static final int SC_INTERNAL_SERVER_ERROR = 5;
	/**
	 * 不支持的请求方法
	 */
	public static final int SC_NOT_SUPPORTED = 6;
	public static final int SC_REMOTE_DEBUG_MODE = 7;
	public static final int SC_CONNECTION_CLOSED = 8;
	public static final int SC_HTTP_OPTIONS_THIS = 9;
	public static final int SC_FILE_REQUEST = 10;
	public static final int SC_MOVED_PERMANENTLY = 11;

	private static HttpServer httpServer;
	/** downstream connections */
	private Socket clientSocket;
	private BufferedOutputStream out;
	private ClientInputStream clientInputStream;

	/** upstream connections */
	private Socket HTTP_Socket;
	private BufferedOutputStream HTTP_out;
	private ServerInputStream HTTP_in;

	public HTTPSession(HttpServer httpServer, Socket clientSocket) {
		try {
			clientInputStream = new ClientInputStream(httpServer, this,clientSocket.getInputStream());
			out = new BufferedOutputStream(clientSocket.getOutputStream());

			HTTPSession.httpServer = httpServer;
			this.clientSocket = clientSocket;
		} catch (IOException e) {
			e.printStackTrace();
		}

		start();
	}

	public void run() {
		try {
			//begin http session"
			
			// 请求的连接数加一
			httpServer.increaseNumConnections();

			// 处理客户端的请求
			handleRequest();

			// close downstream connections
			clientInputStream.close(); // since 0.4.10b
			out.close();
			clientSocket.close();

			// close upstream connections (webserver or other proxy)
			if (!notConnected()) {
				HTTP_Socket.close();
				HTTP_out.close();
				HTTP_in.close();
			}

			// 连接的数目减少一次
			httpServer.decreaseNumConnections();
			//end http session
			
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
	}

	public void sendLine(String s) throws IOException {
		write(out, s + "\r\n");
	}

	public void sendLine(String header, String s) throws IOException {
		write(out, header + ": " + s + "\r\n");
	}

	public void endHeader() throws IOException {
		write(out, "\r\n");
	}

	/** the main routine, where it all happens */

	int remote_port;
	InetAddress remoteHost;
	Jhttpp2Read remoteInputToMe = null;
	byte[] buf = null;
	int numread = 0;

	public void handleRequest() throws Exception {
		buf = new byte[65536];
		numread = clientInputStream.read(buf);
		System.out.println("numread is " + numread);

		// with this loop we support Keep-Alive connections
		while (true) {
			if (numread == -1) {
				System.out.println("state is " + clientInputStream.getStatusCode());
				// -1 signals an error
				if (clientInputStream.getStatusCode() != SC_CONNECTING_TO_HOST) {
					break; // return from main loop.
				} else {
					// 没有连接上从新连接
					System.out.println("从新连接。。。 " );
					reConnection();
				}
			}

			while (true) // reads data from the client
			{
				numread = clientInputStream.read(buf);
				
				// if (server.debug)server.writeLog("Jhttpp2HTTPSession: " + numread + " Bytes read.");
				if (numread != -1) {
					HTTP_out.write(buf, 0, numread);
					HTTP_out.flush();
					httpServer.addBytesWritten(numread);
				} else {
					break;
				}
			} // end of inner loop

		}// end of main loop
		
		out.flush();
		if (!notConnected() && remoteInputToMe != null)
			remoteInputToMe.close(); // close Jhttpp2Read thread
		return;
	}

	private void reConnection() throws Exception {
		// also an error because we are not connected (or to the wrong host)
		// Creates a new connection to a remote host.
		try {
			if (!notConnected()) {
				HTTP_Socket.close();
			}

			// get the header
			numread = clientInputStream.getHeaderLength();

			// sets up hostname and port
			remoteHost = clientInputStream.getRemoteHost();
			remote_port = clientInputStream.remote_port;

			connect(remoteHost, remote_port);
			
			if (!clientInputStream.isTunnel()) {
				// no SSL-Tunnel or SSL-Tunnel with another remote proxy: simply
				// forward the request
				HTTP_out.write(buf, 0, numread);
				HTTP_out.flush();
			} else { // SSL-Tunnel with "CONNECT": creates a tunnel
				// connection with the server
				sendLine(httpServer.getHttpVersion() + " 200 Connection established");
				sendLine("Proxy-Agent", httpServer.getHTTPServerIdentification());
				endHeader();
				out.flush();
			}
			
			// reads data from the remote server
			remoteInputToMe = new Jhttpp2Read(httpServer, this, HTTP_in, out);
			httpServer.addBytesWritten(numread);

		} catch (IOException e_close_socket) {
		}
	}

	/** connects to the given host and port */
	public void connect(InetAddress host, int port) throws IOException {
		HTTP_Socket = new Socket(host, port);
		HTTP_in = new ServerInputStream(httpServer, this, HTTP_Socket.getInputStream(), false);
		HTTP_out = new BufferedOutputStream(HTTP_Socket.getOutputStream());
	}

	/** converts an String into a Byte-Array to write it with the OutputStream */
	public void write(BufferedOutputStream o, String p) throws IOException {
		o.write(p.getBytes(), 0, p.length());
	}

	public Socket getLocalSocket() {
		return clientSocket;
	}

	public boolean notConnected() {
		return HTTP_Socket == null;
	}

	/**
	 * @since 0.4.10b
	 */
	public int getStatus() {
		return clientInputStream.getStatusCode();
	}
}
