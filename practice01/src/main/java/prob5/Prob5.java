package prob5;

public class Prob5 {

	public static void main(String[] args) {
		int numLength;
		int rem;
		
		
		for(int i=1; i<100; i++) {
			boolean isJJak = false;
			String resultText ="";
			int div = 1;
			
			numLength = (int)(Math.log10(i)+1);
			for(int j=0; j < numLength; j++) {
				rem = i % 10;
				
				if(i % div == 3 || i % div == 6 || i % div == 9) {
					resultText += "짝";
					isJJak = true;
				}
				rem /= 10;
				
			}
			if(isJJak) {
				System.out.println(i + " " + resultText);	
			}
			
		}
		
	}
}
