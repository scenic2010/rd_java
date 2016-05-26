package scenic.uncomplie;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaShellUtil {
	// 基本路径
	private static final String basePath = "/tmp/";

	// 记录Shell执行状况的日志文件的位置(绝对路径)
	private static final String executeShellLogFile = basePath + "executeShell.log";

	public int executeShell(String shellCommand) throws IOException {
		int success = 0;
		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader bufferedReader = null;
		// 格式化日期时间，记录日志时使用
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS ");

		try {
			stringBuffer.append(dateFormat.format(new Date())).append("准备执行Shell命令 ").append(shellCommand).append(" \r\n");

			Process pid = null;
			String[] cmd = { "/bin/sh", "-c", shellCommand };
			// 执行Shell命令
			pid = Runtime.getRuntime().exec(cmd);
			if (pid != null) {
				stringBuffer.append("进程号：").append(pid.toString()).append("\r\n");
				// bufferedReader用于读取Shell的输出内容 bufferedReader = new
				// BufferedReader(new InputStreamReader(pid.getInputStream()),
				// 1024);
				pid.waitFor();
			} else {
				stringBuffer.append("没有pid\r\n");
			}
			stringBuffer.append(dateFormat.format(new Date())).append("Shell命令执行完毕\r\n执行结果为：\r\n");
			String line = null;
			// 读取Shell的输出内容，并添加到stringBuffer中
			while (bufferedReader != null && (line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line).append("\r\n");
			}
		} catch (Exception ioe) {
			stringBuffer.append("执行Shell命令时发生异常：\r\n").append(ioe.getMessage()).append("\r\n");
		} finally {
			if (bufferedReader != null) {
				OutputStreamWriter outputStreamWriter = null;
				try {
					bufferedReader.close();
					// 将Shell的执行情况输出到日志文件中
					OutputStream outputStream = new FileOutputStream(executeShellLogFile);
					outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
					outputStreamWriter.write(stringBuffer.toString());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					outputStreamWriter.close();
				}
			}
			success = 1;
		}
		if(MainClass.SHOW_DEBUG_MSG){
			System.out.println(stringBuffer.toString());
		}
		return success;
	}
	
	
	public void executeLocalCmd (String cmdStr) {
		try {
			Runtime rt = Runtime.getRuntime();
			Process proc = null;
			if (System.getProperties().getProperty("os.name").startsWith("Win")) {
				proc = rt.exec(new String[] { "cmd", "/c", cmdStr }, null);
			} else if (System.getProperties().getProperty("os.name").startsWith("Li")) {
				proc = rt.exec(new String[] { "/bin/sh", "-c", cmdStr },null);
			}

			// any error message?
			UnComplieClassThread errorGobbler = new UnComplieClassThread(proc.getErrorStream(), "warning");

			// any output?
			UnComplieClassThread outputGobbler = new UnComplieClassThread(proc.getInputStream(), "OUTPUT");

			// kick them off
			errorGobbler.start();
			outputGobbler.start();

			// any error???
			int exitVal = proc.waitFor();
			if(MainClass.SHOW_DEBUG_MSG){
				System.out.println("ExitValue: " + exitVal);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	class UnComplieClassThread extends Thread {
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
					if(MainClass.SHOW_DEBUG_MSG){
						MainClass.p("调用jad反编译" + type +">" + line);
					}
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
	
}