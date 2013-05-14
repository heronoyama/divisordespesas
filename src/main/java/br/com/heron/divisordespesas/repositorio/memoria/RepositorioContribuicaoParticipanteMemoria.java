package br.com.heron.divisordespesas.repositorio.memoria;

import br.com.heron.divisordespesas.model.contribuicoes.ContribuicaoParticipante;
import br.com.heron.divisordespesas.repositorio.Repository;

public class RepositorioContribuicaoParticipanteMemoria extends RepositorioMemoria<ContribuicaoParticipante> implements Repository<ContribuicaoParticipante>{
	
	public void save(ContribuicaoParticipante contribuicaoParticipante){
		contribuicaoParticipante.setId(id);
		persiste(contribuicaoParticipante);
	}


}
