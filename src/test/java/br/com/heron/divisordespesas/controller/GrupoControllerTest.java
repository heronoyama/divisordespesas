package br.com.heron.divisordespesas.controller;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.heron.divisordespesas.model.grupo.Grupo;
import br.com.heron.divisordespesas.model.grupo.Participante;
import br.com.heron.divisordespesas.repositorio.GrupoRepository;
import br.com.heron.divisordespesas.repositorio.ParticipanteRepository;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioGrupoMemoria;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioParticipanteMemoria;

public class GrupoControllerTest {

	private GrupoRepository repositorioGrupo = new RepositorioGrupoMemoria();
	private ParticipanteRepository repositorioParticipante = new RepositorioParticipanteMemoria();
	private ParticipanteController participanteController;
	private GrupoController grupoController;

	@Before
	public void setUp() {
		participanteController = new ParticipanteController(repositorioParticipante);
		grupoController = new GrupoController(repositorioGrupo);
	}

	@Test
	public void criaGrupo() {
		participanteController.cria("Heron");
		participanteController.cria("Oyama");

		Grupo grupo = grupoController.criaGrupo(participanteController.buscaTodos());
		assertEquals("[Heron, Oyama]", grupo.participantes().toString());
	}

	@Test
	public void gruposDoParticipantePorNome() {
		Participante heron = participanteController.cria("Heron");
		Participante oyama = participanteController.cria("Oyama");
		Participante kazuhiro = participanteController.cria("Kazuhiro");

		grupoController.criaGrupo(heron,oyama);
		grupoController.criaGrupo(heron,kazuhiro);

		List<Grupo> grupos = grupoController.grupos(heron);
		assertEquals(2, grupos.size());

		grupos = grupoController.grupos(oyama);
		assertEquals(1, grupos.size());
		assertEquals("[Heron, Oyama]", grupos.get(0).participantes().toString());

	}
}