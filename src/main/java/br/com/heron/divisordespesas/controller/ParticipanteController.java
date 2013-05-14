package br.com.heron.divisordespesas.controller;

import static br.com.heron.divisordespesas.repositorio.Repositorios.getRepository;

import java.util.List;

import br.com.heron.divisordespesas.model.grupo.Participante;
import br.com.heron.divisordespesas.repositorio.Repository;

public class ParticipanteController {
	
	public Participante criaParticipante(String nome){
		
		Participante participante = new Participante(nome);
		repositorio().save(participante);
		return participante;
	}

	private Repository<Participante> repositorio() {
		return getRepository(Participante.class);
	}

	public List<Participante> todosParticipantes() {
		return repositorio().findAll();
	}

}
