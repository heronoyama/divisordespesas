package br.com.heron.divisordespesas.repositorio.memoria;

import br.com.heron.divisordespesas.model.contribuicoes.ContribuicaoParticipante;
import br.com.heron.divisordespesas.repositorio.ContribuicaoParticipanteRepository;

public class RepositorioContribuicaoParticipanteMemoria extends RepositorioMemoria<ContribuicaoParticipante> implements ContribuicaoParticipanteRepository{
	
	public void save(ContribuicaoParticipante contribuicaoParticipante){
		contribuicaoParticipante.setId(id);
		persiste(contribuicaoParticipante);
	}


}
