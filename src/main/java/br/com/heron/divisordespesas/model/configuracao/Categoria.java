package br.com.heron.divisordespesas.model.configuracao;

public class Categoria implements Comparable<Categoria>{

	private Integer id;
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

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

}
