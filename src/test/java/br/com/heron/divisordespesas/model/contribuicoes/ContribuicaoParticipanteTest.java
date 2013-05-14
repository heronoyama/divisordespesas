package br.com.heron.divisordespesas.model.contribuicoes;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.contribuicoes.ContribuicaoParticipante;
import br.com.heron.divisordespesas.model.grupo.Participante;

public class ContribuicaoParticipanteTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private Categoria categoria = new Categoria("Carne");
	private Participante participante = new Participante("Heron");
	
	@Test
	public void listaContribuicaoVazia(){
		assertEquals("Heron : []", participante.contribuicao().toString());
	}
	
	@Test
	public void adicionaContribuicao(){
		ContribuicaoParticipante contribuicao = criaContribuicao();
		contribuicao.adicionaValor(categoria,10.0);
		assertEquals("Heron : [Carne : 10.0]",contribuicao.toString());
	}
	
	@Test
	public void diversasContribuicoes(){
		ContribuicaoParticipante contribuicao = criaContribuicao();
		contribuicao.adicionaValor(categoria, 10.0);
		contribuicao.adicionaValor(categoria, 15.0);
		assertEquals("Heron : [Carne : 25.0]",contribuicao.toString());
	}
	
	@Test
	public void contribuicoesEmOutrasCategorias(){
		ContribuicaoParticipante contribuicao = criaContribuicao();
		contribuicao.adicionaValor(categoria, 10.0);
		contribuicao.adicionaValor(new Categoria("Bebida"), 15.0);
		assertEquals("Heron : [Bebida : 15.0, Carne : 10.0]",contribuicao.toString());
	}

	private ContribuicaoParticipante criaContribuicao() {
		return new ContribuicaoParticipante(participante);
	}
	
	@Test
	public void adicionaContribuicaoParaParticipante(){
		participante.contribuiu(categoria, 10.0);
		assertEquals("Heron : [Carne : 10.0]",participante.contribuicao().toString());
	}
	
	@Test
	public void naoCriaContribuicaoSemPartcipante(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Contribuição deve estar associado à um Participante.");
		new ContribuicaoParticipante(null);
	}
	
	@Test
	public void naoAdicionaContribuicaoNegativa(){
		ContribuicaoParticipante contribuicao = criaContribuicao();
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Contribuição deve ser um valor positivo.");
		contribuicao.adicionaValor(categoria, -1);
	}
	
	@Test
	public void naoAdicionaContribuicaoComCategoriaNula(){
		ContribuicaoParticipante contribuicao = criaContribuicao();
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Contribuição deve ser sobre uma categoria.");
		contribuicao.adicionaValor(null, 10.0);
	}

}
