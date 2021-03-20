package Projeto;

public class Tuplo {
	
	private String eixoX;
	private int eixoY;
	
	public Tuplo(String X,int Y) {
		this.eixoX=X;
		this.eixoY=Y;
	}
	
	public String getX() {
		   return this.eixoX;
	   }
	
	public void setX(String s) {
		this.eixoX = s;
	}
	
	public int getY() {
		return this.eixoY;
	}
	
	public void setY(int i) {
		this.eixoY = i;
	}
	
	public boolean xInt() {
	    boolean d = true;
	    for ( int i = 0; i < this.eixoX.length(); i++ ) {
	        if ( !Character.isDigit( this.eixoX.charAt(i) )) {
	            d = false;
	            break;
	        }
	    }
	    return d;
	}
}
