package br.com.heron.divisordespesas.repositorio.memoria;

import br.com.heron.divisordespesas.model.grupo.Grupo;
import br.com.heron.divisordespesas.repositorio.GrupoRepository;

public class RepositorioGrupoMemoria extends RepositorioMemoria<Grupo> implements GrupoRepository {
	
	public void save(Grupo grupo){
		grupo.setId(id);
		persiste(grupo);
	}
	
}
