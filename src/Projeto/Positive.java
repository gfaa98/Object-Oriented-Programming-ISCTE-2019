package Projeto;

public class Positive implements FilterData{
	private static final String C = "10";
	public boolean show(Tuplo t) {
		boolean b = false;
		if(t.xInt()==true)
			b = Integer.parseInt(t.getX())>= Integer.parseInt(C);
	    return b;
	}

}
