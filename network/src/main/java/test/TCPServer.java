package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩(binding)
			// 	-> Socket에 InetSocketAddress(IPAddress + port)
			// IpAddress : 0.0.0.0 : 모든 IP로 부터의 연결을 허용
			// port : 5000번 포트로 바인딩
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000));
			
			// 3. accept
			// 	-> 클라이언트로 부터 연결 요청을 기다린다.
			Socket socket = serverSocket.accept();	// blocking(멈춤)
			
			// 연결된 요청을 socket 객체에 담는다
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			System.out.println("[Server] connetcted by client[" + remoteHostAddress + ":" + remoteHostPort + "]");
			
			// 4. Xshell5에서 telnet 127.0.0.1 5000 명령어를 입력하면 연결
			System.out.println("연결!!!!!!"); 
			
			
		} catch (IOException e) {
			System.out.println("[Server Error] : " + e);
		} finally {
			try {
				if(serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
