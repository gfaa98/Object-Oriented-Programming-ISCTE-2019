package Projeto;

import pt.iscte.guitoo.*;

public class Histograma extends Grafico{
	
	private static final int WIDTH=50;
	
	public Histograma(int x,int y,Data data,int scale, EsquemaCores cores) {
		super(x,y,data,scale,cores);
	}
	
    @Override
	public void addPosition(Tuplo t,int scale,int posicao){
		int height=getData().getTuplos().get(posicao).getY();
		int barra = 0;
		for(int n=0;n<=getData().maxY()+20;n+=20) {
			StaticText text = new StaticText(n,-2*WIDTH/2,-n*scale);
			text.setFontSize(15);
			getChildren().add(text);
			barra = n;
		}
		Rectangle line= new Rectangle(1,-barra*scale);
		line.move(-WIDTH/2, 0);
		Rectangle rectangle= new Rectangle(WIDTH,scale*-height);
		int sep=posicao*scale;
		rectangle.move(posicao*WIDTH+sep,0);
		getChildren().add(line);
		getChildren().add(rectangle);
        getCores().paint(t,rectangle);
		String s= getData().getTuplos().get(posicao).getX();
		StaticText etiquetas = new StaticText(s,posicao*WIDTH+sep+WIDTH/2,+10);
		etiquetas.setFontSize(15);
		getChildren().add(etiquetas);
	}
}