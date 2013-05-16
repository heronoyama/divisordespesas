package br.com.heron.divisordespesas.relatorio;

import java.util.List;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.grupo.Grupo;

class RelatorioValorCategoria extends RelatorioCusto {

	private Grupo grupo;
	private List<Categoria> categorias;

	RelatorioValorCategoria(Grupo grupo) {
		this.grupo = grupo;
		categorias = grupo.consumos();
	}

	protected String getCabecalho() {
		return "Categoria, Valor Por Participante";
	}
	
	private Categoria proximaCategoria(){ return categorias.get(index++); }

	protected int getSize() { return categorias.size(); }

	protected String formata() {
		Categoria categoria = proximaCategoria();
		return super.formata(categoria, grupo.valorFinal(categoria));
	}

}
