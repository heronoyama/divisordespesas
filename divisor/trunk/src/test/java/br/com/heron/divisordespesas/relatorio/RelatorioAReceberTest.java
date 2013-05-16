package br.com.heron.divisordespesas.relatorio;

import static br.com.heron.divisordespesas.relatorio.TipoRelatorio.ARECEBER;
import junit.framework.Assert;

import org.junit.Test;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.grupo.Participante;

public class RelatorioAReceberTest extends RelatorioCustoTest{

	private Participante oyama = new Participante("Oyama");

	@Test
	public void imprimeCabecalho() {
		RelatorioCusto relatorio = criaGrupoERelatorio(ARECEBER);
		Assert.assertEquals("Participante,A Receber"+quebraLinha, relatorio.cabecalho());
	}
	
	@Test
	public void umaPessoaAReceber(){

		heron.contribuiu(categoriaCarne, 100.0);
		heron.consumiu(categoriaCarne);
		oyama.consumiu(categoriaCarne);
		
		RelatorioCusto relatorio = criaGrupoERelatorio(ARECEBER,heron,oyama);
		Assert.assertEquals("Heron,R$50.00"+quebraLinha, relatorio.proximaLinha());
		Assert.assertEquals("Oyama,R$0.00"+quebraLinha, relatorio.proximaLinha());
	}
	
	@Test
	public void imprimeAteOFim(){
		
		heron.contribuiu(categoriaCarne, 100.0);
		heron.consumiu(categoriaCarne);
		oyama.consumiu(categoriaCarne);
		
		RelatorioCusto relatorio = criaGrupoERelatorio(ARECEBER,heron,oyama);
		Assert.assertEquals("Heron,R$50.00"+quebraLinha, relatorio.proximaLinha());
		Assert.assertEquals("Oyama,R$0.00"+quebraLinha, relatorio.proximaLinha());
		Assert.assertEquals("", relatorio.proximaLinha());
	}
	
	@Test
	public void duasPessoasRecebendo(){
		Participante kazuhiro = new Participante("Kazuhiro");
		
		Categoria categoriaBebida = new Categoria("Bebida");
		heron.contribuiu(categoriaCarne, 30.00);
		oyama.contribuiu(categoriaBebida, 30.00);
		
		heron.consumiu(categoriaCarne,categoriaBebida);
		oyama.consumiu(categoriaCarne,categoriaBebida);
		kazuhiro.consumiu(categoriaCarne,categoriaBebida);
		
		RelatorioCusto relatorio = criaGrupoERelatorio(ARECEBER,heron,oyama,kazuhiro);
		Assert.assertEquals("Heron,R$10.00"+quebraLinha, relatorio.proximaLinha());
		Assert.assertEquals("Kazuhiro,R$0.00"+quebraLinha, relatorio.proximaLinha());
		Assert.assertEquals("Oyama,R$10.00"+quebraLinha, relatorio.proximaLinha());
		Assert.assertEquals("", relatorio.proximaLinha());
		
	}

}
