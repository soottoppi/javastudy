package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class EchoServerReceiveThread extends Thread{
	
	private Socket socket = null;
	
	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetRemoteSocketAddress.getPort();
		log("connetcted by client[" + remoteHostAddress + ":" + remoteHostPort + "]");

		try {
			// socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			while (true) {
				String data = br.readLine();
				if (data == null) {
					log("closed by client");
					break;
				}
				
				log("received : " + data);
				pw.println(data);
			}
		} catch(IOException e) {
			log("error : " + e);
		} finally {
			try {
				if(socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void log(String string) {
		System.out.println("[Echo Server]  " + string);
	}
}