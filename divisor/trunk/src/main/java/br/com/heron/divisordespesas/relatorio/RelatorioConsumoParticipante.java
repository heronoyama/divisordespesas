package br.com.heron.divisordespesas.relatorio;

import static java.lang.String.format;
import static java.util.Locale.ENGLISH;
import br.com.heron.divisordespesas.model.grupo.Grupo;
import br.com.heron.divisordespesas.model.grupo.Participante;

class RelatorioConsumoParticipante extends RelatorioParticipante {

	RelatorioConsumoParticipante(Grupo grupo) {
		super(grupo);
	}

	@Override
	protected String getCabecalho() {
		return "Participante,Consumos";
	}

	@Override
	protected String formata() {
		Participante participante = proximoParticipante();
		return adicionaQuebraLinha(format(ENGLISH, "%s,%s",participante, participante.consumo().categorias()));
	}

}
