package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		// String s1 = "Hello" + "World" + "Java" + 1.8;
		String s1 = new StringBuffer("Hello ")
		.append("World ")
		.append("Java ")
		.append(1.8)
		.toString();	// 메소드 계속 호출 가능
						
		System.out.println(s1);
		
		// StringBuffer를 써야하는 경우
		String s2 = "";
		for(int i = 0 ; i < 1000000; i++) {
			// s2 += i;
			// s2 = new StringBuffer(s2).append(i).toString();
			// 메모리를 계속해서 할당하기 때문에 연산량이 많을 경우 비효율적
			
			
		}
		System.out.println(s2.length());
		
		
		StringBuffer sb = new StringBuffer("");
		for(int i = 0 ; i < 1000000; i++) {
			sb.append(i);
		}
		String sb2 = sb.toString();
		System.out.println(sb2.length());
	}

}
