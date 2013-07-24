package br.com.heron.divisordespesas.relatorio;

import static java.lang.String.format;
import static java.util.Locale.ENGLISH;


public abstract class RelatorioCusto {

	protected int index = 0;
	private final String custeioSimples = "%s;R$%.2f";

	public String proximaLinha() {
		if(terminou())
			return "";
		return formata();
	}

	public boolean terminou() { return index >= getSize(); }

	public String cabecalho(){
		return adicionaQuebraLinha(getCabecalho());
	}
	
	protected abstract String getCabecalho();
	protected abstract int getSize();
	protected abstract String formata();
	
	protected String formata(Object alvo, double valor){
		return adicionaQuebraLinha(format(ENGLISH,custeioSimples, alvo,valor));
	}
	
	protected String adicionaQuebraLinha(String linha){
		return linha + System.getProperty("line.separator");
	}

}