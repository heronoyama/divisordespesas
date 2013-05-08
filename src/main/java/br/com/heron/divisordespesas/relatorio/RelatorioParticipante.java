package br.com.heron.divisordespesas.relatorio;

import java.util.List;

import br.com.heron.divisordespesas.grupo.Grupo;
import br.com.heron.divisordespesas.grupo.Participante;

abstract class RelatorioParticipante extends RelatorioCusto {

	protected Grupo grupo;
	protected List<Participante> participantes;

	public RelatorioParticipante(Grupo grupo) {
		this.grupo = grupo;
		participantes = grupo.participantes();
	}

	protected Participante proximoParticipante(){ return participantes.get(index++); }
	protected int getSize() { return participantes.size(); }

}