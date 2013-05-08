package br.com.heron.divisordespesas.relatorio;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import br.com.heron.divisordespesas.configuracao.Categoria;

public class RelatorioConsumoCategoriaTest extends RelatorioCustoTest{
	
	@Test
	public void imprimeCabecalho(){
		RelatorioCusto relatorio = criaGrupoERelatorio(TipoRelatorio.CONSUMO);
		assertEquals("Categoria,Valor Consumido"+quebraLinha, relatorio.cabecalho());
	}
	
	@Test
	public void imprimeUnicoConsumo() {
		heron.consumiu(categoriaCarne);
		heron.contribuiu(categoriaCarne, 10.0);
		
		RelatorioCusto relatorio = criaGrupoERelatorio(TipoRelatorio.CONSUMO);
		assertEquals("Carne,R$10.00"+quebraLinha, relatorio.proximaLinha());
	}
	
	@Test
	public void imprimeConsumoSemGasto(){
		heron.consumiu(categoriaCarne);
		
		RelatorioCusto relatorio = criaGrupoERelatorio(TipoRelatorio.CONSUMO);
		assertEquals("Carne,R$0.00"+quebraLinha, relatorio.proximaLinha());
	}
	
	@Test
	public void imprimeAteOFim(){
		heron.consumiu(categoriaCarne);
		
		RelatorioCusto relatorio = criaGrupoERelatorio(TipoRelatorio.CONSUMO);
		assertEquals("Carne,R$0.00"+quebraLinha, relatorio.proximaLinha());
		assertEquals("", relatorio.proximaLinha());
		assertEquals("", relatorio.proximaLinha());
	}
	
	@Test
	public void imprimeDuasCategorias(){
		heron.consumiu(categoriaCarne);
		Categoria categoriaBebida = new Categoria("Bebida");
		heron.consumiu(categoriaBebida);
		heron.contribuiu(categoriaBebida, 10.5);
		
		RelatorioCusto relatorio = criaGrupoERelatorio(TipoRelatorio.CONSUMO);
		assertEquals("Bebida,R$10.50"+quebraLinha,relatorio.proximaLinha());
		assertEquals("Carne,R$0.00"+quebraLinha,relatorio.proximaLinha());
		assertEquals("",relatorio.proximaLinha());
		
	}

}