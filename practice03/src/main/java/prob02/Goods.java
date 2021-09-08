package prob02;

public class Goods {
	private String name;
	private int price;
	private int count;

	public Goods(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public void show() {
		System.out.println(
				this.name + "(가격 : " +
				this.price + "원)이 " +
				this.count + "개 입고 되었습니다."
				);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getCount() {
		return count;
	}

}
