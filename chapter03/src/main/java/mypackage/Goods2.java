package mypackage;

public class Goods2 {
	public String name;		// 모든 접근 가능(접근 제한이 없다)
	protected int price;	// 같은 패키지 및 *자식클래스이 가능
	int countStock;			// 디폴트, 같은 패키지만 접근이 가능
	private int countSold;	// 해당 클래스 내부에서만 접근이 가능
	
	void m() {
		countSold = 100;
	}
}
