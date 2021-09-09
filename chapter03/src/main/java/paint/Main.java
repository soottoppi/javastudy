package paint;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(10);
//		drawPoint(point1);
		draw(point1);
		
		Point point2 = new ColorPoint();
		point2.setX(100);
		point2.setY(200);
		((ColorPoint)point2).setColor("red");
//		drawPoint(point2);
		draw(point2);

		point2.show(false);
		point2.show(true);
		
		Triangle triangle = new Triangle();
//		drawTriangle(triangle);
//		drawPoint(triangle);
		draw(triangle);
		
		Rectangle rectangle = new Rectangle();
//		drawRectangle(rect);
//		drawShape(rectangle);
		draw(rectangle);
		
		Circle circle = new Circle();
//		drawCircle(circle);
//		drawShape(circle);
		draw(circle);
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
	/*
	 * public static void drawTriangle(Triangle triangle) { triangle.draw(); }
	 * 
	 * public static void drawRectangle(Rectangle rectangle) { rectangle.draw(); }
	 * 
	 * public static void drawCircle(Circle circle) { circle.draw(); }
	 */
}
