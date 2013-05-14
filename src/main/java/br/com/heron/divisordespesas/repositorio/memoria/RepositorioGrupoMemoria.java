package br.com.heron.divisordespesas.repositorio.memoria;

import br.com.heron.divisordespesas.model.grupo.Grupo;
import br.com.heron.divisordespesas.repositorio.Repository;

public class RepositorioGrupoMemoria extends RepositorioMemoria<Grupo> implements Repository<Grupo> {
	
	public void save(Grupo grupo){
		grupo.setId(id);
		persiste(grupo);
	}
	
}
