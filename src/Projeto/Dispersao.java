package Projeto;

import pt.iscte.guitoo.StaticText;

public class Dispersao extends Grafico {
	
	private static final int WIDTH=50;
	private static final int STANDARD = 3;
	
	public Dispersao(int x,int y,Data data,int scale, EsquemaCores cores) {
		super(x,y,data,scale,cores);
	}

	@Override
	public void addPosition(Tuplo t, int scale, int posicao) {
		int barraY = 0;
		int barraX = 0;
		for(int n=0;n<=getData().maxY()+10;n+=10) {
			StaticText text = new StaticText(n,-2*WIDTH/2,-n*scale);
			text.setFontSize(15);
			getChildren().add(text);
			barraY = n;
		}
		Rectangle lineY= new Rectangle(1,-barraY*scale);
		lineY.move(-WIDTH/2, 0);
		getChildren().add(lineY);
		for(int i=0;i<=getData().maxX()+10;i+=10) {
			StaticText text = new StaticText(i,i*scale,15);
			text.setFontSize(15);
			getChildren().add(text);
			barraX = i;
		}
		Rectangle lineX = new Rectangle(barraX*scale,1);
		lineX.move(-WIDTH/2,0);
		getChildren().add(lineX);
		
        Circle circle = new Circle(STANDARD*scale);
        circle.move(-WIDTH/2+Integer.parseInt(t.getX())*scale, -t.getY()*scale);
        getChildren().add(circle);
        Integer yy = t.getY();
        t.setY(Integer.parseInt(t.getX()));
        t.setX(yy.toString());
        getCores().paint(t,circle);
	}

}
