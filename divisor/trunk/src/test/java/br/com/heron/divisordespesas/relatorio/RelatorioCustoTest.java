package br.com.heron.divisordespesas.relatorio;

import static java.util.Arrays.asList;
import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.model.evento.Participante;

public class RelatorioCustoTest {

	
	protected Participante heron = new Participante("Heron");
	protected String quebraLinha = System.getProperty("line.separator");
	protected Categoria categoriaCarne = new Categoria("Carne");
	
	protected RelatorioCusto criaEventoERelatorio(TipoRelatorio tipo) {
		return criaEventoERelatorio(tipo,heron);
	}

	protected RelatorioCusto criaEventoERelatorio(TipoRelatorio tipo, Participante... participantes) {
		Evento evento = new Evento(asList(participantes));
		return FabricaRelatorio.getRelatorio(tipo, evento);
	}
	
	
	
}
