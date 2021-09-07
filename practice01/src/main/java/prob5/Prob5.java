package prob5;

public class Prob5 {

	public static void main(String[] args) {
		int numLength;
		int rem;
		int num;
		String resultText; 
		boolean isJJak;
		
		for(int i=1; i<100; i++) {
			num = i;
			resultText = "";
			isJJak = false;
			numLength = (int)(Math.log10(i)+1);
			
			for(int j=0; j<numLength; j++) {
				rem = num % 10;
				if(rem == 3 || rem == 6 || rem == 9) {
					resultText += "짝";
					isJJak = true;
				}
				num /= 10;
			}
			if(isJJak) {
				System.out.println(i + " " + resultText);	
			}
		}
	}
}
