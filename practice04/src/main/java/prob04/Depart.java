package prob04;

public class Depart extends Employee {
	private String department;
	
	public Depart(String name, int salary, String department) {
		super(name, salary);
		this.department = department;
	}
	
	@Override
	public void getInformation() {
		System.out.println( "이름 : " + getName() + " 연봉 : " + getSalary() + " 부서 : " + this.department );
	}

	public final String getDepartment() {
		return department;
	}

	public final void setDepartment(String department) {
		this.department = department;
	}
	
}
