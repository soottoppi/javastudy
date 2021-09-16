package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 6000;
	private static BufferedReader br;
	private static PrintWriter pw;

	public static void main(String[] args) {
		String nickName = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;

		// 1. 닉네임 입력받기
		while (true) {

			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			nickName = scanner.nextLine();

			if (nickName.isEmpty() == false) {
				break;
			}

			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}

		try {
			// 2. 소켓 생성
			socket = new Socket();
			// 3. 소켓 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			// 4. Reader / Writer 생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			// 5. JOIN 프로토콜
			pw.println("join:" + nickName);
			pw.flush();

			// 6. CharClientReceiveThread 시작
			new ChatClientReceiveThread(br).start();

			// 7. 키보드 입력 처리
			while (true) {
				String input = scanner.nextLine();

				if ("quit".equals(input)) {
					// quit 처리
					pw.println("quit:");
					pw.flush();
					break;
				} else {
					// message 처리
					pw.println("message:" + input);
				}
			}

		} catch (SocketException e) {
			log("suddenly closed by server");
		} catch (IOException e) {
			log("error : " + e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

//		new ChatWindow(nickName).show();
	}

	private static void log(String log) {
		System.out.println("[Client] " + log);
	}

}
