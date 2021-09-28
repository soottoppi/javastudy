package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 8000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();

			serverSocket.bind(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("starts... [port : " + SERVER_PORT + "]");

			while(true) {
				Socket socket = serverSocket.accept();
				// 9.16 추가
				new EchoServerReceiveThread(socket).start();
				
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

	public static void log(String log) {
		System.out.println("[EchoServer] " + log);
	}

}
