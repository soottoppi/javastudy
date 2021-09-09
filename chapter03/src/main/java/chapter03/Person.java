package chapter03;

public class Person {
	private String name;

	public Person() {
		System.out.println("Person() Called!");
	}
	
	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}
	
	
}
