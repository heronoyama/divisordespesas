package br.com.heron.divisordespesas.relatorio;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.grupo.Participante;

public class RelatorioGastoPorCategoriaTest extends RelatorioCustoTest {

	private Participante kazuhiro = new Participante("Kazuhiro");
	
	@Before
	public void setup(){
		heron.contribuiu(categoriaCarne, 15.0);
		heron.consumiu(categoriaCarne);
	}
	
	@Test
	public void cabecalho(){
		RelatorioCusto relatorio = criaGrupoERelatorio(TipoRelatorio.GASTO_CATEGORIA);
		assertEquals("Categoria;Valor Consumido"+quebraLinha, relatorio.cabecalho());
	}
	
	@Test
	public void umContribuinteEConsumidor(){
		RelatorioCusto relatorio = criaGrupoERelatorio(TipoRelatorio.GASTO_CATEGORIA);
		assertEquals("Carne;R$15.00"+quebraLinha,relatorio.proximaLinha());
	}
	
	@Test
	public void duasContribuicoes(){
		kazuhiro.contribuiu(categoriaCarne, 25.0);

		RelatorioCusto relatorio = criaGrupoERelatorio(TipoRelatorio.GASTO_CATEGORIA,heron,kazuhiro);
		assertEquals("Carne;R$40.00"+quebraLinha,relatorio.proximaLinha());
	}
	
	@Test
	public void duasContribuicoesDistintas(){
		Categoria categoriaBebida = new Categoria("Bebida");
		kazuhiro.contribuiu(categoriaBebida, 20.00);
		kazuhiro.contribuiu(categoriaCarne, 5.00);
		heron.consumiu(categoriaBebida);
		kazuhiro.consumiu(categoriaCarne,categoriaBebida);
		
		RelatorioCusto relatorio = criaGrupoERelatorio(TipoRelatorio.GASTO_CATEGORIA,heron,kazuhiro);
		assertEquals("Bebida;R$10.00"+quebraLinha,relatorio.proximaLinha());
		assertEquals("Carne;R$10.00"+quebraLinha,relatorio.proximaLinha());
		assertEquals("",relatorio.proximaLinha());
	}
}
