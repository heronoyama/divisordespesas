package br.com.heron.divisordespesas.model.contribuicoes;

import br.com.heron.divisordespesas.model.configuracao.Categoria;

public class Contribuicao implements Comparable<Contribuicao>{

	private Integer id;
	private Categoria categoria;
	private double valorGasto = 0.0;
	
	public Contribuicao(Categoria categoria) {
		setCategoria(categoria);
	}

	private void setCategoria(Categoria categoria) {
		if(categoria == null)
			throw new IllegalArgumentException("Contribuição deve ser sobre uma categoria.");
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return categoria.toString() + " : " + valorGasto;
	}

	public void adicionaGasto(double valorGasto) {
		if(valorGasto < 0)
			throw new IllegalArgumentException("Contribuição deve ter tido gasto positivo.");
		this.valorGasto += valorGasto;
	}

	public double valorGasto() { return valorGasto; }

	public int compareTo(Contribuicao other) {
		return categoria.compareTo(other.categoria);
	}

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }
	
}
