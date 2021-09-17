package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		/**
		 *  1. UI 초기화
		 */
		
		
		
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		// 인터페이스 메소드가 하나인 경우에만 람다식으로 추론해냄
		// buttonSend.addActionListener(  ( actionEvent ) -> System.out.println("Click!!!!"));
		buttonSend.addActionListener(  ( actionEvent ) -> {
				System.out.println("Click!!!!");
				// textfield의 값을 보낸다
				sendMessage();
		});
		 
		
		
		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
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
		
		/*
		 *  2. IOStream 가져오기
		 */
		
		/*
		 *  3. Chat Client Thread 생성
		 */
	}
	
	private void sendMessage() {
		String message = textField.getText();
		System.out.println("message:" + message);
		textField.setText("");
		textField.requestFocus();
		
		// Receive Thread에서 서버로부터 받은 메시지가 있다고 치고~(가짜 데이터)
		updateTextArea("마이콜:" + message);
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private void finish() {
		System.out.println("소켓 닫기 or 방나가기 프로토콜 구현!");
		System.exit(0);
	}
	private class ChatClientThread extends Thread {
		public void run() {
			updateTextArea(".....");
		}
	}
}
