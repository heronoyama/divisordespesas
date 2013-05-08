package br.com.heron.divisordespesas.contribuicoes;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import br.com.heron.divisordespesas.configuracao.Categoria;
import br.com.heron.divisordespesas.contribuicoes.Contribuicao;
import br.com.heron.divisordespesas.grupo.Participante;

public class ContribuicaoTest {
	
	private Participante participante = new Participante("Heron");
	private Categoria categoria = new Categoria("Carne");
	
	@Test
	public void novaCategoriaPaga(){
		Contribuicao categoriaPaga = new Contribuicao(categoria);
		assertEquals("Carne : 0.0",categoriaPaga.toString());
	}
	
	@Test
	public void adicionaValorGasto(){
		Contribuicao categoriaPaga = new Contribuicao(categoria);
		categoriaPaga.adicionaGasto(10.0);
		assertEquals("Carne : 10.0",categoriaPaga.toString());
	}

	@Test
	public void adicionaNovaCategoriaPaga(){
		participante.contribuiu(categoria,10.0);
		assertEquals(10.0,participante.valorContribuido(categoria));
	}
	
}
