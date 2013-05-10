package br.com.heron.divisordespesas.relatorio;


import br.com.heron.divisordespesas.grupo.Grupo;
import br.com.heron.divisordespesas.grupo.Participante;

class RelatorioDivida extends RelatorioParticipante {

	RelatorioDivida(Grupo grupo) {
		super(grupo);
	}

	protected String formata() {
		Participante participante = participantes.get(index++);
		return super.formata(participante, grupo.valorParaPagar(participante));
	}

	protected String getCabecalho() { return "Participante,Divida"; }

}
