package br.com.heron.divisordespesas.repositorio.memoria;

import br.com.heron.divisordespesas.model.contribuicoes.Contribuicao;
import br.com.heron.divisordespesas.repositorio.ContribuicaoRepository;

public class RepositorioContribuicaoMemoria extends RepositorioMemoria<Contribuicao> implements ContribuicaoRepository {
	
	public void save(Contribuicao contribuicao){
		contribuicao.setId(id);
		persiste(contribuicao);
	}

}
