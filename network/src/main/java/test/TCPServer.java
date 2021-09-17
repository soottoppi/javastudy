package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();

			// 1-1. TIME_WAIT 상태에서도 소켓 포트 번호 할당이 가능하도록 하기 위해서..
			serverSocket.setReuseAddress(true);
			
			// 2. 바인딩(binding)
			// -> Socket에 InetSocketAddress(IPAddress + port)
			// IPAddress : 0.0.0.0 : 모든 IP로 부터의 연결을 허용
			// 특정 호스트 IP바인딩을 하지 않는다.
			// port : 5000번 포트로 바인딩
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10);

			// 3. accept
			// -> 클라이언트로 부터 연결 요청을 기다린다.
			Socket socket = serverSocket.accept(); // blocking(멈춤)

			// 3-1. 연결된 요청을 socket 객체에 담는다
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			System.out.println("[Server] connetcted by client[" + remoteHostAddress + ":" + remoteHostPort + "]");

			// 3-2. Xshell5에서 telnet 127.0.0.1 5000 명령어를 입력하면 연결
			System.out.println("연결!!!!!!");
			try {
				// 4. IO Stream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				while (true) {
					// 5. 데이터 읽기
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); // blocking
					if (readByteCount == -1) {
						// 클라이언트가 정상적으로 종료(close() 호출)
						System.out.println("[Server] closed by client");
						break;
					}
					
					// 디코딩
					String data = new String(buffer, 0, readByteCount, "utf-8");
					System.out.println("[Server] received : " + data);
					
					// 5. 데이터 쓰기
					try {
						Thread.sleep(2000);
						os.write(data.getBytes("utf-8")); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} catch (SocketException ex) {
				System.out.println("[Server] suddenly closed by client");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			System.out.println("[Server Error] : " + e);
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
}
