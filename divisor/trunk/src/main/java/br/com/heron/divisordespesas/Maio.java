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

public class Maio {

	private static Participante heron;
	private static Participante urataki;
	private static Participante danilo;
	private static Participante pesk;
	private static Participante samambaia;
	private static Participante paola;
	private static Participante ana;
	private static Participante joao;
	private static Participante kami;
	private static Participante bruna;
	private static Participante cage;
	private static Participante batman;
	private static Participante erison;
	private static Participante mancha;
	private static Categoria carne;
	private static Categoria aluguel;
	private static Categoria terceiraGrade;
	private static Categoria primeiraGrade;
	private static Categoria segundaGrade;
	private static Categoria compras;
	private static Evento evento;
	private static Categoria quartaGrade;
	
	public static void main(String[] args) throws IOException {

		Repositorios.registre(Participante.class, new RepositorioParticipanteMemoria());
		participantes();

		categorias();
		contribuintes();
		consumidores();

		evento = new Evento(Arrays.asList(heron, urataki,danilo,pesk,samambaia,paola,ana,joao,kami,bruna,cage,batman,erison,mancha));

		geraRelatorio("consumoParticipante.csv",TipoRelatorio.CONSUMO_PARTICIPANTE);
		geraRelatorio("divisaoConsumoCategoria.csv",TipoRelatorio.DIVISAO_CONSUMO_CATEGORIA);
		geraRelatorio("gastoCategoria.csv",TipoRelatorio.GASTO_CATEGORIA);
		geraRelatorio("valorCategoria.csv",TipoRelatorio.VALOR_CATEGORIA);
		geraRelatorio("aReceber.csv",TipoRelatorio.ARECEBER);
		geraRelatorio("final.csv",TipoRelatorio.FINAL);
		

	}
	
	private static void geraRelatorio(String titulo, TipoRelatorio tipo) throws IOException{
		RelatorioCusto relatorio = FabricaRelatorio.getRelatorio(tipo, evento);
		DriverEscrita driver = new FileWraper("C:\\test\\"+titulo);
		EscritorRelatorioCSV escritor = new EscritorRelatorioCSV(relatorio, driver);
		escritor.imprimeRelatorio();
	}

	private static void consumidores() {
		consumuiuTudo(heron,mancha,danilo);
		
		joao.consumiu(carne,compras,primeiraGrade,aluguel);
		bruna.consumiu(carne,compras,aluguel);
		paola.consumiu(carne,compras,aluguel);
		erison.consumiu(carne,compras,primeiraGrade,segundaGrade,aluguel);
		kami.consumiu(carne,compras,primeiraGrade,aluguel);
		urataki.consumiu(carne,compras,segundaGrade,terceiraGrade,quartaGrade,aluguel);
		samambaia.consumiu(carne,compras,segundaGrade,terceiraGrade,quartaGrade,aluguel);
		cage.consumiu(carne,compras,segundaGrade,terceiraGrade,aluguel);
		ana.consumiu(carne,compras,aluguel);
		batman.consumiu(terceiraGrade,quartaGrade,aluguel);
		pesk.consumiu(carne,compras,primeiraGrade,segundaGrade,aluguel);
	}

	private static void contribuintes() {
		heron.contribuiu(carne, 66.5);
		joao.contribuiu(compras, 5.23);
		joao.contribuiu(compras,2.45);
		danilo.contribuiu(primeiraGrade, 44.4);
		danilo.contribuiu(compras, 5);
		cage.contribuiu(segundaGrade, 10);
		erison.contribuiu(segundaGrade, 30);
		heron.contribuiu(segundaGrade, 4.4);
		heron.contribuiu(terceiraGrade, 26);
		danilo.contribuiu(quartaGrade, 10);
		heron.contribuiu(quartaGrade, 16);
		heron.contribuiu(compras, 17.88);
		heron.contribuiu(compras, 6.5);
		pesk.contribuiu(aluguel, 40.5);
	}

	private static void categorias() {
		carne = new Categoria("Carne");
		aluguel = new Categoria("Aluguel");
		terceiraGrade = new Categoria("Terceira Grade");
		primeiraGrade = new Categoria("Primeira Grade");
		segundaGrade = new Categoria("Segunda Grade");
		quartaGrade = new Categoria("Quarta Grade");
		compras = new Categoria("Compras");
	}

	private static void participantes() {
		heron = new Participante("Heron");
		joao = new Participante("Joao");
		bruna = new Participante("Bruna");
		danilo = new Participante("Danilo");
		paola = new Participante("Paola");
		mancha = new Participante("Daniel Mancha");
		erison = new Participante("Erison");
		urataki = new Participante("Urataki");
		pesk = new Participante("Pesk");
		samambaia = new Participante("Samambaia");
		ana = new Participante("Ana");
		kami = new Participante("Kami");
		cage = new Participante("Cage");
		batman = new Participante("Batman");
	}

	private static void consumuiuTudo(Participante... participantes) {
		for (Participante participante : participantes) {
			participante.consumiu(carne, aluguel, terceiraGrade, primeiraGrade, segundaGrade, quartaGrade,compras);
		}
	}

}
