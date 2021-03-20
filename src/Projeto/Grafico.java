package Projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pt.iscte.guitoo.CompositeFigure;
import pt.iscte.guitoo.Figure;
import pt.iscte.guitoo.Location;
import pt.iscte.guitoo.Point;

public abstract class Grafico implements CompositeFigure {
	private Point location;
	private List<Figure> children;
	private EsquemaCores cores;
	private Data data;
	
	public Grafico(int x,int y,Data data,int scale,EsquemaCores cores){
		this.cores = cores;
		this.data = data;
		this.location= new Point(x,y);
		this.children= new ArrayList<>();
		for(int posicao=0;posicao!=(data.getTuplos().size());posicao++){
			Tuplo t = data.getTuplos().get(posicao);
			addPosition(t,scale,posicao);
		}
		
	} 
	
	public Data getData() {
		return data;
	}
	
	public List<Figure> getChildren() {
		return children;
	}

	public void setChildren(List<Figure> children) {
		this.children = children;
	}

	public EsquemaCores getCores() {
		return cores;
	}
	
	public abstract void addPosition(Tuplo t, int scale, int posicao);

	public void setCores(EsquemaCores cores) {
		this.cores = cores;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public Location getLocation() {
		return this.location;
	}
	
	public List<? extends Figure> getChildFigures() {
		return Collections.unmodifiableList(children);
	}
	
	public void move(int x, int y) {
		this.location = this.location.sum(x, y);
	}
	
	

}
