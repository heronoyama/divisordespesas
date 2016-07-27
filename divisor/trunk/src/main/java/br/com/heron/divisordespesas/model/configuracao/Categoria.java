package br.com.heron.divisordespesas.model.configuracao;

public class Categoria implements Comparable<Categoria>{

	private Integer id;
	private String nomeCategoria;

	public Categoria(String categoria) {
		this.nomeCategoria = categoria;
	}
	
	@Override
	public String toString() {
		return nomeCategoria;
	}

	public int compareTo(Categoria other) {
		return this.nomeCategoria.compareTo(other.nomeCategoria);
	}

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getNomeCategoria() {return nomeCategoria;}
	
	

}
