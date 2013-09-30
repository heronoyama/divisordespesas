package br.com.heron.divisordespesas.relatorio;

import static java.util.Arrays.asList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.heron.divisordespesas.model.evento.Evento;

public class RelatorioTest extends RelatorioCustoTest{
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void naoCriaRelatorioSemTipo(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Especifique um tipo de relatório.");
		FabricaRelatorio.getRelatorio(null, new Evento(asList(heron)));
	}
	
	@Test
	public void naoCriaRelatorioSemEvento(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Especifique um evento.");
		FabricaRelatorio.getRelatorio(TipoRelatorio.FINAL,null);
	}

}
