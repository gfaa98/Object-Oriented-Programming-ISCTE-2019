package Projeto;

public class UpC implements FilterData {
	private static final String C = "14";
	public boolean show(Tuplo t) {
		boolean b = false;
		if(t.xInt()==true)
			b = Integer.parseInt(t.getX())>= Integer.parseInt(C);
	    return b;
	}
}
