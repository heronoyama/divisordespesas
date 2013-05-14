package br.com.heron.divisordespesas.repositorio.memoria;

import br.com.heron.divisordespesas.model.contribuicoes.Contribuicao;
import br.com.heron.divisordespesas.repositorio.Repository;

public class RepositorioContribuicaoMemoria extends RepositorioMemoria<Contribuicao> implements Repository<Contribuicao> {
	
	public void save(Contribuicao contribuicao){
		contribuicao.setId(id);
		persiste(contribuicao);
	}

}
