package paint;

public class Circle extends Shape{
	private int x1, y1;
	private int radius;
	
	@Override
	public void draw() {
		System.out.println("원을 그렸습니다.");
	}

	public final int getX1() {
		return x1;
	}

	public final void setX1(int x1) {
		this.x1 = x1;
	}

	public final int getY1() {
		return y1;
	}

	public final void setY1(int y1) {
		this.y1 = y1;
	}

	public final int getRadius() {
		return radius;
	}

	public final void setRadius(int radius) {
		this.radius = radius;
	}
	
	
}
