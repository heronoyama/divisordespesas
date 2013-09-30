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

public class Agosto {
	private static Participante heron;
	private static Participante cage;
	private static Participante ana;
	private static Participante joao;
	private static Participante danilo;
	private static Participante urataki;
	private static Participante samambaia;
	private static Participante batman;
	private static Participante kami;
	private static Participante bruna;
	
	
	private static Categoria carne;
	private static Categoria aluguel;
	private static Categoria cerveja;
//	private static Categoria segundaGrade;
	private static Categoria compras;
	private static Evento evento;
	private static Participante paola;
	private static Participante pilo;
	private static Participante polly;
	
	public static void main(String[] args) throws IOException {

		Repositorios.registre(Participante.class, new RepositorioParticipanteMemoria());
		participantes();
		evento = new Evento(Arrays.asList(heron,samambaia,urataki,danilo,kami,cage,ana,joao,pilo,batman,paola,bruna,polly));

		categorias();
		contribuintes();
		consumidores();


		geraRelatorio("consumoParticipante.csv",TipoRelatorio.CONSUMO_PARTICIPANTE);
		geraRelatorio("divisaoConsumoCategoria.csv",TipoRelatorio.DIVISAO_CONSUMO_CATEGORIA);
		geraRelatorio("gastoCategoria.csv",TipoRelatorio.GASTO_CATEGORIA);
		geraRelatorio("valorCategoria.csv",TipoRelatorio.VALOR_CATEGORIA);
		geraRelatorio("aReceber.csv",TipoRelatorio.ARECEBER);
		geraRelatorio("final.csv",TipoRelatorio.FINAL);
		

	}
	
	private static void geraRelatorio(String titulo, TipoRelatorio tipo) throws IOException{
		RelatorioCusto relatorio = FabricaRelatorio.getRelatorio(tipo, evento);
		DriverEscrita driver = new FileWraper("C:\\test\\Agosto\\"+titulo);
		EscritorRelatorioCSV escritor = new EscritorRelatorioCSV(relatorio, driver);
		escritor.imprimeRelatorio();
	}

	private static void consumidores() {
		consumuiuTudo(heron,samambaia,urataki,danilo,kami,cage,joao,pilo,batman);
		naoConsumiuCerveja(paola,bruna,polly,ana);
	}

	private static void naoConsumiuCerveja(Participante... participantes) {
		for (Participante participante : participantes) {
			participante.consumiu(carne,aluguel,compras);
		}
		
	}

	private static void contribuintes() {
		heron.contribuiu(cerveja, 50.0);
		heron.contribuiu(aluguel, 30.0);
		heron.contribuiu(carne, 91.80);
		danilo.contribuiu(cerveja, 50.0);
		samambaia.contribuiu(compras, 25.63);
	}

	private static void categorias() {
		carne = new Categoria("Carne");
		aluguel = new Categoria("Aluguel");
		cerveja = new Categoria("Cerveja");
//		segundaGrade = new Categoria("Segunda Grade");
		compras = new Categoria("Compras");
	}

	private static void participantes() {
		heron = new Participante("Heron");
		samambaia = new Participante("Samambaia");
		urataki = new Participante("Urataki");
		danilo = new Participante("Danilo");
		paola = new Participante("Paola");
		kami = new Participante("Kami");
		cage = new Participante("Cage");
		ana = new Participante("Ana");
		joao = new Participante("João");
		bruna = new Participante("Bruna");
		pilo = new Participante("Pilo");
		polly = new Participante("Polly");
		batman = new Participante("Batman");

	}

	private static void consumuiuTudo(Participante... participantes) {
		for (Participante participante : participantes) {
			participante.consumiu(carne, aluguel, cerveja,compras);
		}
	}
}
