package br.com.heron.divisordespesas.controller;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.grupo.Participante;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioCategoriaMemoria;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioParticipanteMemoria;

public class ParticipanteControllerTest {
	
	private CategoriaController categoriaController;
	private ParticipanteController participanteController;

	@Before
	public void setUp(){
		categoriaController = new CategoriaController(new RepositorioCategoriaMemoria());
		participanteController = new ParticipanteController(new RepositorioParticipanteMemoria());		
	}
	
	@Test
	public void criaParticipante(){
		Participante participante = participanteController.cria("Heron");
		assertEquals("Heron", participante.toString());
	}
	
	@Test
	public void criaParticipantePersistido(){
		 participanteController.cria("Heron");
		Participante recuperado = participanteController.buscaTodos().get(0);
		assertEquals("Heron",recuperado.toString());
	}
	
	@Test
	public void buscaParticipantes(){
		participanteController.cria("Heron");
		participanteController.cria("Kazuhiro");
		participanteController.cria("Oyama");
		
		assertEquals("[Heron, Kazuhiro, Oyama]",participanteController.buscaTodos().toString());
	}
	
	@Test
	public void buscaParticipantePorNome(){
		Participante participante = participanteController.cria("Heron");
		participanteController.cria("Kazuhiro");
		participanteController.cria("Oyama");
		
		Participante pesquisado = participanteController.busca("Heron");
		assertEquals("Heron",pesquisado.toString());
		assertSame(participante, pesquisado);
		
	}
	
	@Test
	public void naoEncontraParticipante(){
		assertNull(participanteController.busca("Heron"));
	}
	
	@Test
	public void criaOuEncontraParticipante(){
		participanteController.cria("Heron");
		participanteController.buscaOuCria("Oyama");
		participanteController.busca("Kazuhiro");
		
		assertEquals("[Heron, Oyama]",participanteController.buscaTodos().toString());
	}
	
	@Test
	public void adicionaContribuicao(){
		Participante participante = participanteController.buscaOuCria("Heron");
		Categoria carne = categoriaController.criaCategoria("Carne");
		participanteController.adicionaContribuicao("Heron", carne, 10.0);
		
		assertEquals("Heron : [Carne : 10.0]",participante.contribuicao().toString());
	}
	
	@Test
	public void adicionaConsumo(){
		Participante participante = participanteController.buscaOuCria("Heron");
		Categoria carne = categoriaController.criaCategoria("Carne");
		Categoria bebida = categoriaController.criaCategoria("Bebida");
		participanteController.adicionaConsumos("Heron", carne, bebida);
		
		assertEquals("Heron : [Bebida, Carne]",participante.consumo().toString());
	}
}