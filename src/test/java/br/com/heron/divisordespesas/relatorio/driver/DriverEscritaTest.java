package br.com.heron.divisordespesas.relatorio.driver;

import java.io.IOException;

public class DriverEscritaTest implements DriverEscrita{

	public void escreve(String linha) throws IOException {
		System.out.println("Imprimindo: " + linha);
	}

	public void close() throws IOException {
		System.out.println("Fechando arquivo.");
	}


}
