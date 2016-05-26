package scenic.uncomplie;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UnComplieClassThread extends Thread {
	InputStream is;
	String type;

	public UnComplieClassThread(InputStream is, String type) {
		this.is = is;
		this.type = type;
	}

	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null){
				MainClass.p("调用jad.exe反编译" + type +">" + line);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}

