package br.com.heron.divisordespesas.model.contribuicoes;

import static junit.framework.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.contribuicoes.Contribuicao;
import br.com.heron.divisordespesas.model.evento.Participante;

public class ContribuicaoTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private Participante participante = new Participante("Heron");
	private Categoria categoria = new Categoria("Carne");
	
	@Test
	public void novaCategoriaPaga(){
		Contribuicao categoriaPaga = criaContribuicao();
		assertEquals("Carne : 0.0",categoriaPaga.toString());
	}
	
	@Test
	public void adicionaValorGasto(){
		Contribuicao categoriaPaga = criaContribuicao();
		categoriaPaga.adicionaGasto(10.0);
		assertEquals("Carne : 10.0",categoriaPaga.toString());
	}

	private Contribuicao criaContribuicao() {
		return new Contribuicao(categoria);
	}

	@Test
	public void adicionaNovaCategoriaPaga(){
		participante.contribuiu(categoria,10.0);
		assertEquals(10.0,participante.valorContribuido(categoria));
	}
	
	@Test
	public void naoCriaContribuicaoSemCategoria(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Contribuição deve ser sobre uma categoria.");
		new Contribuicao(null);
	}
	
	@Test
	public void naoAdicionaGastoNegativo(){
		Contribuicao contribuicao = criaContribuicao();
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Contribuição deve ter tido gasto positivo.");
		contribuicao.adicionaGasto(-10);
		
	}
}
