package Projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pt.iscte.guitoo.Point;
import pt.iscte.guitoo.PolylineFigure;

public class Linha extends Figuras implements PolylineFigure {
	private List<Point> points;
	
	public Linha(Point p1, Point p2) {
		super(p1);
		points = new ArrayList<>(2);
		points.add(p1);
		points.add(p2);
	}

	@Override
	public List<Point> getPoints() {
		return Collections.unmodifiableList(points);
	}

}
