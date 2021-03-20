package Projeto;

import pt.iscte.guitoo.Color;
import pt.iscte.guitoo.Point;
import pt.iscte.guitoo.StandardColor;

public abstract class Figuras {
	private Color color;
	private Point location;
	
	public Figuras() {
		location = Point.ORIGIN;
		color = StandardColor.WHITE;
	}
	
	public Figuras(Point p) {
		p = Point.ORIGIN;
		location = p;
		color = StandardColor.WHITE;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	
	public Color getFillColor() {
		return this.color;
	}
	
	public void move(int x, int y) {
		this.location = this.location.sum(x, y);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}


	
	

}
