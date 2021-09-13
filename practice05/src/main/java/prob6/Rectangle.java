package prob6;

public class Rectangle extends Shape implements Resizable {
	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return (width * height);
	}

	@Override
	public void resize(double d) {
		width *= d;
		height *= d;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return (width + height) * 2;
	}
}
