package br.com.heron.divisordespesas.controller;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.model.evento.Participante;
import br.com.heron.divisordespesas.repositorio.EventoRepository;

public class EventoController {

	private EventoRepository repositorio;

	public EventoController(EventoRepository repositorio) {
		this.repositorio = repositorio;
	}

	public Evento criaEvento(List<Participante> todosParticipantes) {
		Evento evento = new Evento(todosParticipantes);
		repositorio.save(evento);
		return evento;
	}
	public Evento criaEvento(Participante... participantes) {
		return criaEvento(asList(participantes));
	}

	public List<Evento> eventos(Participante participante) {
		List<Evento> eventos = new ArrayList<Evento>();
		for (Evento evento : repositorio.findAll()) {
			if(evento.participantes().contains(participante))
				eventos.add(evento);
		}
		return eventos;
	}

}