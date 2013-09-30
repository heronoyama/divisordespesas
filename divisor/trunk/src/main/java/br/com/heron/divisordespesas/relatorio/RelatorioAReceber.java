package br.com.heron.divisordespesas.relatorio;


import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.model.evento.Participante;

class RelatorioAReceber extends RelatorioParticipante{
	
	public RelatorioAReceber(Evento evento){
		super(evento);
	}

	protected String getCabecalho() { return "Participante;A Receber"; }


	protected String formata() {
		Participante participante = proximoParticipante();
		return super.formata(participante, evento.valorParaReceber(participante));
	}

}
