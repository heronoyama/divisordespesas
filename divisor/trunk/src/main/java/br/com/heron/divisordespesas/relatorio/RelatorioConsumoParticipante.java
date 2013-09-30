package br.com.heron.divisordespesas.relatorio;

import static java.lang.String.format;
import static java.util.Locale.ENGLISH;
import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.model.evento.Participante;

class RelatorioConsumoParticipante extends RelatorioParticipante {

	RelatorioConsumoParticipante(Evento evento) {
		super(evento);
	}

	@Override
	protected String getCabecalho() {
		return "Participante;Consumos";
	}

	@Override
	protected String formata() {
		Participante participante = proximoParticipante();
		return adicionaQuebraLinha(format(ENGLISH, "%s;%s",participante, participante.consumo().categorias().toString().replaceAll(",",";")));
	}

}
