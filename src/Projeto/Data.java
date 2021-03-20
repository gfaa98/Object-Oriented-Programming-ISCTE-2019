package Projeto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Data {
	
	private List<Tuplo> tuplos;
	private List<FilterData> filtros;
	
	public Data() {
		this.tuplos = new ArrayList<>(0);
		this.filtros = new ArrayList<>(0);
	}
	
	public void importarDados(File ficheiro) {
		try {
			Scanner s = new Scanner(ficheiro);
			while(s.hasNextLine()) {
				String line=s.nextLine();
				String[] res=line.split(",");
				if(res[1].contains(" ")) {
					res[1] = res[1].substring(1);
				}
				Tuplo t=new Tuplo(res[0],Integer.parseInt(res[1]));
				this.tuplos.add(t);
//				for(int i = 0; i!=this.filtros.size();i++) {
//					if(this.filtros.get(i).show(t)==false) {
//						this.tuplos.remove(t);
//					}
//				}
				filtragem(t);
			}
			s.close();
		}
		catch(FileNotFoundException e){
			System.err.println("Ficheiro nao encontrado");
			
		}
	}
	
	public void filtragem(Tuplo t) {
		for(int i = 0; i!=this.filtros.size();i++) {
			if(this.filtros.get(i).show(t)==false) {
				this.tuplos.remove(t);
			}
		}
	}
	
	
	public void adicionarFiltro(FilterData filtro) {
		this.filtros.add(filtro);
	}
	

	
	public int maxY() {
		int c=0;
		for(int x=0;x!=this.tuplos.size();x++) {
			c= Math.max(c, this.tuplos.get(x).getY());
		}
		return c;
		
	}
	
	public int maxX() {
		int c=0;
		for(int x=0;x!=this.tuplos.size();x++) {
			c= Math.max(c,Integer.parseInt(this.tuplos.get(x).getX()));
		}
		return c;
	}
	
	
	public List<Tuplo> getTuplos(){
		return this.tuplos;
	}
	
}
