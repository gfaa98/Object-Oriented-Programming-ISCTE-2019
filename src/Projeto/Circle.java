package Projeto;

import pt.iscte.guitoo.EllipseFigure;
import pt.iscte.guitoo.Point;

public class Circle extends Figuras implements EllipseFigure {
	private int size;

	public Circle(int size) {
		super();
		this.size = size;
		
	}

	@Override
	public int getHeight() {
		return size;
	}

	@Override
	public int getWidth() {
		return size;
	}
	
	
}