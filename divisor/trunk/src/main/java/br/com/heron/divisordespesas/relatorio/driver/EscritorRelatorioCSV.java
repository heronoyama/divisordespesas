package br.com.heron.divisordespesas.relatorio.driver;

import java.io.IOException;

import br.com.heron.divisordespesas.relatorio.RelatorioCusto;

public class EscritorRelatorioCSV {

	private RelatorioCusto relatorio;
	private DriverEscrita driver;

	public EscritorRelatorioCSV(RelatorioCusto relatorio,DriverEscrita driver) throws IOException {
		this.relatorio = relatorio;
		this.driver = driver;
	}

	public void escreveCabecalho() throws IOException {
		driver.escreve(relatorio.cabecalho());		
	}

	public void escreveLinha() throws IOException {
		driver.escreve(relatorio.proximaLinha());
	}

	public void escreveCorpo() throws IOException {
		while(!relatorio.terminou())
			escreveLinha();
		
	}

	public void imprimeRelatorio() throws IOException {
		escreveCabecalho();
		escreveCorpo();
		driver.close();
	}

}
