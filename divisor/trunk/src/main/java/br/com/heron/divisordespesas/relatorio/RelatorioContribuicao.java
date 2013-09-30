package br.com.heron.divisordespesas.relatorio;


import br.com.heron.divisordespesas.model.contribuicoes.ContribuicaoParticipante;
import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.model.evento.Participante;

class RelatorioContribuicao extends RelatorioParticipante {

	RelatorioContribuicao(Evento evento) {
		super(evento);
	}
	
	protected String formata() {
		Participante participante = proximoParticipante();
		ContribuicaoParticipante contribuicao = participante.contribuicao();
		return super.formata(participante, contribuicao.valorContribuido());
	}
	
	protected String getCabecalho() { return "Participante;Valor Contribuido"; }

}
