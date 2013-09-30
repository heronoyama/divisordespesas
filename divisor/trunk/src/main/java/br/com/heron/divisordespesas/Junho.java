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

public class Junho {

	private static Participante heron;
	private static Participante danilo;
	private static Participante pesk;
	private static Participante samambaia;
	private static Participante paola;
	private static Participante kami;
	
	private static Categoria carne;
	private static Categoria aluguel;
	private static Categoria primeiraGrade;
	private static Categoria segundaGrade;
	private static Categoria compras;
	private static Evento evento;
	
	public static void main(String[] args) throws IOException {

		Repositorios.registre(Participante.class, new RepositorioParticipanteMemoria());
		participantes();

		categorias();
		contribuintes();
		consumidores();

		evento = new Evento(Arrays.asList(heron, danilo,pesk,samambaia,paola,kami));

		geraRelatorio("consumoParticipante.csv",TipoRelatorio.CONSUMO_PARTICIPANTE);
		geraRelatorio("divisaoConsumoCategoria.csv",TipoRelatorio.DIVISAO_CONSUMO_CATEGORIA);
		geraRelatorio("gastoCategoria.csv",TipoRelatorio.GASTO_CATEGORIA);
		geraRelatorio("valorCategoria.csv",TipoRelatorio.VALOR_CATEGORIA);
		geraRelatorio("aReceber.csv",TipoRelatorio.ARECEBER);
		geraRelatorio("final.csv",TipoRelatorio.FINAL);
		

	}
	
	private static void geraRelatorio(String titulo, TipoRelatorio tipo) throws IOException{
		RelatorioCusto relatorio = FabricaRelatorio.getRelatorio(tipo, evento);
		DriverEscrita driver = new FileWraper("C:\\test\\Junho\\"+titulo);
		EscritorRelatorioCSV escritor = new EscritorRelatorioCSV(relatorio, driver);
		escritor.imprimeRelatorio();
	}

	private static void consumidores() {
		consumuiuTudo(heron,kami,pesk,samambaia,danilo);
		
		paola.consumiu(carne,compras,aluguel);
		
	}

	private static void contribuintes() {
		heron.contribuiu(carne, 82.95);
		heron.contribuiu(primeiraGrade, 50);
//		danilo.contribuiu(compras, 5);
		samambaia.contribuiu(segundaGrade, 26);

		pesk.contribuiu(aluguel, 40.5);
	}

	private static void categorias() {
		carne = new Categoria("Carne");
		aluguel = new Categoria("Aluguel");
		primeiraGrade = new Categoria("Primeira Grade");
		segundaGrade = new Categoria("Segunda Grade");
		compras = new Categoria("Compras");
	}

	private static void participantes() {
		heron = new Participante("Heron");
		danilo = new Participante("Danilo");
		paola = new Participante("Paola");
		pesk = new Participante("Pesk");
		samambaia = new Participante("Samambaia");
		kami = new Participante("Kami");
	}

	private static void consumuiuTudo(Participante... participantes) {
		for (Participante participante : participantes) {
			participante.consumiu(carne, aluguel, primeiraGrade, segundaGrade, compras);
		}
	}


}
