package paint;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(10);
		drawPoint(point1);
//		point1.disapear();
		point1.show(false);
	}
	
	public static void drawPoint(Point point) {
		point.show();
	}
}
