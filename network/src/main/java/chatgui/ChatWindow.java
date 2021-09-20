package chatgui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	private Socket socket;
	private static BufferedReader br;
	private static PrintWriter pw;

	public ChatWindow(String name, Socket socket, BufferedReader br, PrintWriter pw) {
		this.socket = socket;
		ChatWindow.br = br;
		ChatWindow.pw = pw;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);

	}

	public void show() {

		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		// 인터페이스 메소드가 하나인 경우에만 람다식으로 추론해냄
		// buttonSend.addActionListener( ( actionEvent ) ->
		// System.out.println("Click!!!!"));
		buttonSend.addActionListener((actionEvent) -> {
			sendMessage();
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();

		// ChatClientReceiveThread 시작
		new ChatClientThread().start();
	}

	private static void sendQuit() {
		pw.println("quit:");
		pw.flush();
	}

	private void sendMessage() {
		String message = textField.getText();
		if ("quit".equals(message)) {
			// 서버에 quit 송신
			sendQuit();
			finish();
		} else {
			// 입력값없이 바로 엔터 쳤을 경우
			if ("".equals(message)) {
				message = " ";
			}
			// 서버에 message 송신
			pw.println("message:" + message);

		}
		// 텍스트필드 초기화
		textField.setText("");
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private void finish() {
		System.exit(0);
	}

	private class ChatClientThread extends Thread {
		public void run() {
			try {
				while (true) {
					String response = br.readLine();
					// Client가 quit 입력 시 서버의 pw리스트에서 삭제되어 응답을 못받을 경우 종료
					if (response == null) {
						break;
					}
					// 수신 프로토콜 분석
					String[] tokens = response.split(":");
					if ("join".equals(tokens[0])) {
						echoJoin(tokens[1]);
					} else if ("message".equals(tokens[0])) {
						echoMessage(tokens[1], tokens[2]);
					} else if ("quit".equals(tokens[0])) {
						echoQuit(tokens[1]);
					}
				}
			} catch (IOException e) {
				log("error : " + e);
			} finally {
				try {
					if (br != null) {
						br.close();
					}

					if (pw != null) {
						pw.close();
					}

					if (socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		private void echoQuit(String msg) {
			updateTextArea(msg);
		}

		private void echoJoin(String msg) {
			updateTextArea(msg);
		}

		private void echoMessage(String nickName, String msg) {
			updateTextArea(nickName + msg);
		}

		private void log(String log) {
			System.out.println("[ClientThread] " + log);
		}
	}

}
