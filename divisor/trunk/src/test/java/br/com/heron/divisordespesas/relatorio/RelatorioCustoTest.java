package br.com.heron.divisordespesas.relatorio;

import static java.util.Arrays.asList;
import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.grupo.Grupo;
import br.com.heron.divisordespesas.model.grupo.Participante;

public class RelatorioCustoTest {

	
	protected Participante heron = new Participante("Heron");
	protected String quebraLinha = System.getProperty("line.separator");
	protected Categoria categoriaCarne = new Categoria("Carne");
	
	protected RelatorioCusto criaGrupoERelatorio(TipoRelatorio tipo) {
		return criaGrupoERelatorio(tipo,heron);
	}

	protected RelatorioCusto criaGrupoERelatorio(TipoRelatorio tipo, Participante... participantes) {
		Grupo grupo = new Grupo(asList(participantes));
		return FabricaRelatorio.getRelatorio(tipo, grupo);
	}
	
	
	
}
