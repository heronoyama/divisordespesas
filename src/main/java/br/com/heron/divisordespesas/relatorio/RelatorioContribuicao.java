package br.com.heron.divisordespesas.relatorio;


import br.com.heron.divisordespesas.contribuicoes.ContribuicaoParticipante;
import br.com.heron.divisordespesas.grupo.Grupo;
import br.com.heron.divisordespesas.grupo.Participante;

class RelatorioContribuicao extends RelatorioParticipante {

	public RelatorioContribuicao(Grupo grupo) {
		super(grupo);
	}
	
	protected String formata() {
		Participante participante = proximoParticipante();
		ContribuicaoParticipante contribuicao = participante.contribuicao();
		return super.formata(participante, contribuicao.valorContribuido());
	}
	
	protected String getCabecalho() { return "Participante,Valor Contribuido"; }

}
