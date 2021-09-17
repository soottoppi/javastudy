package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPEchoClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = UDPEchoServer.PORT;
	private static final int BUFFER_SIZE = UDPEchoServer.BUFFER_SIZE;

	public static void main(String[] args) {	
		DatagramSocket socket = null;
		Scanner scanner = null;
		try {
			// 1. Scanner 생성
			scanner = new Scanner(System.in);

			// 2. Socket 생성
			socket = new DatagramSocket();

			while (true) {
				System.out.print("> ");
				String line = scanner.nextLine();

				if ("exit".equals(line)) {
					break;
				}

				// 보내기
				byte[] sndData = line.getBytes("utf-8");
				DatagramPacket sndPacket = new DatagramPacket(
						sndData, 
						sndData.length,
						new InetSocketAddress(SERVER_IP, SERVER_PORT));
				socket.send(sndPacket);

				// 받기
				DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(rcvPacket); // blocking

				byte[] rcvData = rcvPacket.getData();
				int length = rcvPacket.getLength();
				String message = new String(rcvData, 0, length, "utf-8");

				System.out.println("< " + message);
			}
		} catch (IOException e) {
			System.out.println("error : " + e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
	}

}
