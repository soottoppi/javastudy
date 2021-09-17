package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickName;
	private Socket socket;
	private List<Writer> listWriters;
	private BufferedReader br = null;
	private PrintWriter pw = null;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		// 1. Remote Host Information
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetRemoteSocketAddress.getPort();
		log("클라이언트로부터 연결되었습니다." + "[" + remoteHostAddress + ":" + remoteHostPort + "]");

		// 2. 스트림 얻기
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			// 3. 요청 처리
			while (true) {
				String request = br.readLine();
				if (request == null) {
					log("클라이언트로부터 연결이 끊어졌습니다." + "[" + remoteHostAddress + ":" + remoteHostPort + "]");
					doQuit(pw);
					break;
				}

				// 4. 프로토콜 분석
				String[] tokens = request.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(pw);
					break;
				} else {
					log("error : 알 수 없는 요청(" + tokens[0] + ")");
				}

			}
		} catch (IOException e) {
			doQuit(pw);
			log("error : " + e);
		} finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
					log("클라이언트로부터 연결이 끊어졌습니다." + "[" + remoteHostAddress + ":" + remoteHostPort + "]");
				}
				if (br != null) {
					br.close();
				}
				if (pw != null) {
					pw.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void doQuit(PrintWriter pw) {
		removeWriter(pw);
		String data = "quit:" + nickName + "님이 퇴장하였습니다.";
		broadcast(data);
	}

	private void doMessage(String msg) throws IOException {
		String data = "message:" + nickName + " >> " + ":" + msg;
		broadcast(data);
	}

	private void doJoin(String nickName, PrintWriter pw) {
		this.nickName = nickName;

		// 브로드캐스팅
		String data = "join:" + nickName + "님이 참여하였습니다.";
		broadcast(data);

		// writer 등록
		addWriter(pw);

		// ack
		pw.println("join:대화방에 입장하셨습니다.");
		pw.flush();

	}

	private void broadcast(String data) {
		// 모든 writerList에 있는 client에게 메시지 전송
		for (Writer writer : listWriters) {
			PrintWriter pw = (PrintWriter) writer;
			pw.println(data);
			pw.flush();
		}
	}

	private void removeWriter(PrintWriter pw) {
		// listWriter에서 pw를 찾아 삭제
		synchronized (pw) {
			listWriters.remove(pw);
		}

	}

	private void addWriter(PrintWriter pw) {
		synchronized (pw) {
			listWriters.add(pw);
		}
	}

	private void log(String log) {
		System.out.println("[ServerThread] " + log);
	}

}
