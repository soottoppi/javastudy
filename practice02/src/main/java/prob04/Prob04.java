package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		char[] revChar = str.toCharArray();
		char tmp;
		int len = str.length();
		for(int i=0; i < len/2 ; i++) {
			tmp = revChar[len-i-1];
			revChar[len-i-1] = revChar[i];
			revChar[i] = tmp;
		}
		
		return revChar;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}