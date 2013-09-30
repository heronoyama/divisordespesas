package br.com.heron.divisordespesas.relatorio;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.evento.Participante;

public class RelatorioValorCategoriaTest extends RelatorioCustoTest {

	private Participante kazuhiro = new Participante("Kazuhiro");
	
	@Test
	public void cabecalho(){
		RelatorioCusto relatorio = criaEventoERelatorio();
		assertEquals("Categoria; Valor Por Participante"+quebraLinha, relatorio.cabecalho());
	}
	

	@Test
	public void unicoConsumo(){
		heron.contribuiu(categoriaCarne, 30.0);
		heron.consumiu(categoriaCarne);
		kazuhiro.consumiu(categoriaCarne);
		
		RelatorioCusto relatorio = criaEventoERelatorio();
		assertEquals("Carne;R$15.00"+quebraLinha,relatorio.proximaLinha());
		assertEquals("",relatorio.proximaLinha());
	}
	
	@Test
	public void doisConsumos(){
		Categoria categoriaBebida = new Categoria("Bebida");
		heron.contribuiu(categoriaCarne, 30.0);
		kazuhiro.contribuiu(categoriaBebida, 40.0);
		heron.consumiu(categoriaCarne,categoriaBebida);
		kazuhiro.consumiu(categoriaCarne,categoriaBebida);
		
		RelatorioCusto relatorio = criaEventoERelatorio();
		assertEquals("Bebida;R$20.00"+quebraLinha,relatorio.proximaLinha());
		assertEquals("Carne;R$15.00"+quebraLinha,relatorio.proximaLinha());
		assertEquals("",relatorio.proximaLinha());
	}

	private RelatorioCusto criaEventoERelatorio() {
		return criaEventoERelatorio(TipoRelatorio.VALOR_CATEGORIA,heron,kazuhiro);
	}
}
