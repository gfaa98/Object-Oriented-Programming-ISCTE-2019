package Projeto;

import pt.iscte.guitoo.*;
import java.io.File;

public class JGrafas {
	
	private Window app;
	private Flag negativasFlag;
	private Flag CFlag;
	private Option<String> OpcoesCores;
	
	public JGrafas() {
		app = new Window("JGrafas", 1500, 500, true);
		app.addLabel(() -> app.getCanvasWidth() + " x " + app.getCanvasHeight());
		app.addAction("HISTOGRAMA", new HistogramaExecute());
		app.addAction("DISPERSÃO", new DispersaoExecute());
		app.addAction("GRAFICO LINHAS", new GLinhasExecute());
		this.negativasFlag = app.addFlag("Positivas", false);
		this.CFlag = app.addFlag("C",false );
		this.OpcoesCores=app.addOption("cores","Sem cores","Verde >= 50","Amarelo < 50 e > 50");
		app.setBackground(StandardColor.SILVER);
	}
	
	public void run() {
		app.open();
	}
	
	private abstract class Argumentos extends Action {
		private String file;
		private String escala;
		public Argumentos() {
			//addParameter("Ficheiro"); //manter nome do ficheiro?
			addParameter("Ficheiro", () -> this.file, (a) -> !a.isEmpty());
			addParameter("Escala", () -> this.escala, (a) -> !a.isEmpty());
		}
		
		public void setFile(String s) {
			this.file = s;
		}
		
		public void setEscala(String s) {
			this.escala = s;
		}
		
		public String getEscala() {
			return this.escala;
		}
		
		public void putFilter(Data d) {
			if(negativasFlag.isSelected()) {
				d.adicionarFiltro(new Positive());
	        }
			if(CFlag.isSelected()) {
				d.adicionarFiltro(new UpC());
			}
		}
		
		public EsquemaCores putCores() {
			EsquemaCores cor = new WhiteDefault();
			if(OpcoesCores.getSelected().equals("Verde >= 50")) {
				cor = new GreenUp50();
			}else 
			if(OpcoesCores.getSelected().equals("Amarelo < 50 e > 50")) {
				cor = new YellowUnder50();
			}else {
				cor = new WhiteDefault();
			}
			return cor;
		}
		
		public void execute(String[] args) {
			setFile(args[0]);
			setEscala(args[1]);
			app.clear();
			Data raw_data =new Data();
			putFilter(raw_data);
			raw_data.importarDados(new File (args[0]));
			app.addFigure(grafico(args[1],raw_data));
			
		}
		
		public abstract Grafico grafico(String s, Data d);
	}
	protected class HistogramaExecute extends Argumentos{
		public HistogramaExecute() {
			super();
			setFile("POO-Notas.csv");
			setEscala("2");
		}
		
		
		public Grafico grafico(String escala,Data d) {
			return new Histograma(150,Integer.parseInt(escala)*d.maxY()+100,d,Integer.parseInt(escala), putCores());
		}

	}
	
	protected class DispersaoExecute extends Argumentos{
		public DispersaoExecute(){
			super();
			setFile("PCD-Assid.csv");
			setEscala("4");
		}
		
		public Grafico grafico(String escala,Data d) {
			return new Dispersao(150,Integer.parseInt(escala)*d.maxY()+100,d,Integer.parseInt(escala),putCores());
		}
	}
	
	protected class GLinhasExecute extends Argumentos{
		public GLinhasExecute(){
			super();
			setFile("POO-Aprov.csv");
			setEscala("4");
		}
		
		public Grafico grafico(String escala, Data d) {
			return new GLinhas(150,Integer.parseInt(escala)*d.maxY()+100,d,Integer.parseInt(escala),putCores());
		}
	}
	
	public static void main(String[] args) {
		JGrafas jgrafas = new JGrafas();
		jgrafas.run();
	}
}
