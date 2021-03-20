package Projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pt.iscte.guitoo.Point;
import pt.iscte.guitoo.PolylineFigure;

public class Rectangle extends Figuras implements PolylineFigure {
	private List<Point> points;

	public Rectangle(int width, int height) {
		super();
		points = new ArrayList<>(4);
		points.add(Point.ORIGIN);
		points.add(new Point(0, height - 1));
		points.add(new Point(width - 1,height-1));
		points.add(new Point(width - 1,0));
	}

	@Override
	public List<Point> getPoints() {
		return Collections.unmodifiableList(points);
	}

}
