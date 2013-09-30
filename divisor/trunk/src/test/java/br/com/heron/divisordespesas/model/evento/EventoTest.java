package br.com.heron.divisordespesas.model.evento;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.model.evento.Participante;

public class EventoTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private Participante participante = new Participante("Heron");

	@Test
	public void criaParticipanteEEvento() {
		Participante participante2 = criaSegundoParticipante();

		Evento evento = criaEvento(asList(participante, participante2));

		assertEquals("[Heron, Oyama]", evento.participantes().toString());
		assertEquals(2, evento.quantidadeParticipantes());
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
	public void consumosDoEvento() {
		participante.consumiu(criaCategoria("Carne"));
		participante.consumiu(criaCategoria("Bebida"));

		Evento evento = criaEvento(asList(participante));
		assertEquals("[Bebida, Carne]", evento.consumos().toString());
	}
	
	@Test
	public void naoCriaEventoComParticipantesNulo(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Para criar-se um evento é necessário de participantes.");
		new Evento(null);
	}
	
	@Test
	public void naoCriaEventoComParticipantesVazios(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Para criar-se um evento é necessário de participantes.");
		new Evento(new ArrayList<Participante>());
	}
	

	private Evento criaEvento(List<Participante> participantes) {
		return new Evento(participantes);
	}

	private Participante criaSegundoParticipante() {
		return new Participante("Oyama");
	}

	private Categoria criaCategoria(String nomeCategoria) {
		return new Categoria(nomeCategoria);
	}
}
