package chapter04;

public class MyClassTest {
	public static void main(String[] args) {
		
		MyClass myClass1 = MyClass.getInstance();
		MyClass myClass2 = MyClass.getInstance();
		
		System.out.println(myClass1 == myClass2);
	}
}
