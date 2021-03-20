package Projeto;

import pt.iscte.guitoo.StandardColor;

public class GreenUp50 implements EsquemaCores {
	private static final int C = 50;
	@Override
	public void paint(Tuplo t,Figuras f) {
		if(t.getY()>=C) {
			f.setColor(StandardColor.GREEN);
		}else {
			f.setColor(StandardColor.RED);
			
		}
	}
}
