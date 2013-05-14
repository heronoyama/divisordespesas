package br.com.heron.divisordespesas.controller;

import static junit.framework.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import br.com.heron.divisordespesas.model.grupo.Participante;
import br.com.heron.divisordespesas.repositorio.Repositorios;
import br.com.heron.divisordespesas.repositorio.Repository;

public class ParticipanteControllerTest {
	
	private Repository<Participante> repositorio = Repositorios.getRepository(Participante.class);

	@After
	public void cleanUp(){
		repositorio.clear();
	}
	
	@Test
	public void criaParticipante(){
		Participante participante = getController().criaParticipante("Heron");
		assertEquals("Heron", participante.toString());
	}
	
	@Test
	public void criaParticipantePersistido(){
		Participante participante = getController().criaParticipante("Heron");
		Participante recuperado = repositorio.find(participante.getId());
		assertEquals("Heron",recuperado.toString());
	}

	private ParticipanteController getController() {
		return new ParticipanteController();
	}
	
	@Test
	public void buscaParticipantes(){
		ParticipanteController controller = getController();
		controller.criaParticipante("Heron");
		controller.criaParticipante("Kazuhiro");
		controller.criaParticipante("Oyama");
		
		assertEquals("[Heron, Kazuhiro, Oyama]",controller.todosParticipantes().toString());
	}

}
