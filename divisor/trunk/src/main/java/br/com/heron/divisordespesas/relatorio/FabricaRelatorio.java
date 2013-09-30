package br.com.heron.divisordespesas.relatorio;

import static br.com.heron.divisordespesas.relatorio.TipoRelatorio.*;

import java.util.HashMap;
import java.util.Map;

import br.com.heron.divisordespesas.model.evento.Evento;

public class FabricaRelatorio {
	
	public static RelatorioCusto getRelatorio(TipoRelatorio tipo, Evento evento){
		return new FabricaRelatorio(evento).get(tipo);
	}

	private Map<TipoRelatorio,RelatorioCusto> mapa = new HashMap<TipoRelatorio,RelatorioCusto>();

	private FabricaRelatorio(Evento evento) {
		if(evento == null)
			throw new IllegalArgumentException("Especifique um evento.");
		
		mapa.put(CONTRIBUICAO,new RelatorioContribuicao(evento));
		mapa.put(DIVISAO_CONSUMO_CATEGORIA,new RelatorioDivisaoConsumoCategoria(evento));
		mapa.put(DIVIDA,new RelatorioDivida(evento));
		mapa.put(ARECEBER,new RelatorioAReceber(evento));
		mapa.put(GASTO_CATEGORIA,new RelatorioGastoPorCategoria(evento));
		mapa.put(CONSUMO_PARTICIPANTE,new RelatorioConsumoParticipante(evento));
		mapa.put(VALOR_CATEGORIA,new RelatorioValorCategoria(evento));
		mapa.put(FINAL,new RelatorioFinal(evento));
	}


	private RelatorioCusto get(TipoRelatorio tipo) {
		if(tipo == null)
			throw new IllegalArgumentException("Especifique um tipo de relatório.");
		
		if(!mapa.containsKey(tipo))
			throw new IllegalArgumentException("Tipo de Relatório inexistente");
		return mapa.get(tipo);
	}

}
