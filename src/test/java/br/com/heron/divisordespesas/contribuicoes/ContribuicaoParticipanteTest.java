package br.com.heron.divisordespesas.contribuicoes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.heron.divisordespesas.configuracao.Categoria;
import br.com.heron.divisordespesas.grupo.Participante;

public class ContribuicaoParticipanteTest {
	
	private Categoria categoria = new Categoria("Carne");
	private Participante participante = new Participante("Heron");
	
	@Test
	public void listaContribuicaoVazia(){
		assertEquals("Heron : []", participante.contribuicao().toString());
	}
	
	@Test
	public void adicionaContribuicao(){
		ContribuicaoParticipante contribuicao = new ContribuicaoParticipante(participante);
		contribuicao.adicionaValor(categoria,10.0);
		assertEquals("Heron : [Carne : 10.0]",contribuicao.toString());
	}
	
	@Test
	public void diversasContribuicoes(){
		ContribuicaoParticipante contribuicao = new ContribuicaoParticipante(participante);
		contribuicao.adicionaValor(categoria, 10.0);
		contribuicao.adicionaValor(categoria, 15.0);
		assertEquals("Heron : [Carne : 25.0]",contribuicao.toString());
	}
	
	@Test
	public void contribuicoesEmOutrasCategorias(){
		ContribuicaoParticipante contribuicao = new ContribuicaoParticipante(participante);
		contribuicao.adicionaValor(categoria, 10.0);
		contribuicao.adicionaValor(new Categoria("Bebida"), 15.0);
		assertEquals("Heron : [Bebida : 15.0, Carne : 10.0]",contribuicao.toString());
	}
	
	@Test
	public void adicionaContribuicaoParaParticipante(){
		participante.contribuiu(categoria, 10.0);
		assertEquals("Heron : [Carne : 10.0]",participante.contribuicao().toString());
	}
	

}
