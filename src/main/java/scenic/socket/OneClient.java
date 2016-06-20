package scenic.socket;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class OneClient {
	final Properties prop = new Properties();
	String extendsPath = System.getProperty("user.dir") + "/config.properties";

	public static void main(String args[]) {
		new OneClient().run();
	}

	private void run() {
		executeConfig();

		Socket socket = null;
		try {
			String ip = getExtendsConfigKey("serverIP");

			System.out.println("Connect ServerIP is " + ip);
			socket = new Socket(ip, 8000);

			new Thread(new WriteMsg(socket)).start();
			new Thread(new ReaderMsg(socket)).start();

		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}


	private String getExtendsConfigKey(String key){
		String cmd = null;
		try {
			InputStream extendsConfigInput = new FileInputStream(extendsPath);
			prop.load(extendsConfigInput);
			cmd = prop.getProperty(key);
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		return cmd;
	}

	private void executeConfig() {
		System.out.println("extends config Path " + extendsPath );

		new Thread((new Runnable() {
			@Override
			public void run() {
				String line;
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				try {
					while ((line = bufferedReader.readLine()) != "exit") {
						String cmd = null;

						if(cmd == null){
							cmd = getExtendsConfigKey(line);
						}

//						if(cmd == null){
//							cmd = getConfigKey(line);
//						}


						if(cmd == null){
							cmd = line;
						}

						if (cmd != null && cmd.length() >= 1) {
							cmdQeue.add(cmd);
						}

						Thread.sleep(100);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		})).start();

	}

	BlockingQueue<String> cmdQeue = new PriorityBlockingQueue<String>();

	class ReaderMsg implements Runnable {
		Socket socket;

		public ReaderMsg(Socket s) {
			this.socket = s;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(100);
					if (socket.isConnected()) {
						InputStream br = socket.getInputStream();
						byte[] b = new byte[1024 * 1024 * 8];
						int value = br.read(b);
						String str = new String(b, 0, value);
						System.out.println("Get MSG From Server : " + str);
						System.out.println("============================================");
					} else {

					}

				} catch (SocketException e) {
					System.out.println("服务器异常，请重启");
					System.exit(0);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	class WriteMsg implements Runnable {
		private Socket socket;
		OutputStream out = null;

		public WriteMsg(Socket s) {
			socket = s;
			try {
				out = socket.getOutputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sendMessage("@identity:CmdClient:3");
		}

		@Override
		public void run() {

			while (true) {
				try {
					Thread.sleep(100);
					if (cmdQeue.size() > 0) {
						String cmd = cmdQeue.take();
						sendMessage(cmd);
					}
				}

				catch (InterruptedException e) {
					System.out.println("close write instance " + this);
					break;
				}

			}

		}

		public void sendMessage(String msg) {
			try {

				out.write(msg.getBytes());
				out.flush();
				System.out.println("Send Cmd " + msg);
			} catch (SocketException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
