package br.com.heron.divisordespesas.relatorio;

import java.util.List;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.grupo.Grupo;

class RelatorioDivisaoConsumoCategoria extends RelatorioCusto {

	private Grupo grupo;
	private List<Categoria> categorias;
	
	RelatorioDivisaoConsumoCategoria(Grupo grupo) {
		this.grupo = grupo;
		categorias = grupo.consumos();
	}

	protected String formata() {
		Categoria categoria = proximaCategoria();
		return super.formata(categoria, grupo.valorFinal(categoria));
	}
	
	private Categoria proximaCategoria(){ return categorias.get(index++); }

	protected int getSize() { return categorias.size(); }

	protected String getCabecalho() { return "Categoria,Valor Consumido"; }
}