package prob3;

public class Duck extends Bird {
	public void fly() {
		System.out.println("오리(" + name + ")는 " + "날지 않습니다.");
	}
	
	public void sing() {
		System.out.println("오리(" + name + ")가 " + "소리내어 웁니다.");
	}
}
