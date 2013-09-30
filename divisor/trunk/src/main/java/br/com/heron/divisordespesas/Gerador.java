package br.com.heron.divisordespesas;

import java.io.IOException;
import java.util.Arrays;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.model.evento.Participante;
import br.com.heron.divisordespesas.relatorio.FabricaRelatorio;
import br.com.heron.divisordespesas.relatorio.RelatorioCusto;
import br.com.heron.divisordespesas.relatorio.TipoRelatorio;
import br.com.heron.divisordespesas.relatorio.driver.DriverEscrita;
import br.com.heron.divisordespesas.relatorio.driver.EscritorRelatorioCSV;
import br.com.heron.divisordespesas.relatorio.driver.FileWraper;
import br.com.heron.divisordespesas.repositorio.Repositorios;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioParticipanteMemoria;

public class Gerador {

	private static Participante heron;
	private static Participante urataki;
	private static Participante danilo;
	private static Participante pesk;
	private static Participante samambaia;
	private static Participante paola;
	private static Participante ana;
	private static Participante joao;
	private static Participante kami;
	private static Participante louw;
	private static Participante cage;
	private static Participante patricia;
	private static Participante gisele;
	private static Participante namoradoDaGisele;
	private static Participante slims;
	private static Participante menina;
	private static Categoria carne;
	private static Categoria aluguel;
	private static Categoria multa;
	private static Categoria primeiraGrade;
	private static Categoria segundaGrade;
	private static Categoria compras;
	private static Evento evento;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Repositorios.registre(Participante.class, new RepositorioParticipanteMemoria());
		participantes();
		
		categorias();
		contribuintes();
		consumidores();
		
		evento = new Evento(Arrays.asList(heron,urataki,danilo,pesk,samambaia,paola,ana,joao,kami,louw,cage,patricia,gisele,namoradoDaGisele,slims,menina));
		
		RelatorioCusto relatorio = FabricaRelatorio.getRelatorio(TipoRelatorio.ARECEBER, evento);
		DriverEscrita driver = new FileWraper("C:\\test\\relatorioFinal.csv");
		
		EscritorRelatorioCSV escritor = new EscritorRelatorioCSV(relatorio, driver);
		escritor.imprimeRelatorio();
		
	}

	private static void consumidores() {
		consumuiuTudo(heron,urataki,danilo,pesk,samambaia,kami,cage);
		paola.consumiu(carne,aluguel,multa,compras);
		ana.consumiu(carne,aluguel,multa,compras);
		
		joao.consumiu(carne,aluguel,multa,compras,primeiraGrade);
		louw.consumiu(carne,aluguel,multa,segundaGrade,compras);
		
		consumuiuAluguelEMulta(patricia,gisele,namoradoDaGisele,slims,menina);
		patricia.consumiu(carne);
		slims.consumiu(carne);
	}

	private static void contribuintes() {
		heron.contribuiu(carne, 10.0);
		danilo.contribuiu(primeiraGrade, 45.0);
		pesk.contribuiu(aluguel, 40.0);
		pesk.contribuiu(multa, 21.7);
		samambaia.contribuiu(carne,104.27);
		ana.contribuiu(compras, 15.0);
		cage.contribuiu(segundaGrade, 45.0);
	}

	private static void categorias() {
		carne = new Categoria("Carne");
		aluguel = new Categoria("Aluguel");
		multa = new Categoria("Multa");
		primeiraGrade = new Categoria("Primeira Grade");
		segundaGrade = new Categoria("Segunda Grade");
		compras = new Categoria("Compras");
	}

	private static void participantes() {
		heron = new Participante("Heron");
		urataki = new Participante("Urataki");
		danilo = new Participante("Danilo");
		pesk = new Participante("Pesk");
		samambaia = new Participante("Samambaia");
		paola = new Participante("Paola");
		ana = new Participante("Ana");
		joao = new Participante("Joao");
		kami = new Participante("Kami");
		louw = new Participante("Louw");
		cage = new Participante("Cage");
		patricia = new Participante("Patricia");
		gisele = new Participante("Gisele");
		namoradoDaGisele = new Participante("Namorado da Gisele");
		slims = new Participante("Slims");
		menina = new Participante("Outra menina");
	}
	
	private static void consumuiuAluguelEMulta(Participante... participantes) {
		for (Participante participante : participantes) {
			participante.consumiu(aluguel,multa);
		}
	}

	private static void consumuiuTudo(Participante...participantes){
		for (Participante participante : participantes) {
			participante.consumiu(carne,aluguel,multa,primeiraGrade,segundaGrade,compras);
		}
	}

}
