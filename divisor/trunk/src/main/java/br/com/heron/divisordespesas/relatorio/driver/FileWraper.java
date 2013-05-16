package br.com.heron.divisordespesas.relatorio.driver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWraper implements DriverEscrita {

	private FileWriter writer;
	
	public FileWraper(String caminho) throws IOException {
		writer = new FileWriter(new File(caminho));
	}
	
	public void escreve(String linha) throws IOException {
		writer.write(linha);
	}
	
	public void close() throws IOException{
		writer.close();
	}
	
	

}
