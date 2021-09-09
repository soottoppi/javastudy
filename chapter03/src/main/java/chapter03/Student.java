package chapter03;

public class Student extends Person {
	private int grade;
	private String major;
	
	public Student() {
		// 자식의 모든 생성자에서
		// 부모의 특정 생성자를 명시(explicity)하지 않으면
		// 암시적(implicity)으로 부모의 기본 생성자가
		// 자식 생성자 보드 앞에 호출된다.
		// super();
		System.out.println("Student( ) Called!");
	}
	public final int getGrade() {
		return grade;
	}
	public final void setGrade(int grade) {
		this.grade = grade;
	}
	public final String getMajor() {
		return major;
	}
	public final void setMajor(String major) {
		this.major = major;
	}
	
	
}
