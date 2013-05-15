package br.com.heron.divisordespesas.controller;

import java.util.Collections;
import java.util.List;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.repositorio.CategoriaRepository;

public class CategoriaController {

	private CategoriaRepository repositorio;

	public CategoriaController(CategoriaRepository repositorio) {
		this.repositorio = repositorio;
	}

	public Categoria criaCategoria(String nome) {
		Categoria categoria = new Categoria(nome);
		repositorio.save(categoria);
		return categoria;
	}

	public Categoria busca(String string) {
		for (Categoria categoria : buscaTodos()) {
			if(categoria.getNomeCategoria().contains(string))
				return categoria;
		}
		return null;
	}

	public List<Categoria> buscaTodos() {
		List<Categoria> todos = repositorio.findAll();
		Collections.sort(todos);
		return todos;
	}

}
