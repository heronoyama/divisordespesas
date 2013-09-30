package br.com.heron.divisordespesas.repositorio.memoria;

import br.com.heron.divisordespesas.model.evento.Participante;
import br.com.heron.divisordespesas.repositorio.ParticipanteRepository;

public class RepositorioParticipanteMemoria extends RepositorioMemoria<Participante> implements ParticipanteRepository {
	
	public void save(Participante participante){
		participante.setId(id);
		persiste(participante);
	}
	
}