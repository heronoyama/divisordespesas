package br.com.heron.divisordespesas.relatorio;

import java.util.List;

import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.model.evento.Participante;

abstract class RelatorioParticipante extends RelatorioCusto {

	protected Evento evento;
	protected List<Participante> participantes;

	RelatorioParticipante(Evento evento) {
		this.evento = evento;
		participantes = evento.participantes();
	}

	protected Participante proximoParticipante(){ return participantes.get(index++); }
	protected int getSize() { return participantes.size(); }

}