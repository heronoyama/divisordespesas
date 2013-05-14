package br.com.heron.divisordespesas.relatorio.driver;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.grupo.Grupo;
import br.com.heron.divisordespesas.model.grupo.Participante;
import br.com.heron.divisordespesas.relatorio.FabricaRelatorio;
import br.com.heron.divisordespesas.relatorio.RelatorioCusto;
import br.com.heron.divisordespesas.relatorio.TipoRelatorio;

public class RelatorioDriverCSVTest {

	private DriverEscrita driver;
	private EscritorRelatorioCSV escritor;
	private String quebraLinha = System.getProperty("line.separator");
	
	@Before
	public void setUp() throws IOException{
		driver = Mockito.mock(DriverEscrita.class);
		escritor = novoEscritor();
	}

	@Test
	public void imprimeCabecalho() throws IOException {
		escritor.escreveCabecalho();
		verify(driver).escreve("Paritipante,Contribuicao,Divida,Valor Final,Valor Para Receber"+quebraLinha);
	}
	
	@Test
	public void imprimeUmaLinha() throws IOException {
		escritor.escreveLinha();
		verify(driver).escreve("Heron,R$300.00,R$0.00,R$100.00,R$200.00"+quebraLinha);
	}
	
	@Test
	public void imprimeAteOFim() throws IOException {
		escritor.escreveCorpo();
		verify(driver).escreve("Heron,R$300.00,R$0.00,R$100.00,R$200.00"+quebraLinha);
		verify(driver).escreve("Kazuhiro,R$0.00,R$100.00,R$100.00,R$0.00"+quebraLinha);
		verify(driver).escreve("Oyama,R$0.00,R$100.00,R$100.00,R$0.00"+quebraLinha);
	}
	
	@Test
	public void imprimeRelatorio() throws IOException{
		escritor.imprimeRelatorio();
		verify(driver).escreve("Heron,R$300.00,R$0.00,R$100.00,R$200.00"+quebraLinha);
		verify(driver).escreve("Heron,R$300.00,R$0.00,R$100.00,R$200.00"+quebraLinha);
		verify(driver).escreve("Kazuhiro,R$0.00,R$100.00,R$100.00,R$0.00"+quebraLinha);
		verify(driver).escreve("Oyama,R$0.00,R$100.00,R$100.00,R$0.00"+quebraLinha);
		verify(driver).close();
		
	}
	
	private EscritorRelatorioCSV novoEscritor() throws IOException {
		return new EscritorRelatorioCSV(criaRelatorio(),driver);
	}
	
	private RelatorioCusto criaRelatorio() {
		Participante heron = new Participante("Heron");
		Categoria categoriaCarne = new Categoria("Carne");
		Participante oyama = new Participante("Oyama");
		Participante kazuhiro = new Participante("Kazuhiro");
		Categoria categoriaBebida = new Categoria("Bebida");
		
		heron.consumiu(categoriaCarne, categoriaBebida);
		kazuhiro.consumiu(categoriaCarne, categoriaBebida);
		oyama.consumiu(categoriaCarne, categoriaBebida);
		
		heron.contribuiu(categoriaCarne, 150.00);
		heron.contribuiu(categoriaBebida, 150.00);
		Grupo grupo = new Grupo(asList(heron, kazuhiro, oyama));
		return FabricaRelatorio.getRelatorio(TipoRelatorio.FINAL, grupo);
	}
	
}
