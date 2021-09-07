package prob5;

public class Prob5 {

	public static void main(String[] args) {
		int numLength;
		for(int i=1; i<100; i++) {
			String resultText ="";
			int div = 10;
			
			numLength = (int)(Math.log10(i)+1);
			for(int j=0; j<numLength; j++) {
			
				if(i % div == 3 || i % div == 6 || i % div == 9) {
					resultText += "짝";
				}
				div *= 10;
			}
			System.out.println(i + " " + resultText);
			
				
				/* 
				 	일의 자리가 3,6,9 인 경우
					십의자리가 3,6,9 인경우
				    ... 결국 각 자리에 하나라도(||) 3,6,9 존재 시 짝 출력
				*/
			
		}
		
	}
}
