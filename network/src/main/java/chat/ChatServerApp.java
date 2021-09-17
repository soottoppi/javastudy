package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerApp extends Thread {
	private static final String SERVER_IP = "0.0.0.0";
	private static final int SERVER_PORT = 6000;
	private static List<Writer> listWriters = new ArrayList<Writer>();

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("클라이언트의 연결을 기다리는중... " + hostAddress + ":" + SERVER_PORT);

			// 3. 요청 대기
			while (true) {
				socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters).start();
			}

		} catch (IOException e) {
			log("error : " + e);
		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}

				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private static void log(String log) {
		System.out.println("[Server] " + log);
	}
}
