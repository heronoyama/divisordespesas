package br.com.heron.divisordespesas.configuracao;

public class Categoria implements Comparable<Categoria>{

	private String categoria;

	public Categoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return categoria;
	}

	public int compareTo(Categoria other) {
		return this.categoria.compareTo(other.categoria);
	}

}
