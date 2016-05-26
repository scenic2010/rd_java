package scenic.net.proxy;/* Written and copyright 2001 Benjamin Kohl.
 * Distributed under the GNU General Public License; see the README file.
 * This code comes with NO WARRANTY.
 */

/**
 * Title: jHTTPp2: Java HTTP Filter Proxy Description: starts thwe Swing GUI or
 * the console-mode only proxy Copyright: Copyright (c) 2001
 * @author Benjamin Kohl
 */

public class Launcher {

	static HttpServer server;

	/** Main method */
	public static void main(String[] args) {
		// no window, only console output
		server = new HttpServer();
		new Thread(server).start();
	}
}
