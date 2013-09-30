package br.com.heron.divisordespesas.controller;

import java.util.List;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.evento.Participante;
import br.com.heron.divisordespesas.repositorio.ParticipanteRepository;

public class ParticipanteController {

	private ParticipanteRepository repository;

	public ParticipanteController(ParticipanteRepository repository) {
		this.repository = repository;
	}

	public Participante cria(String nome) {

		Participante participante = new Participante(nome);
		repository.save(participante);
		return participante;
	}

	public List<Participante> buscaTodos() {
		return repository.findAll();
	}

	public Participante busca(String nome) {
		for (Participante participante : buscaTodos()) {
			if (participante.getNome().contains(nome))
				return participante;
		}
		return null;
	}

	public Participante buscaOuCria(String nome) {
		Participante participante = busca(nome);
		return participante != null ? participante : cria(nome);
	}

	public void adicionaContribuicao(String nomeParticipante, Categoria categoria, double valor) {
		busca(nomeParticipante).contribuiu(categoria, valor);
	}

	public void adicionaConsumos(String nomeParticipante, Categoria... categorias) {
		busca(nomeParticipante).consumiu(categorias);
	}
}