package chapter04;

public class MyClass {
	private static MyClass instance = null;
	
	private MyClass() {
		
	}
	
	// Singleton + Factory Method
	public static MyClass getInstance() {
		if(instance == null) {
			instance = new MyClass();
		}
		
		return new MyClass();
	}
}
