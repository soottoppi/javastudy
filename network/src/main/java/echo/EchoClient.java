package echo;

import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("> ");
			String line = scanner.nextLine();
			
			if("exit".equals(line)) {
				break;
			}
		}
	}

}
