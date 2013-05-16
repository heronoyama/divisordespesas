package br.com.heron.divisordespesas.relatorio;

import static java.util.Arrays.asList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.heron.divisordespesas.model.grupo.Grupo;

public class RelatorioTest extends RelatorioCustoTest{
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void naoCriaRelatorioSemTipo(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Especifique um tipo de relatório.");
		FabricaRelatorio.getRelatorio(null, new Grupo(asList(heron)));
	}
	
	@Test
	public void naoCriaRelatorioSemGrupo(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Especifique um grupo.");
		FabricaRelatorio.getRelatorio(TipoRelatorio.FINAL,null);
	}

}
