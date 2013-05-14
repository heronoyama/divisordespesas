package br.com.heron.divisordespesas.repositorio;

import java.util.HashMap;
import java.util.Map;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.consumos.ConsumoParticipante;
import br.com.heron.divisordespesas.model.contribuicoes.Contribuicao;
import br.com.heron.divisordespesas.model.contribuicoes.ContribuicaoParticipante;
import br.com.heron.divisordespesas.model.grupo.Grupo;
import br.com.heron.divisordespesas.model.grupo.Participante;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioCategoriaMemoria;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioConsumoParticipanteMemoria;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioContribuicaoMemoria;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioContribuicaoParticipanteMemoria;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioGrupoMemoria;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioParticipanteMemoria;

public class Repositorios {
	
	private static Repositorios instance;
	private Map<Class<?>,Repository<?>> repositorios = new HashMap<Class<?>,Repository<?>>();
	
	public static Repositorios getInstance(){
		if(instance == null)
			instance = new Repositorios();
		return instance;
	}

	@SuppressWarnings("unchecked")
	public static <T> Repository<T> getRepository(Class<T> classe) {
		return (Repository<T>) getInstance().repositorios.get(classe);
	}
	
	public static <T> void registre(Class<T> classe, Repository<T> repository){
		getInstance().novoRegistro(classe, repository);
	}
	
	private <T> void novoRegistro(Class<T> classe, Repository<T> repository){
		repositorios.put(classe, repository);
	}
	
	private Repositorios(){}
	
	static {
		registraRepositorios();
	}

	private static void registraRepositorios() {
		registre(Participante.class,new RepositorioParticipanteMemoria());
		registre(Categoria.class,new RepositorioCategoriaMemoria());
		registre(Grupo.class,new RepositorioGrupoMemoria());
		registre(Contribuicao.class, new RepositorioContribuicaoMemoria());
		registre(ConsumoParticipante.class, new RepositorioConsumoParticipanteMemoria());
		registre(ContribuicaoParticipante.class, new RepositorioContribuicaoParticipanteMemoria());
	}

}
