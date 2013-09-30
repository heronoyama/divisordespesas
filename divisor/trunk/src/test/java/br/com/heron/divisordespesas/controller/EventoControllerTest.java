package br.com.heron.divisordespesas.controller;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.model.evento.Participante;
import br.com.heron.divisordespesas.repositorio.EventoRepository;
import br.com.heron.divisordespesas.repositorio.ParticipanteRepository;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioEventoMemoria;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioParticipanteMemoria;

public class EventoControllerTest {

	private EventoRepository repositorioEvento = new RepositorioEventoMemoria();
	private ParticipanteRepository repositorioParticipante = new RepositorioParticipanteMemoria();
	private ParticipanteController participanteController;
	private EventoController eventoController;

	@Before
	public void setUp() {
		participanteController = new ParticipanteController(repositorioParticipante);
		eventoController = new EventoController(repositorioEvento);
	}

	@Test
	public void criaEvento() {
		participanteController.cria("Heron");
		participanteController.cria("Oyama");

		Evento evento = eventoController.criaEvento(participanteController.buscaTodos());
		assertEquals("[Heron, Oyama]", evento.participantes().toString());
	}

	@Test
	public void eventosDoParticipantePorNome() {
		Participante heron = participanteController.cria("Heron");
		Participante oyama = participanteController.cria("Oyama");
		Participante kazuhiro = participanteController.cria("Kazuhiro");

		eventoController.criaEvento(heron,oyama);
		eventoController.criaEvento(heron,kazuhiro);

		List<Evento> eventos = eventoController.eventos(heron);
		assertEquals(2, eventos.size());

		eventos = eventoController.eventos(oyama);
		assertEquals(1, eventos.size());
		assertEquals("[Heron, Oyama]", eventos.get(0).participantes().toString());

	}
}