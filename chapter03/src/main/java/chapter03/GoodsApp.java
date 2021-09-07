package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();
		goods.setName("Nikon");
		goods.setPrice(2000);
		goods.setCountStock(10);
		goods.setCountSold(20);
		System.out.println(goods.toString());
	}

}
