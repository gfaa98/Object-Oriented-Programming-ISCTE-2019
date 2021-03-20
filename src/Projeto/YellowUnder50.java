package Projeto;

import pt.iscte.guitoo.StandardColor;

public class YellowUnder50 implements EsquemaCores{
	private static final int C = 50;
	
    @Override
	public void paint(Tuplo t,Figuras f) {
		if(t.getY()<=C) {
			f.setColor(StandardColor.YELLOW);
		}else {
			f.setColor(StandardColor.WHITE);
		}
	}

}
