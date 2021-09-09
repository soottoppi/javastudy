package com.douzone.paint.shape;

public class Triangle extends Shape {
	private int x1, y1;
	private int x2, y2;
	private int x3, y3;
	
	@Override
	public void draw() {
		System.out.println("삼각형을 그렸습니다.");
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
	public final int getX2() {
		return x2;
	}
	public final void setX2(int x2) {
		this.x2 = x2;
	}
	public final int getY2() {
		return y2;
	}
	public final void setY2(int y2) {
		this.y2 = y2;
	}
	public final int getX3() {
		return x3;
	}
	public final void setX3(int x3) {
		this.x3 = x3;
	}
	public final int getY3() {
		return y3;
	}
	public final void setY3(int y3) {
		this.y3 = y3;
	}
}
