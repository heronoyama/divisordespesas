package br.com.heron.divisordespesas.model;

public class Atributo implements Comparable<Atributo>{
	
	private String tipo;
	private String nome;
	private String valor;

	public Atributo(String tipo, String nome, String valor) {
		this.tipo = tipo;
		this.nome = nome;
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return String.format("%s [%s]: %s",tipo,nome,valor);
	}

	@Override
	public int compareTo(Atributo o) {
		return tipo.compareTo(o.tipo);
	}
	

}
