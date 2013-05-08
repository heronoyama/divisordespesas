package br.com.heron.divisordespesas.contribuicoes;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.heron.divisordespesas.configuracao.Categoria;
import br.com.heron.divisordespesas.grupo.Participante;

public class ContribuicaoParticipante {
	
	private Map<Categoria,Contribuicao> contribuicoes = new HashMap<Categoria,Contribuicao>();
	private Participante participante;
	
	public ContribuicaoParticipante(Participante participante) {
		this.participante = participante;
	}
	
	@Override
	public String toString() {
		List<Contribuicao> todasContribuicoes = Arrays.asList(contribuicoes.values().toArray(new Contribuicao[0]));
		Collections.sort(todasContribuicoes);
		return participante.toString() + " : " + todasContribuicoes.toString();
	}

	public void adicionaValor(Categoria categoria, double valor) {
		contribuicao(categoria).adicionaGasto(valor);
	}

	public double valorContribuido(Categoria categoria) {
		return contribuicao(categoria).valorGasto();
	}

	public double valorContribuido() {
		double valorTotal = 0.0;
		for (Contribuicao contribuicao : contribuicoes.values()) {
			valorTotal += contribuicao.valorGasto();
		}
		return valorTotal;
	}

	private Contribuicao contribuicao(Categoria categoria){
		if(!contribuicoes.containsKey(categoria))
			contribuicoes.put(categoria, new Contribuicao(categoria));
		return contribuicoes.get(categoria);
	}
}
