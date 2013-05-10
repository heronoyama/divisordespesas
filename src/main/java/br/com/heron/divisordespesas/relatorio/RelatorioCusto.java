package br.com.heron.divisordespesas.relatorio;

import static java.lang.String.format;
import static java.util.Locale.ENGLISH;
import br.com.heron.divisordespesas.grupo.Grupo;


public abstract class RelatorioCusto {

	public static RelatorioCusto getRelatorio(TipoRelatorio tipo, Grupo grupo){
		if(tipo == TipoRelatorio.CONTRIBUICAO)
			return new RelatorioContribuicao(grupo);
		
		if(tipo == TipoRelatorio.DIVISAO_CONSUMO_CATEGORIA)
			return new RelatorioDivisaoConsumoCategoria(grupo);
		
		if(tipo == TipoRelatorio.DIVIDA)
			return new RelatorioDivida(grupo);
		
		if(tipo == TipoRelatorio.ARECEBER)
			return new RelatorioAReceber(grupo);
		
		if(tipo == TipoRelatorio.GASTO_CATEGORIA)
			return new RelatorioGastoPorCategoria(grupo);
		
		if(tipo == TipoRelatorio.CONSUMO_PARTICIPANTE)
			return new RelatorioConsumoParticipante(grupo);
		
		if(tipo == TipoRelatorio.VALOR_CATEGORIA)
			return new RelatorioValorCategoria(grupo);
		
		return new RelatorioFinal(grupo);
	}
	
	protected int index = 0;
	private final String custeioSimples = "%s,R$%.2f";

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