package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	public static final int PORT = 7000;
	public static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			// 1. 소켓 생성
			socket = new DatagramSocket(PORT);
			
			while(true) {
				// 2. 데이터 수신
				DatagramPacket rcvPacket = new DatagramPacket(new byte[1024], 1024);
				socket.receive(rcvPacket);

				byte[] rcvData = rcvPacket.getData();
				int length = rcvPacket.getLength();
				String message = new String(rcvData, 0, length, "utf-8");

				System.out.println("[Server] receive : " + message);

				// 3. 데이터 송신
				byte[] sndData = message.getBytes("utf-8");
				DatagramPacket sndPacket = new DatagramPacket(
						sndData, 
						sndData.length, 
						rcvPacket.getAddress(), 
						PORT);
				socket.send(sndPacket);
			}
		} catch (SocketException e) {
			System.out.println("error : " + e);
		} catch (IOException e) {
			System.out.println("error : " + e);
		} finally {
			if (socket != null & !socket.isClosed()) {
				socket.close();
			}
		}
	}

}
