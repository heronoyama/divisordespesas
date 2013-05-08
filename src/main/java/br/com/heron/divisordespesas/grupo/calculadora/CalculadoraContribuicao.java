package br.com.heron.divisordespesas.grupo.calculadora;

import java.util.ArrayList;
import java.util.List;

import br.com.heron.divisordespesas.configuracao.Categoria;
import br.com.heron.divisordespesas.contribuicoes.ContribuicaoParticipante;
import br.com.heron.divisordespesas.grupo.Participante;

class CalculadoraContribuicao {

	private List<ContribuicaoParticipante> contribuicoes = new ArrayList<ContribuicaoParticipante>();
	
	public CalculadoraContribuicao(List<Participante> participantes){
		for (Participante participante : participantes) {
			contribuicoes.add(participante.contribuicao());
		}
	}
	
	public double contribuicaoTotal() {
		double gastoTotal = 0;
		for (ContribuicaoParticipante contribuicao : contribuicoes) {
			gastoTotal += contribuicao.valorContribuido();
		}
		return gastoTotal;
	}
	
	public double contribuicao(Categoria categoria) {
		double gastoTotal = 0;
		for (ContribuicaoParticipante contribuicao : contribuicoes) {
			gastoTotal += contribuicao.valorContribuido(categoria);
		}
		return gastoTotal;
	}
}
