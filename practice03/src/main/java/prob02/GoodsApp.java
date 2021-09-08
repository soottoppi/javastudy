package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		System.out.println("실행결과 : ");
		for(int i=0; i < COUNT_GOODS; i++) {
			String strName = scanner.next();
			int strPrice = scanner.nextInt();
			int strCount = scanner.nextInt();
			goods[i] = new Goods(strName, strPrice, strCount);
		}
		// 상품 출력
		for(Goods good : goods) {
			good.show();
		}
		// 자원정리
		scanner.close();
	}
}
