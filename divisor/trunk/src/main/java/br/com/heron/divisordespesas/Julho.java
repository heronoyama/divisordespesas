package br.com.heron.divisordespesas;

import java.io.IOException;
import java.util.Arrays;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.grupo.Grupo;
import br.com.heron.divisordespesas.model.grupo.Participante;
import br.com.heron.divisordespesas.relatorio.FabricaRelatorio;
import br.com.heron.divisordespesas.relatorio.RelatorioCusto;
import br.com.heron.divisordespesas.relatorio.TipoRelatorio;
import br.com.heron.divisordespesas.relatorio.driver.DriverEscrita;
import br.com.heron.divisordespesas.relatorio.driver.EscritorRelatorioCSV;
import br.com.heron.divisordespesas.relatorio.driver.FileWraper;
import br.com.heron.divisordespesas.repositorio.Repositorios;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioParticipanteMemoria;

public class Julho {
	private static Participante heron;
	private static Participante cage;
	private static Participante lowu;
	private static Participante garga;
	private static Participante danilo;
	private static Participante urataki;
	private static Participante samambaia;
	private static Participante batman;
	private static Participante kami;
	private static Participante mancha;
	
	
	private static Categoria carne;
	private static Categoria aluguel;
	private static Categoria primeiraGrade;
	private static Categoria segundaGrade;
	private static Categoria compras;
	private static Grupo grupo;
	
	public static void main(String[] args) throws IOException {

		Repositorios.registre(Participante.class, new RepositorioParticipanteMemoria());
		participantes();

		categorias();
		contribuintes();
		consumidores();

		grupo = new Grupo(Arrays.asList(heron,cage,lowu,garga,danilo,urataki,samambaia,batman,kami,mancha));

		geraRelatorio("consumoParticipante.csv",TipoRelatorio.CONSUMO_PARTICIPANTE);
		geraRelatorio("divisaoConsumoCategoria.csv",TipoRelatorio.DIVISAO_CONSUMO_CATEGORIA);
		geraRelatorio("gastoCategoria.csv",TipoRelatorio.GASTO_CATEGORIA);
		geraRelatorio("valorCategoria.csv",TipoRelatorio.VALOR_CATEGORIA);
		geraRelatorio("aReceber.csv",TipoRelatorio.ARECEBER);
		geraRelatorio("final.csv",TipoRelatorio.FINAL);
		

	}
	
	private static void geraRelatorio(String titulo, TipoRelatorio tipo) throws IOException{
		RelatorioCusto relatorio = FabricaRelatorio.getRelatorio(tipo, grupo);
		DriverEscrita driver = new FileWraper("C:\\test\\Julho\\"+titulo);
		EscritorRelatorioCSV escritor = new EscritorRelatorioCSV(relatorio, driver);
		escritor.imprimeRelatorio();
	}

	private static void consumidores() {
		consumuiuTudo(heron,cage,lowu,garga,danilo,urataki,samambaia,batman,kami,mancha);
	}

	private static void contribuintes() {
		heron.contribuiu(primeiraGrade, 58.2);
		heron.contribuiu(compras, 10.30);
		heron.contribuiu(aluguel, 20);
		danilo.contribuiu(segundaGrade, 46.2);
		cage.contribuiu(carne, 89);
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
		cage = new Participante("Cage");
		lowu = new Participante("Lowu");
		garga = new Participante("Garga");
		danilo = new Participante("Danilo");
		urataki = new Participante("Urataki");
		samambaia = new Participante("Samambaia");
		batman = new Participante("Batman");
		kami = new Participante("Kami");
		mancha = new Participante("Mancha");

	}

	private static void consumuiuTudo(Participante... participantes) {
		for (Participante participante : participantes) {
			participante.consumiu(carne, aluguel, primeiraGrade, segundaGrade, compras);
		}
	}
}
