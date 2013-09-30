package br.com.heron.divisordespesas.model.evento.calculadora;
import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.model.evento.Participante;


public class CalculadoraContribuicaoTest {
	
	private Participante participante = new Participante("Heron");
	
	@Test
	public void adicionaGasto(){
		Evento evento = criaEvento(asList(participante));
		participante.contribuiu(criaCategoria("Carne"), 50.0);
		assertEquals(50.0,evento.contribuicaoTotal());
	}
	
	@Test
	public void adicionaMaisGastos(){
		Evento evento = criaEvento(asList(participante));
		participante.contribuiu(criaCategoria("Carne"),50.0);
		participante.contribuiu(criaCategoria("Bebida"), 20.0);
		assertEquals(70.0, evento.contribuicaoTotal());
	}
	
	@Test
	public void gastoTotalComDiversosParticipantesPagando(){
		Participante participante2 = criaSegundoParticipante();
		Evento evento = criaEvento(asList(participante,participante2));
		participante.contribuiu(criaCategoria("Carne"),50.0);
		participante2.contribuiu(criaCategoria("Bebida"),20.0);
		
		assertEquals(70.0, evento.contribuicaoTotal());
	}
	
	@Test
	public void gastoPorCategoriaNoEvento(){
		Participante participante2 = criaSegundoParticipante();
		Evento evento = criaEvento(asList(participante,participante2));
		Categoria categoriaCarne = new Categoria("Carne");
		Categoria categoriaBebida = new Categoria("Bebida");
		
		participante.contribuiu(categoriaCarne, 60.0);
		participante2.contribuiu(categoriaCarne, 40.0);
		participante.contribuiu(categoriaBebida, 20.0);
		participante2.contribuiu(categoriaBebida,20.0);
		
		assertEquals(100.0,evento.contribuicao(categoriaCarne));
		assertEquals(40.0,evento.contribuicao(categoriaBebida));
		assertEquals(140.0,evento.contribuicaoTotal());
	}
	
	@Test
	public void valorContribuidoPorCategoriaPorParticipante(){
		Participante participante2 = criaSegundoParticipante();
		Evento evento = criaEvento(asList(participante,participante2));
		Categoria categoriaCarne = new Categoria("Carne");
		Categoria categoriaBebida = new Categoria("Bebida");
		
		participante.contribuiu(categoriaCarne, 60.0);
		participante.contribuiu(categoriaCarne, 70.0);
		participante2.contribuiu(categoriaCarne, 40.0);

		participante.contribuiu(categoriaBebida, 20.0);
		participante2.contribuiu(categoriaBebida,20.0);
		
		assertEquals(210.0,evento.contribuicaoTotal());
		
		assertEquals(130.0,participante.valorContribuido(categoriaCarne));
		assertEquals(40.0,participante2.valorContribuido(categoriaCarne));
		assertEquals(20.0,participante.valorContribuido(categoriaBebida));
		assertEquals(20.0,participante2.valorContribuido(categoriaBebida));
	}

		
	@Test
	public void gastoPorCategoriaPagandoMaisDeUmaVez(){
		Evento evento = criaEvento(asList(participante));
		Categoria categoria = criaCategoria("Carne");
		participante.contribuiu(categoria, 50.0);
		participante.contribuiu(criaCategoria("Bebida"),20.0);
		participante.contribuiu(categoria, 70.0);
		assertEquals(140.0,evento.contribuicaoTotal());
		assertEquals(120.0,evento.contribuicao(categoria));
	}

	private Evento criaEvento(List<Participante> participantes) {
		return new Evento(participantes);
	}
	
	private Participante criaSegundoParticipante() {
		return new Participante("Oyama");
	}
	
	private Categoria criaCategoria(String nomeCategoria) {
		return new Categoria(nomeCategoria);
	}
	
}
