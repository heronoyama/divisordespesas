package br.com.heron.divisordespesas.relatorio;

import static java.lang.String.format;
import static java.util.Locale.ENGLISH;


import br.com.heron.divisordespesas.model.grupo.Grupo;
import br.com.heron.divisordespesas.model.grupo.Participante;

class RelatorioFinal extends RelatorioParticipante {

	private String formatoLinha = "%s;R$%.2f;R$%.2f;R$%.2f;R$%.2f";

	RelatorioFinal(Grupo grupo) {
		super(grupo);
	}

	@Override
	protected String formata() {
		Participante participante = proximoParticipante();
		String linha = format(ENGLISH,formatoLinha, 
				participante, 
				participante.valorContribuido(),
				grupo.valorParaPagar(participante),
				grupo.valorFinal(participante),
				grupo.valorParaReceber(participante));
		return adicionaQuebraLinha(linha);
	}

	protected String getCabecalho() { return "Paritipante;Contribuicao;Divida;Valor Final;Valor Para Receber"; }
	

}
