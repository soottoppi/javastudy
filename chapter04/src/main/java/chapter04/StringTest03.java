package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		// String s1 = "Hello" + "World" + "Java" + 1.8;
		String s1 = new StringBuffer("Hello ")
		.append("World ")
		.append("Java ")
		.append(1.8)
		.toString();	// 메소드 계속 호출 가능
						
//		System.out.println(s1);
		
		// StringBuffer를 써야하는 경우
		String s2 = "";
		for(int i = 0 ; i < 1000000; i++) {
			// s2 += i;
			// s2 = new StringBuffer(s2).append(i).toString();
			// 메모리를 계속해서 할당하기 때문에 연산량이 많을 경우 비효율적
			
			
		}
//		System.out.println(s2.length());
		
		
		StringBuffer sb = new StringBuffer("");
		for(int i = 0 ; i < 1000000; i++) {
			sb.append(i);
		}
		String sb2 = sb.toString();
//		System.out.println(sb2.length());
		
		// String method들...
		String s4 = "aBcABCabcAbc";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.indexOf("abc", 7));
		System.out.println(s4.substring(3));
		System.out.println(s4.substring(3, 5));
		
		String s5 = "     ab       cd      ";
		String s6 = "efg,hij,klm,nop,qrs";
		
		String s7 = s5.concat(s6);
		System.out.println(s7);
		System.out.println(s5.trim());
		System.out.println("-----" + s5.trim() + "----");
		System.out.println("-----" + s5.replaceAll(" ", "") + "----");
		String[] tokens = s6.split(",");
		for(String str : tokens) {
			System.out.println(str);
		}
		String[] tokens2 = s6.split(" ");
		for(String str : tokens2) {
			System.out.print(str);		// " "로 split을 못하니 전체 배열을 리턴
		}
	}

}
