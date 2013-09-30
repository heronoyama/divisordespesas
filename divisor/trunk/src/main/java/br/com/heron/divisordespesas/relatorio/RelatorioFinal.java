package br.com.heron.divisordespesas.relatorio;

import static java.lang.String.format;
import static java.util.Locale.ENGLISH;


import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.model.evento.Participante;

class RelatorioFinal extends RelatorioParticipante {

	private String formatoLinha = "%s;R$%.2f;R$%.2f;R$%.2f;R$%.2f";

	RelatorioFinal(Evento evento) {
		super(evento);
	}

	@Override
	protected String formata() {
		Participante participante = proximoParticipante();
		String linha = format(ENGLISH,formatoLinha, 
				participante, 
				participante.valorContribuido(),
				evento.valorParaPagar(participante),
				evento.valorFinal(participante),
				evento.valorParaReceber(participante));
		return adicionaQuebraLinha(linha);
	}

	protected String getCabecalho() { return "Paritipante;Contribuicao;Divida;Valor Final;Valor Para Receber"; }
	

}
