package chatgui;
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
	private static final String SERVER_IP = "0.0.0.0";
	private static final int SERVER_PORT = 6100;
	protected static BufferedReader br;
	protected static PrintWriter pw;

	public static void main(String[] args) {
		
		String nickName = null;
		@SuppressWarnings("resource")
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
			
			String line = br.readLine();
			String[] tokens = line.split(":");
			if ("join".equals(tokens[0])) {
				new ChatWindow(nickName, socket, br, pw).show();
			} else {
				return;
			}
		} catch (SocketException e) {
			log("suddenly closed by server");
		} catch (IOException e) {
			log("error : " + e);
		} 
	}

	private static void log(String log) {
		System.out.println("[Client] " + log);
	}

}