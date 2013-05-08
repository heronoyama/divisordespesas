package br.com.heron.divisordespesas.contribuicoes;

import br.com.heron.divisordespesas.configuracao.Categoria;

public class Contribuicao implements Comparable<Contribuicao>{

	private Categoria categoria;
	private double valorGasto = 0.0;
	
	public Contribuicao(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return categoria.toString() + " : " + valorGasto;
	}

	public void adicionaGasto(double valorGasto) {
		this.valorGasto += valorGasto;
	}

	public double valorGasto() {
		return valorGasto;
	}

	public int compareTo(Contribuicao other) {
		return categoria.compareTo(other.categoria);
	}
	
}
