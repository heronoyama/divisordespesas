package br.com.heron.divisordespesas.repositorio.memoria;

import br.com.heron.divisordespesas.model.grupo.Participante;
import br.com.heron.divisordespesas.repositorio.Repository;

public class RepositorioParticipanteMemoria extends RepositorioMemoria<Participante> implements Repository<Participante> {
	
	public void save(Participante participante){
		participante.setId(id);
		persiste(participante);
	}
	
}