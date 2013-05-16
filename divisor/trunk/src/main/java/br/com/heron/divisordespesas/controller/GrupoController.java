package br.com.heron.divisordespesas.controller;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import br.com.heron.divisordespesas.model.grupo.Grupo;
import br.com.heron.divisordespesas.model.grupo.Participante;
import br.com.heron.divisordespesas.repositorio.GrupoRepository;

public class GrupoController {

	private GrupoRepository repositorio;

	public GrupoController(GrupoRepository repositorio) {
		this.repositorio = repositorio;
	}

	public Grupo criaGrupo(List<Participante> todosParticipantes) {
		Grupo grupo = new Grupo(todosParticipantes);
		repositorio.save(grupo);
		return grupo;
	}
	public Grupo criaGrupo(Participante... participantes) {
		return criaGrupo(asList(participantes));
	}

	public List<Grupo> grupos(Participante participante) {
		List<Grupo> grupos = new ArrayList<Grupo>();
		for (Grupo grupo : repositorio.findAll()) {
			if(grupo.participantes().contains(participante))
				grupos.add(grupo);
		}
		return grupos;
	}

}