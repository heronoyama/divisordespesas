package br.com.heron.divisordespesas.model.grupo;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.grupo.Grupo;
import br.com.heron.divisordespesas.model.grupo.Participante;

public class GrupoTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private Participante participante = new Participante("Heron");

	@Test
	public void criaParticipanteEGrupo() {
		Participante participante2 = criaSegundoParticipante();

		Grupo grupo = criaGrupo(asList(participante, participante2));

		assertEquals("[Heron, Oyama]", grupo.participantes().toString());
		assertEquals(2, grupo.quantidadeParticipantes());
	}

	@Test
	public void adicionaCategoriaConsumida() {
		participante.consumiu(criaCategoria("Carne"));
		assertEquals("[Carne]", participante.consumo().categorias().toString());
	}

	@Test
	public void adicionaMaisCategorias() {
		participante.consumiu(criaCategoria("Carne"), criaCategoria("Bebida"));
		assertEquals("[Bebida, Carne]", participante.consumo().categorias().toString());
	}

	@Test
	public void consumosDoGrupo() {
		participante.consumiu(criaCategoria("Carne"));
		participante.consumiu(criaCategoria("Bebida"));

		Grupo grupo = criaGrupo(asList(participante));
		assertEquals("[Bebida, Carne]", grupo.consumos().toString());
	}
	
	@Test
	public void naoCriaGrupoComParticipantesNulo(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Para criar-se um grupo é necessário de participantes.");
		new Grupo(null);
	}
	
	@Test
	public void naoCriaGrupoComParticipantesVazios(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Para criar-se um grupo é necessário de participantes.");
		new Grupo(new ArrayList<Participante>());
	}
	

	private Grupo criaGrupo(List<Participante> participantes) {
		return new Grupo(participantes);
	}

	private Participante criaSegundoParticipante() {
		return new Participante("Oyama");
	}

	private Categoria criaCategoria(String nomeCategoria) {
		return new Categoria(nomeCategoria);
	}
}
