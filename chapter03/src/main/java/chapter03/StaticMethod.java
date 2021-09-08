package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		System.out.println(n);
	}
	
	void f2() {
		System.out.println(StaticMethod.m);
		// 같은 클래스에서는 클래스(static) 변수 접근에서는 클래스 이름 생략 가능.
		System.out.println(m);
	}
	
	void f3() {
		f2();
	}
	
	static void s1() {
//		오류: static method에서는 인스턴스 변수에 접근할 수 없다.
//		System.out.println(n);
	}
	
	static void s2() {
		System.out.println(StaticMethod.m);
		// 같은 클래스에서는 클래스(static) 변수 접근에서는 클래스 이름 생략 가능.
		System.out.println(m);
	}
	
	static void s3() {
//		오류 : static method에서는 인스턴스 메소드에 접근할 수 없다.
//		f1();
	}
	
	static void s4() {
		StaticMethod.s1();
		s1();
	}
	
//	 static method는 언제 쓰느냐 -> 순수함수를 쓸 때만.(바깥의 데이터 조작 안한다 -> 오류 날 가능성 x)
}