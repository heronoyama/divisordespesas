package br.com.heron.divisordespesas.relatorio.driver;

import java.io.IOException;

public interface DriverEscrita {
	
	public void escreve(String linha) throws IOException;
	
	public void close() throws IOException;

}
