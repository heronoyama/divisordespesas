package br.com.heron.divisordespesas.repositorio.memoria;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.repositorio.CategoriaRepository;

public class RepositorioCategoriaMemoria extends RepositorioMemoria<Categoria> implements CategoriaRepository {

	public void save(Categoria categoria){
		categoria.setId(id);
		persiste(categoria);
	}
	
}
