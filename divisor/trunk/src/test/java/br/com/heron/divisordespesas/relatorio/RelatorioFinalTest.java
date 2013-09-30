package br.com.heron.divisordespesas.relatorio;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.evento.Participante;

public class RelatorioFinalTest extends RelatorioCustoTest{
	
	private Participante oyama = new Participante("Oyama");
	private Participante kazuhiro = new Participante("Kazuhiro");
	private Categoria categoriaBebida = new Categoria("Bebida");
	
	@Test
	public void imprimeCabecalho(){
		RelatorioCusto relatorio = criaEventoERelatorio(TipoRelatorio.FINAL);
		assertEquals("Paritipante;Contribuicao;Divida;Valor Final;Valor Para Receber"+quebraLinha, relatorio.cabecalho());
	}
	
	@Test
	public void imprimeRelatorioComUmContribuidor(){
		heron.consumiu(categoriaCarne,categoriaBebida);
		kazuhiro.consumiu(categoriaCarne,categoriaBebida);
		oyama.consumiu(categoriaCarne,categoriaBebida);
		
		heron.contribuiu(categoriaCarne, 150.00);
		heron.contribuiu(categoriaBebida, 150.00);
		
		RelatorioCusto relatorio = criaEventoERelatorio(TipoRelatorio.FINAL,heron,oyama,kazuhiro);
		assertEquals("Heron;R$300.00;R$0.00;R$100.00;R$200.00"+quebraLinha, relatorio.proximaLinha());
		assertEquals("Kazuhiro;R$0.00;R$100.00;R$100.00;R$0.00"+quebraLinha, relatorio.proximaLinha());
		assertEquals("Oyama;R$0.00;R$100.00;R$100.00;R$0.00"+quebraLinha, relatorio.proximaLinha());
		
	}


}
