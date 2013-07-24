package br.com.heron.divisordespesas.relatorio;


import br.com.heron.divisordespesas.model.grupo.Grupo;
import br.com.heron.divisordespesas.model.grupo.Participante;

class RelatorioAReceber extends RelatorioParticipante{
	
	public RelatorioAReceber(Grupo grupo){
		super(grupo);
	}

	protected String getCabecalho() { return "Participante;A Receber"; }


	protected String formata() {
		Participante participante = proximoParticipante();
		return super.formata(participante, grupo.valorParaReceber(participante));
	}

}
