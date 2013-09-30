package br.com.heron.divisordespesas.relatorio;


import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.model.evento.Participante;

class RelatorioDivida extends RelatorioParticipante {

	RelatorioDivida(Evento evento) {
		super(evento);
	}

	protected String formata() {
		Participante participante = participantes.get(index++);
		return super.formata(participante, evento.valorParaPagar(participante));
	}

	protected String getCabecalho() { return "Participante;Divida"; }

}
