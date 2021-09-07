package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {
     	int resultValue = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int num = scanner.nextInt();
		if(num > 0) {
			if(num % 2 == 0) {
				for(int i=0; i<=num ; i+=2) {
					resultValue += i; 
				}
				System.out.println("결과 값 : " + resultValue);

			} else {
				for(int i=1; i<=num; i+=2) {
					resultValue += i;
				}
				System.out.println("결과 값 : " + resultValue);
			}
		}
		
		scanner.close();
	}
}
