package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerApp extends Thread{
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 6000;
	private static List<Writer> listWriters = new ArrayList<Writer>();
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("연결 기다림 " + hostAddress + ":" + SERVER_PORT);
			
			// 3. 요청 대기
			while(true){
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters).start();
			}
			
			
		} catch (IOException e) {
			log("error : " + e);
		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
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
