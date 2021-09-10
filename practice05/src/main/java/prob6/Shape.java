package prob6;

public abstract class Shape {
	private double width;
	private double height;

	public abstract double getArea();

	public abstract double getPerimeter();

	public Shape(double width, double height) {
		this.width = width;
		this.height = height;
	}

	final double getWidth() {
		return width;
	}

	final void setWidth(double width) {
		this.width = width;
	}

	final double getHeight() {
		return height;
	}

	final void setHeight(double height) {
		this.height = height;
	}
}
