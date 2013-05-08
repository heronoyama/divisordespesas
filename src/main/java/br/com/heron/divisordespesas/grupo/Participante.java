package br.com.heron.divisordespesas.grupo;

import br.com.heron.divisordespesas.configuracao.Categoria;
import br.com.heron.divisordespesas.consumos.ConsumoParticipante;
import br.com.heron.divisordespesas.contribuicoes.ContribuicaoParticipante;

public class Participante implements Comparable<Participante> {

	private String nome;
	private ContribuicaoParticipante contribuicao = new ContribuicaoParticipante(this);
	private ConsumoParticipante consumo = new ConsumoParticipante(this); 

	public Participante(String nome) {
		this.nome = nome;
	}

	public void contribuiu(Categoria categoria, double valorGasto) {
		contribuicao.adicionaValor(categoria, valorGasto);
	}

	public double valorContribuido() {
		return contribuicao.valorContribuido();
	}

	public double valorContribuido(Categoria categoria) {
		return contribuicao.valorContribuido(categoria);
	}
	
	public ConsumoParticipante consumo(){
		return consumo;
	}

	public void consumiu(Categoria...categorias ) {
		consumo.adiciona(categorias);
	}
	
	public ContribuicaoParticipante contribuicao() {
		return contribuicao;
	}
	
	@Override
	public String toString() {
		return nome;
	}

	public int compareTo(Participante o) {
		return nome.compareTo(o.nome);
	}

}
