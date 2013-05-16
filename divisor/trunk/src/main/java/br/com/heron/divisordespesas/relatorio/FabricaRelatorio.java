package br.com.heron.divisordespesas.relatorio;

import static br.com.heron.divisordespesas.relatorio.TipoRelatorio.*;

import java.util.HashMap;
import java.util.Map;

import br.com.heron.divisordespesas.model.grupo.Grupo;

public class FabricaRelatorio {
	
	public static RelatorioCusto getRelatorio(TipoRelatorio tipo, Grupo grupo){
		return new FabricaRelatorio(grupo).get(tipo);
	}

	private Map<TipoRelatorio,RelatorioCusto> mapa = new HashMap<TipoRelatorio,RelatorioCusto>();

	private FabricaRelatorio(Grupo grupo) {
		if(grupo == null)
			throw new IllegalArgumentException("Especifique um grupo.");
		
		mapa.put(CONTRIBUICAO,new RelatorioContribuicao(grupo));
		mapa.put(DIVISAO_CONSUMO_CATEGORIA,new RelatorioDivisaoConsumoCategoria(grupo));
		mapa.put(DIVIDA,new RelatorioDivida(grupo));
		mapa.put(ARECEBER,new RelatorioAReceber(grupo));
		mapa.put(GASTO_CATEGORIA,new RelatorioGastoPorCategoria(grupo));
		mapa.put(CONSUMO_PARTICIPANTE,new RelatorioConsumoParticipante(grupo));
		mapa.put(VALOR_CATEGORIA,new RelatorioValorCategoria(grupo));
		mapa.put(FINAL,new RelatorioFinal(grupo));
	}


	private RelatorioCusto get(TipoRelatorio tipo) {
		if(tipo == null)
			throw new IllegalArgumentException("Especifique um tipo de relatório.");
		
		if(!mapa.containsKey(tipo))
			throw new IllegalArgumentException("Tipo de Relatório inexistente");
		return mapa.get(tipo);
	}

}
