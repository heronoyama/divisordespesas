package br.com.heron.divisordespesas.repositorio.memoria;

import br.com.heron.divisordespesas.model.consumos.ConsumoParticipante;
import br.com.heron.divisordespesas.repositorio.ConsumoParticipanteRepository;

public class RepositorioConsumoParticipanteMemoria extends RepositorioMemoria<ConsumoParticipante> implements ConsumoParticipanteRepository{
	
	public void save(ConsumoParticipante consumoParticipante){
		consumoParticipante.setId(id);
		persiste(consumoParticipante);
	}

	

}
