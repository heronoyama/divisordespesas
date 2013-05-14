package br.com.heron.divisordespesas.repositorio.memoria;

import br.com.heron.divisordespesas.model.consumos.ConsumoParticipante;
import br.com.heron.divisordespesas.repositorio.Repository;

public class RepositorioConsumoParticipanteMemoria extends RepositorioMemoria<ConsumoParticipante> implements Repository<ConsumoParticipante>{
	
	public void save(ConsumoParticipante consumoParticipante){
		consumoParticipante.setId(id);
		persiste(consumoParticipante);
	}

	

}
