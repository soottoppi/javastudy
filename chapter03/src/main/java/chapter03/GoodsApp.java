package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
//		countOfGoods는 클래스 변수이기 때문에 객체 생성없이 사용 가능
//		System.out.println(Goods.countOfGoods);
		
		Goods goods = new Goods();
		goods.setName("Nikon");
		goods.setPrice(2000);
		goods.setCountStock(10);
		goods.setCountSold(20);
		goods.showInfo();
		
		
		goods.setPrice(-1);
		int discountPrice = goods.calcDiscountPrice(50);
		System.out.println("discountPrice : " + discountPrice);
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
		
		String s = "콜라 1000 20";
		String[] token = s.split(" ");
		for(String str : token) {
			System.out.println(str);
		}
	}

}
