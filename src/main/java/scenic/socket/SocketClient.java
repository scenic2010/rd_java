package scenic.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by scenic on 2015/1/1.
 */
public class SocketClient {
    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        client.start();
    }

    public void start() {
        BufferedReader inputReader = null;
        BufferedReader reader = null;
        Socket socket = null;
        BufferedWriter bufferedWriter = null;
        try {
            socket = new Socket("127.0.0.1", 8989);
            inputReader = new BufferedReader(new InputStreamReader(System.in));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String inputContent;
            while (!(inputContent = inputReader.readLine()).equals("bye")) {
//                System.out.printf("" + inputContent);
                bufferedWriter.write(inputContent + "\n");
                bufferedWriter.flush();
                String msg = reader.readLine();
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                socket.close();
                inputReader.close();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
