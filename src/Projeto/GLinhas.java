package Projeto;

import pt.iscte.guitoo.*;

public class GLinhas extends Grafico {
	
	private static final int WIDTH=50;
	private static final int STANDARD = 3;
	private static final int SEPARACAOSTANDARD = 100;
	
	
	public GLinhas(int x,int y,Data data,int scale,EsquemaCores cores) {
		super(x,y,data,scale,cores);
	}

	@Override
	public void addPosition(Tuplo t, int scale, int posicao) {
		int sep=SEPARACAOSTANDARD*posicao; 
		Circle circle = new Circle(STANDARD*scale);
        circle.move(sep, -getData().getTuplos().get(posicao).getY()*scale/2);
        getChildren().add(circle);
        getCores().paint(t,circle);
        
        for(int i = 0; i!=getData().getTuplos().size()-1;i++) {
        	if(posicao!=getData().getTuplos().size()-1) {
        		Point p1 = new Point(sep, -getData().getTuplos().get(posicao).getY()*scale/2);
        		Point p2 = new Point(SEPARACAOSTANDARD*(posicao+1),-getData().getTuplos().get(posicao+1).getY()*scale/2);
        		Linha linha = new Linha(p1,p2);
        		getChildren().add(linha);
        	}
        }
		
		int barraY = 0;
		
		for(int n=0;n<=getData().maxY()+20;n+=20) {
			StaticText text = new StaticText(n,-2*WIDTH/2,-n*scale/2);
			text.setFontSize(15);
			getChildren().add(text);
			barraY = n;
		}
		
		Rectangle lineY= new Rectangle(1,-barraY*scale/2);
		lineY.move(-WIDTH/2, 0);
		getChildren().add(lineY);
		
		   String s= getData().getTuplos().get(posicao).getX();
			StaticText etiquetas = new StaticText(s,sep,+10);
			etiquetas.setFontSize(15);
			getChildren().add(etiquetas);
			
	}


}
