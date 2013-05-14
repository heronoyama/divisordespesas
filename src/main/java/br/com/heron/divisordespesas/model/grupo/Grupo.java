package br.com.heron.divisordespesas.model.grupo;

import static java.util.Collections.sort;

import java.util.List;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.grupo.calculadora.Calculadora;

public class Grupo {

	private Integer id;
	private List<Participante> participantes;
	private Calculadora calculadora;

	public Grupo(List<Participante> participantes) {
		setParticipantes(participantes);
		calculadora = new Calculadora(participantes);
	}

	private void setParticipantes(List<Participante> participantes) {
		if(participantes == null || participantes.isEmpty())
			throw new IllegalArgumentException("Para criar-se um grupo é necessário de participantes.");
		this.participantes = participantes;
	}

	public int quantidadeParticipantes() {
		return participantes.size();
	}

	public double contribuicaoTotal() {
		return calculadora.contribuicaoTotal();
	}

	public double contribuicao(Categoria categoria) {
		return calculadora.contribuicao(categoria);
	}

	public List<Participante> participantes() {
		sort(participantes);
		return participantes;
	}

	public List<Categoria> consumos() {
		return calculadora.consumos();
	}

	public List<Participante> consumidores(Categoria categoria) {
		return calculadora.consumidores(categoria);
	}

	public double valorFinal(Categoria categoria) {
		return calculadora.valorFinal(categoria);
	}

	public double valorFinal(Participante participante) {
		return calculadora.valorFinal(participante);
	}

	public double valorParaReceber(Participante participante) {
		return calculadora.valorParaReceber(participante);
	}

	public double valorParaPagar(Participante participante) {
		return calculadora.valorParaPagar(participante);
	}

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

}
