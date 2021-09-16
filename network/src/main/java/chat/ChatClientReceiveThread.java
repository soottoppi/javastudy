package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientReceiveThread extends Thread {
	private Socket socket = null;
	private BufferedReader br = null;

	public ChatClientReceiveThread(Socket socket, BufferedReader br) {
		this.socket = socket;
		this.br = br;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String response = br.readLine();
				if (response == null) {
					log("closed by server");
					break;
				}

				String[] tokens = response.split(":");
				if ("join".equals(tokens[0])) {
					echoJoin(tokens[1]);
				} else if ("message".equals(tokens[0])) {
					echoMessage(tokens[1], tokens[2]);
				} else if ("quit".equals(tokens[0])) {
					echoQuit(tokens[1]);
				}
			}
			
		} catch (SocketException e) {
			log("error : " + e);
		} catch (IOException e) {
			log("error2 : " + e);

		} 
	}

	private void echoQuit(String msg) {
		System.out.println(msg);
	}

	private void echoJoin(String msg) {
		System.out.println(msg);
	}

	private void echoMessage(String nickName, String msg) {
		System.out.println(nickName + msg);

	}

	private void log(String log) {
		System.out.println("[ClientThread] " + log);
	}

}
