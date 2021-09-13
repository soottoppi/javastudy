package prob02;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			System.out.print( "두 정수와 연산자를 입력하시오 >> " );
			String expression = scanner.nextLine();
			
			if( "quit".equals( expression ) ) {
				break;
			}
			
			String[] tokens = expression.split( " " );
			
			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt( tokens[ 0 ] );	// 숫자 1
			int rValue = Integer.parseInt( tokens[ 2 ] );	// 숫자 2
			
			Arithmetic arithmetic = null;
			
			/* 코드 작성 */
			switch(tokens[1]) {
				case "+" : arithmetic = new Add();
							break;
				case "-" : arithmetic = new Sub();
							break;
				case "*" :	arithmetic = new Mul();
							break;
				case "/" : arithmetic = new Div();
							break;
				default : System.out.println("잘못된 연산자 입니다.");
							return;
			}
			
			int result = arithmetic.calculate(lValue, rValue);
			System.out.println( ">> " + result );
		}
		
		scanner.close();
	}
}