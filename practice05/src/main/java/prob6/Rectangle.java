package prob6;

public class Rectangle extends Shape implements Resizable{

	public Rectangle(int width, int height) {
		setWidth(width);
		setHeight(height);
	}
	
	@Override
	public double getArea() {
		return (getWidth() * getHeight());
	}

	@Override
	public void resize(double d) {
		setWidth(getWidth() * d);
		setHeight(getHeight() * d);
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return (getWidth() + getHeight()) * 2;
	}
}
