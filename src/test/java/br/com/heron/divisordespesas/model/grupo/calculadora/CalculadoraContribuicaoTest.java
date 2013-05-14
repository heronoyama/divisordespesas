package br.com.heron.divisordespesas.model.grupo.calculadora;
import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.grupo.Grupo;
import br.com.heron.divisordespesas.model.grupo.Participante;


public class CalculadoraContribuicaoTest {
	
	private Participante participante = new Participante("Heron");
	
	@Test
	public void adicionaGasto(){
		Grupo grupo = criaGrupo(asList(participante));
		participante.contribuiu(criaCategoria("Carne"), 50.0);
		assertEquals(50.0,grupo.contribuicaoTotal());
	}
	
	@Test
	public void adicionaMaisGastos(){
		Grupo grupo = criaGrupo(asList(participante));
		participante.contribuiu(criaCategoria("Carne"),50.0);
		participante.contribuiu(criaCategoria("Bebida"), 20.0);
		assertEquals(70.0, grupo.contribuicaoTotal());
	}
	
	@Test
	public void gastoTotalComDiversosParticipantesPagando(){
		Participante participante2 = criaSegundoParticipante();
		Grupo grupo = criaGrupo(asList(participante,participante2));
		participante.contribuiu(criaCategoria("Carne"),50.0);
		participante2.contribuiu(criaCategoria("Bebida"),20.0);
		
		assertEquals(70.0, grupo.contribuicaoTotal());
	}
	
	@Test
	public void gastoPorCategoriaNoGrupo(){
		Participante participante2 = criaSegundoParticipante();
		Grupo grupo = criaGrupo(asList(participante,participante2));
		Categoria categoriaCarne = new Categoria("Carne");
		Categoria categoriaBebida = new Categoria("Bebida");
		
		participante.contribuiu(categoriaCarne, 60.0);
		participante2.contribuiu(categoriaCarne, 40.0);
		participante.contribuiu(categoriaBebida, 20.0);
		participante2.contribuiu(categoriaBebida,20.0);
		
		assertEquals(100.0,grupo.contribuicao(categoriaCarne));
		assertEquals(40.0,grupo.contribuicao(categoriaBebida));
		assertEquals(140.0,grupo.contribuicaoTotal());
	}
	
	@Test
	public void valorContribuidoPorCategoriaPorParticipante(){
		Participante participante2 = criaSegundoParticipante();
		Grupo grupo = criaGrupo(asList(participante,participante2));
		Categoria categoriaCarne = new Categoria("Carne");
		Categoria categoriaBebida = new Categoria("Bebida");
		
		participante.contribuiu(categoriaCarne, 60.0);
		participante.contribuiu(categoriaCarne, 70.0);
		participante2.contribuiu(categoriaCarne, 40.0);

		participante.contribuiu(categoriaBebida, 20.0);
		participante2.contribuiu(categoriaBebida,20.0);
		
		assertEquals(210.0,grupo.contribuicaoTotal());
		
		assertEquals(130.0,participante.valorContribuido(categoriaCarne));
		assertEquals(40.0,participante2.valorContribuido(categoriaCarne));
		assertEquals(20.0,participante.valorContribuido(categoriaBebida));
		assertEquals(20.0,participante2.valorContribuido(categoriaBebida));
	}

		
	@Test
	public void gastoPorCategoriaPagandoMaisDeUmaVez(){
		Grupo grupo = criaGrupo(asList(participante));
		Categoria categoria = criaCategoria("Carne");
		participante.contribuiu(categoria, 50.0);
		participante.contribuiu(criaCategoria("Bebida"),20.0);
		participante.contribuiu(categoria, 70.0);
		assertEquals(140.0,grupo.contribuicaoTotal());
		assertEquals(120.0,grupo.contribuicao(categoria));
	}

	private Grupo criaGrupo(List<Participante> participantes) {
		return new Grupo(participantes);
	}
	
	private Participante criaSegundoParticipante() {
		return new Participante("Oyama");
	}
	
	private Categoria criaCategoria(String nomeCategoria) {
		return new Categoria(nomeCategoria);
	}
	
}
