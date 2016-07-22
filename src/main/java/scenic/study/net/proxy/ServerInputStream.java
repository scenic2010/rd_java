package scenic.study.net.proxy;/* Written and copyright 2001 Benjamin Kohl.
 * Distributed under the GNU General Public License; see the README file.
 * This code comes with NO WARRANTY.
 */

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.IOException;

public class ServerInputStream extends BufferedInputStream implements
		JInputStream {
	public ServerInputStream(scenic.study.net.proxy.HttpServer server, scenic.study.net.proxy.HTTPSession connection,
							 InputStream a, boolean filter) {
		super(a);
	}

	public int read_f(byte[] b) throws IOException {
		return read(b);
	}
}
