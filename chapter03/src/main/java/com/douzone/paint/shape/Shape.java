package com.douzone.paint.shape;

import com.douzone.paint.i.Drawable;

public abstract class Shape implements Drawable {
	private String lineColor;
	private String fillColor;
	
	public abstract void draw();
	
	public final String getLineColor() {
		return lineColor;
	}
	public final void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}
	public final String getFillColor() {
		return fillColor;
	}
	public final void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}
	
	
}
