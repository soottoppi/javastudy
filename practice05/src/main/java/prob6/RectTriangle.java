package prob6;

public class RectTriangle extends Shape {

	public RectTriangle(int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	@Override
	public double getArea() {
		return (getWidth() * getHeight()) / 2; 
	}

	@Override
	public double getPerimeter() {
		return 0;	// 얘만 수정하면 끝
	}
}
