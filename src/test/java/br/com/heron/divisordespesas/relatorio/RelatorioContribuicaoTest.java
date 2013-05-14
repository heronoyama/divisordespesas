package br.com.heron.divisordespesas.relatorio;

import static br.com.heron.divisordespesas.relatorio.TipoRelatorio.CONTRIBUICAO;
import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.grupo.Participante;

public class RelatorioContribuicaoTest extends RelatorioCustoTest {

	public RelatorioContribuicaoTest() {
		heron.contribuiu(categoriaCarne, 81.6);
	}
	
	@Test
	public void imprimeHeader(){
		RelatorioCusto relatorio = criaGrupoERelatorio(CONTRIBUICAO);
		assertEquals("Participante,Valor Contribuido"+quebraLinha,relatorio.cabecalho());
	}
	
	@Test
	public void imprimeUmaContribuicao() {
		RelatorioCusto relatorio = criaGrupoERelatorio(CONTRIBUICAO);
		assertEquals("Heron,R$81.60"+quebraLinha,relatorio.proximaLinha());
	}
	
	@Test
	public void imprimeTodasContribuicoes() {
		RelatorioCusto relatorio = criaGrupoERelatorio(CONTRIBUICAO);
		assertEquals("Heron,R$81.60"+quebraLinha,relatorio.proximaLinha());
		assertEquals("",relatorio.proximaLinha());
	}
	
	@Test
	public void imprimeDuasContribuicoes(){
		heron.contribuiu(new Categoria("Bebida"), 8.40);
		RelatorioCusto relatorio = criaGrupoERelatorio(CONTRIBUICAO);
		assertEquals("Heron,R$90.00"+quebraLinha,relatorio.proximaLinha());
		assertEquals("",relatorio.proximaLinha());
	}
	
	@Test
	public void imprimeContribuicaoDeDoisParticipantes(){
		heron.contribuiu(new Categoria("Bebida"), 8.40);
		
		Participante oyama = new Participante("Oyama");
		oyama.contribuiu(categoriaCarne,15.0);
		RelatorioCusto relatorio = criaGrupoERelatorio(CONTRIBUICAO,heron,oyama);
		assertEquals("Heron,R$90.00"+quebraLinha,relatorio.proximaLinha());
		assertEquals("Oyama,R$15.00"+quebraLinha,relatorio.proximaLinha());
		assertEquals("",relatorio.proximaLinha());
	}

}
