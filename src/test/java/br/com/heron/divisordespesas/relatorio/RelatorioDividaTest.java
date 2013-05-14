package br.com.heron.divisordespesas.relatorio;

import static br.com.heron.divisordespesas.relatorio.TipoRelatorio.DIVIDA;
import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import br.com.heron.divisordespesas.model.grupo.Participante;

public class RelatorioDividaTest extends RelatorioCustoTest{

	@Test
	public void imprimeCabecalho(){
		RelatorioCusto relatorio = criaGrupoERelatorio(DIVIDA);
		assertEquals("Participante,Divida"+quebraLinha, relatorio.cabecalho());
	}
	
	@Test
	public void umaPessoaSemDivida() {
		heron.consumiu(categoriaCarne);

		RelatorioCusto relatorio = criaGrupoERelatorio(DIVIDA);
		assertEquals("Heron,R$0.00" + quebraLinha, relatorio.proximaLinha());
	}

	@Test
	public void umaPessoaComContribuicaoSemDivida() {
		heron.consumiu(categoriaCarne);
		heron.contribuiu(categoriaCarne, 500.90);

		RelatorioCusto relatorio = criaGrupoERelatorio(DIVIDA);
		assertEquals("Heron,R$0.00" + quebraLinha, relatorio.proximaLinha());
	}

	@Test
	public void umaPessoaComDivida() {
		Participante oyama = new Participante("Oyama");
		heron.consumiu(categoriaCarne);
		oyama.consumiu(categoriaCarne);
		heron.contribuiu(categoriaCarne, 800.00);

		RelatorioCusto relatorio = criaGrupoERelatorio(DIVIDA,heron, oyama);
		assertEquals("Heron,R$0.00" + quebraLinha, relatorio.proximaLinha());
		assertEquals("Oyama,R$400.00" + quebraLinha, relatorio.proximaLinha());
	}

	@Test
	public void duasPessoasComDivida() {
		Participante oyama = new Participante("Oyama");
		Participante kazuhiro = new Participante("Kazuhiro");

		oyama.consumiu(categoriaCarne);
		kazuhiro.consumiu(categoriaCarne);

		heron.contribuiu(categoriaCarne, 100.00);

		RelatorioCusto relatorio = criaGrupoERelatorio(DIVIDA,heron, kazuhiro, oyama);
		assertEquals("Heron,R$0.00" + quebraLinha, relatorio.proximaLinha());
		assertEquals("Kazuhiro,R$50.00" + quebraLinha, relatorio.proximaLinha());
		assertEquals("Oyama,R$50.00" + quebraLinha, relatorio.proximaLinha());
	}

	@Test
	public void imprimeAteOFim() {
		heron.consumiu(categoriaCarne);

		RelatorioCusto relatorio = criaGrupoERelatorio(DIVIDA);
		assertEquals("Heron,R$0.00" + quebraLinha, relatorio.proximaLinha());
		assertEquals("",relatorio.proximaLinha());
	}

}