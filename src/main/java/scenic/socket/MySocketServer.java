package scenic.socket;


import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 为了消息可以点对点的交流，需要客户端连接成功socket之后，有个身份认证的机制
 在socket连接成功之后，客户端给服务器发送一个指令，如下格式

 @identity:clientid:socketType
 clientid 是String类型的数据
 socketType 是Integer类型的，取值  1代表来自模拟器， 2代表来自控制程序，3代表来自命令行

 同时控制程序再发送每一条命令的时候都需要通过JSON携带clientid的数据

  * Created by scenic on 15/11/5.
 */
public class MySocketServer {

	private static ReadWriteLock myLock = new ReentrantReadWriteLock(false);

	public static List<SocketWrapper> sw = Collections.synchronizedList(new ArrayList<SocketWrapper>());

	private File logFile = new File(System.getProperty("user.dir") + "/" + getTTime()+"_log.txt");

	private String version= "1.3";

	private static BufferedWriter logOutput ;

	public static void main(String args[]) {
		sw.clear();
		new MySocketServer().run();
	}

	public  void run() {
		try {
			logOutput = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream( new FileOutputStream(logFile))));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		System.out.println("begin socket log file "+ logFile.getAbsolutePath() + " version " + version);

		try {
			@SuppressWarnings("resource")
			ServerSocket socket = new ServerSocket(8000);
			while (true){
				Socket sc = socket.accept();

				myLock.writeLock().lock();
				sw.add(new SocketWrapper(sc));
				System.out.println("Create SocketWrapper Ip: " + sc.getLocalAddress().getHostAddress() + " " + sw.size());
				myLock.writeLock().unlock();

				System.out.println("=========================================");

				myLock.readLock().lock();
				for(int i = 0; i < sw.size(); i++){
					System.out.println("ClientId is " + sw.get(i).clientId + " socketType is " + sw.get(i).socketType);
				}
				myLock.readLock().unlock();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
	public static String getTTime(){
		c.clear();
		c.setTimeInMillis(System.currentTimeMillis());
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		String time =
				year + "-" +
						month + "-" +
						date + "_" +
						hour + "-" +
						minute + "-" +
						second ;
		return time;
	}

	class SocketWrapper {

		//消息来自于模拟器
		private static final int MSG_TYPE_SIMULATE = 1;

		//消息来自于控制程序
		private static final int MSG_TYPE_CONTORL = 2;

		//消息来自于cmd 窗口
		private static final int MSG_TYPE_DEBUG_CMD = 3;

		private String clientId = "unknow";
		private int socketType = -1;
		//BlockingQueue<String> cmdQeue = new PriorityBlockingQueue<String>();

		private InputStream inputStream = null;
		private OutputStream outputStream = null;

		private Socket socket = null;

		private ReaderMsg reader;

		private Thread readerThread;

		private boolean isRun = true;

		private Calendar cc = Calendar.getInstance();//可以对每个时间域单独修改

		// 只有一条线程可以获取到这个方法
		private synchronized String getTime(){
			cc.clear();
			cc.setTimeInMillis(System.currentTimeMillis());
			int year = cc.get(Calendar.YEAR);
			int month = cc.get(Calendar.MONTH) + 1;
			int date = cc.get(Calendar.DATE);
			int hour = cc.get(Calendar.HOUR_OF_DAY);
			int minute = cc.get(Calendar.MINUTE);
			int second = cc.get(Calendar.SECOND);
			int milisecond = cc.get(Calendar.MILLISECOND);
			String time = year + "-" + month + "-" + date + "_"
					+ hour + "-" + minute + "-" + second + ":" + milisecond;
			return time;
		}

		private void close(){
			isRun = false;
			try {
				p("close：" + clientId);
				outputStream.close();
				inputStream.close();
				socket.close();
				readerThread.interrupt();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// 这里需要有一把锁来控制
			myLock.writeLock().lock();
			sw.remove(SocketWrapper.this);
			myLock.writeLock().unlock();
		}

		public SocketWrapper(Socket socket) {
			this.socket = socket;
			try {
				inputStream = socket.getInputStream();
				outputStream = socket.getOutputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}

			reader = new ReaderMsg();
			readerThread = new Thread(reader);
			readerThread.start();

			try {
				if (socket.isConnected()) {
					byte[] b = new byte[1024*100];
					int value = inputStream.read(b);

					if(value > 0){
						String str = new String(b,0,value);
						if(str.startsWith("@identity")){
							//身份验证消息
							try {
								String values[] = str.split(":");
								clientId = values[1];
								socketType = Integer.parseInt(values[2]);
								p("Get Identity Msg " + str + "  " + socket.getLocalAddress().getHostAddress());
							} catch (Exception e) {
								sendMessage("The msg fomat error " + e.getMessage());
								System.err.println("The msg fomat error " + e.getMessage());
							}
						}
					}

					// 这里需要有一把锁来控制
					myLock.writeLock().lock();
					for(int i = 0; i < sw.size(); i++){
						SocketWrapper tmp = sw.get(i);
						if(tmp.clientId != null && tmp.clientId.equals(clientId)){
							p("remove the same client id " + clientId);

							//sw.remove(tmp);
							tmp.close();



							i--;
						}
					}
					myLock.writeLock().unlock();

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public boolean sendMessage(String msg){
			try {
				if(!msg.contains("@identity")){
					msg = msg + "@end@";
				}
				outputStream.write(msg.getBytes());
				outputStream.flush();
				return true;
			}catch (SocketException e){
				p("SocketException " + e.getMessage() + " will remove  this SocketWrapper ");
				close();
			}catch (IOException e) {
				p("IOException " + e.getMessage() + " will remove  this SocketWrapper ");
				e.printStackTrace();
				close();
			}

			return false;
		}

		public void sendMessageToOther(String msg) {
			switch(socketType){
				case MSG_TYPE_SIMULATE:
					//模拟器发送给其他的客户端
					JSONObject jsonObj = null;
					try {
						jsonObj = new JSONObject(msg);;

					} catch (Exception e) {
						e.printStackTrace();
					}

					String msgClientID = null;
					if(jsonObj == null) {
						e("Error The JSON Str InValide " + msg);
					}else {
						if(jsonObj.has("clientId")){
							msgClientID = jsonObj.getString("clientId");
						}else {
							e("The msg can not find the clientId  " + msg);
						}
					}

					//这里需要有一把锁来控制
					myLock.readLock().lock();
					for(int i = 0 ; i < sw.size(); i++){
						SocketWrapper tmp = sw.get(i);
						if(tmp == this){
							continue;
						}else if(tmp.socketType == MSG_TYPE_DEBUG_CMD ){
							tmp.sendMessage(msg);
						}else if(tmp.socketType == MSG_TYPE_CONTORL){
							//如果是控制程序的话，需要进一步筛选
							if(msgClientID != null){
								if(tmp.clientId.equals(msgClientID)){
									if (true == tmp.sendMessage(msg) )
										p(clientId +  "----R---->" + tmp.clientId + " --->Success \r MSG " + msg);
									else
										e(clientId +  "----R---->" + tmp.clientId + " --->Failure \r MSG " + msg);

									System.out.println();
								}
							}else {
								tmp.sendMessage(msg);
							}
						}else {
							e("the socketType error " + tmp.socketType);
						}
					}
					myLock.readLock().unlock();

					break;

				case MSG_TYPE_DEBUG_CMD:
					//这里需要有一把锁来控制
					myLock.readLock().lock();
					for(int i = 0 ; i < sw.size(); i++){
						SocketWrapper tmp = sw.get(i);
						if(tmp == this){
							continue;
						}
						if(tmp.socketType == MSG_TYPE_SIMULATE ||
								tmp.socketType == MSG_TYPE_CONTORL){
							tmp.sendMessage(msg);
						}
					}
					myLock.readLock().unlock();
					break;

				case MSG_TYPE_CONTORL:
					//来自控制端的消息，需要发送给模拟器和命令行
					//这里需要有一把锁来控制
					myLock.readLock().lock();
					for(int i = 0 ; i < sw.size(); i++){
						SocketWrapper tmp = sw.get(i);
						if(tmp == this){
							continue;
						}

						if(tmp.socketType == MSG_TYPE_DEBUG_CMD){
							tmp.sendMessage(msg);
						}

						if(tmp.socketType == MSG_TYPE_SIMULATE){

							if ( true == tmp.sendMessage(msg) )
								p(clientId +  "----S---->" + tmp.clientId + " --> Success   \r MSG " + msg);
							else
								p(clientId +  "----S---->" + tmp.clientId + " --> Failure   \r MSG " + msg);
						}
					}
					myLock.readLock().unlock();
					break;

				default:
					myLock.readLock().lock();
					for(int i = 0 ; i < sw.size(); i++){
						SocketWrapper tmp = sw.get(i);
						if(tmp != this){
							tmp.sendMessage(msg);
						}
					}
					myLock.readLock().unlock();
					break;
			}
		}

		private void p(String str){
			if(str != null){
				writeFileAndPrint("=============================" + getTime()+ "==================================");
				writeFileAndPrint(str);
				writeFileAndPrint("===================================================================\n");
			}else {
				System.out.println();
			}
		}

		private void e(String str) {
			System.err.println("\t\t" + str);
			writeFileAndPrint(str);
		}

		private synchronized void writeFileAndPrint(String str){
			System.out.println(str);
			try {
				logOutput.write(str);
				logOutput.newLine();
				logOutput.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		class ReaderMsg implements Runnable {
			@Override
			public void run() {
				byte[] b = new byte[1024*1024*4];
				while (isRun) {
					try {
						Thread.sleep(100);

						if (socket.isConnected()) {
							//byte[] b = new byte[1024*1024*8];
							int value = inputStream.read(b);

							if(value > 0){
								String str = new String(b,0,value);

								//有可能收到多条消息，所以需要一个分隔符
								String[] tmp = str.split("@end@");
								for (String strValue : tmp) {
									sendMessageToOther(strValue);
								}

								str = null;
								tmp = null;
							}
						}else {
							p(" socket is not connected");
						}

					}catch(SocketException e){
						p("ReaderMsg SocketException Error " + e.getMessage() + " will remove this ");
						close();
					}catch(InterruptedException e){
						p("ReaderMsg InterruptedException Error " + e.getMessage() + " will remove this ");
						close();
					}catch(Exception e)
					{
						p("ReaderMsg InterruptedException Error " + e.getMessage() + " will remove this ");
						close();
						java.awt.Toolkit.getDefaultToolkit().beep();
					}
				}
			}
		}
	}

}
