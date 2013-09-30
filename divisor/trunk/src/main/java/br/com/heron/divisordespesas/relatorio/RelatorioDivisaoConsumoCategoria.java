package br.com.heron.divisordespesas.relatorio;

import java.util.List;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.evento.Evento;

class RelatorioDivisaoConsumoCategoria extends RelatorioCusto {

	private Evento evento;
	private List<Categoria> categorias;
	
	RelatorioDivisaoConsumoCategoria(Evento evento) {
		this.evento = evento;
		categorias = evento.consumos();
	}

	protected String formata() {
		Categoria categoria = proximaCategoria();
		return super.formata(categoria, evento.valorFinal(categoria));
	}
	
	private Categoria proximaCategoria(){ return categorias.get(index++); }

	protected int getSize() { return categorias.size(); }

	protected String getCabecalho() { return "Categoria;Valor Consumido"; }
}