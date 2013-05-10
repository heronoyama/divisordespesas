package br.com.heron.divisordespesas.relatorio;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.heron.divisordespesas.configuracao.Categoria;
import br.com.heron.divisordespesas.grupo.Participante;

public class RelatorioConsumoPorParticipanteTest extends RelatorioCustoTest {

	private Categoria categoriaBebida = new Categoria("Bebida");
	private Participante kazuhiro = new Participante("Kazuhiro");
	
	@Before
	public void setUp(){
		heron.contribuiu(categoriaCarne, 15.0);
		heron.consumiu(categoriaCarne);
	}
	
	@Test
	public void cabecalho() {
		RelatorioCusto relatorio = criaGrupoERelatorio(TipoRelatorio.CONSUMO_PARTICIPANTE);
		assertEquals("Participante,Consumos"+quebraLinha,relatorio.cabecalho());
	}
	
	@Test
	public void unicoConsumidor(){
		
		RelatorioCusto relatorio = criaGrupoERelatorio(TipoRelatorio.CONSUMO_PARTICIPANTE);
		assertEquals("Heron,[Carne]"+quebraLinha,relatorio.proximaLinha());
		assertEquals("",relatorio.proximaLinha());
	}
	
	@Test
	public void doisConsumos(){
		heron.contribuiu(categoriaBebida,15.0);
		heron.consumiu(categoriaBebida);
		RelatorioCusto relatorio = criaGrupoERelatorio(TipoRelatorio.CONSUMO_PARTICIPANTE);
		assertEquals("Heron,[Bebida, Carne]"+quebraLinha,relatorio.proximaLinha());
		assertEquals("",relatorio.proximaLinha());
	}
	
	@Test
	public void doisConsumidores(){
		kazuhiro.consumiu(categoriaCarne);
		RelatorioCusto relatorio = criaGrupoERelatorio(TipoRelatorio.CONSUMO_PARTICIPANTE,heron,kazuhiro);
		assertEquals("Heron,[Carne]"+quebraLinha,relatorio.proximaLinha());
		assertEquals("Kazuhiro,[Carne]"+quebraLinha,relatorio.proximaLinha());
	}
	
	@Test
	public void doisConsumidoresComDoiConsumos(){
		heron.consumiu(categoriaBebida);
		kazuhiro.consumiu(categoriaCarne,categoriaBebida);
		kazuhiro.contribuiu(categoriaBebida, 30.0);
		
		RelatorioCusto relatorio = criaGrupoERelatorio(TipoRelatorio.CONSUMO_PARTICIPANTE,heron,kazuhiro);
		assertEquals("Heron,[Bebida, Carne]"+quebraLinha,relatorio.proximaLinha());
		assertEquals("Kazuhiro,[Bebida, Carne]"+quebraLinha,relatorio.proximaLinha());
	}

}
