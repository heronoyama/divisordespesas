package br.com.heron.divisordespesas.model.grupo.calculadora;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.grupo.Grupo;
import br.com.heron.divisordespesas.model.grupo.Participante;

public class CalculadoraGastosTest {

	private Participante participante = new Participante("Heron");
	private Participante participante2 = new Participante("Oyama");
	private Grupo grupo = new Grupo(Arrays.asList(participante,participante2));
	private Categoria categoriaCarne = new Categoria("Carne");
	private Categoria categoriaBebida = new Categoria("Bebida");
	
	@Before
	public void setup(){
		participante.contribuiu(categoriaCarne, 60.0);
		participante2.contribuiu(categoriaCarne, 40.0);
	}
	
	@Test
	public void valorContribuidoPorPessoa(){
		participante.contribuiu(categoriaBebida,30.0);
		participante2.contribuiu(categoriaBebida, 30.0);
		
		assertEquals(90.0,participante.valorContribuido());
		assertEquals(70.0,participante2.valorContribuido());
		
	}
	
	@Test
	public void consumidoresPorCategoria(){
		participante.consumiu(categoriaCarne);
		participante.consumiu(categoriaBebida);
		
		participante2.consumiu(categoriaCarne);
		
		assertEquals("[Heron, Oyama]",grupo.consumidores(categoriaCarne).toString());
		assertEquals("[Heron]",grupo.consumidores(categoriaBebida).toString());
		
	}
	
	@Test
	public void valorCobradoPorCategoria(){
		participante.contribuiu(categoriaBebida,30.0);
		participante2.contribuiu(categoriaBebida, 30.0);
		
		participante.consumiu(categoriaCarne);
		participante.consumiu(categoriaBebida);
		
		participante2.consumiu(categoriaCarne);
		
		assertEquals(100.0,grupo.contribuicao(categoriaCarne));
		assertEquals(60.0,grupo.contribuicao(categoriaBebida));
		assertEquals(160.0,grupo.contribuicaoTotal());
		
		double valorCarnePorConsumidor = grupo.valorFinal(categoriaCarne);
		double valorBebidaPorConsumidor = grupo.valorFinal(categoriaBebida);
		
		assertEquals(50.0,valorCarnePorConsumidor);
		assertEquals(60.0,valorBebidaPorConsumidor);
	}
	
	@Test
	public void valorCobradoPorPessoa(){
		participante.contribuiu(categoriaBebida,30.0);
		participante2.contribuiu(categoriaBebida, 30.0);
		
		participante.consumiu(categoriaCarne);
		participante.consumiu(categoriaBebida);
		
		participante2.consumiu(categoriaCarne);
		
		assertEquals(110.0, grupo.valorFinal(participante));
		assertEquals(50.0,grupo.valorFinal(participante2));
		assertEquals(grupo.contribuicaoTotal(), ( grupo.valorFinal(participante)+ grupo.valorFinal(participante2)));
	}
	
	@Test
	public void valorParaReceberPorPessoa(){
		participante.contribuiu(categoriaBebida,30.0);
		participante2.contribuiu(categoriaBebida, 30.0);
		
		participante.consumiu(categoriaCarne);
		participante.consumiu(categoriaBebida);
		
		participante2.consumiu(categoriaCarne);
		
		assertEquals(50.0,grupo.valorFinal(categoriaCarne));
		assertEquals(60.0,grupo.valorFinal(categoriaBebida));
		
		assertEquals(110.0, grupo.valorFinal(participante));
		assertEquals(50.0,grupo.valorFinal(participante2));

		assertEquals(90.0,participante.valorContribuido());
		assertEquals(70.0,participante2.valorContribuido());
		
		assertEquals(0.0,grupo.valorParaReceber(participante));
		assertEquals(20.0,grupo.valorParaReceber(participante2));
	}
	
	@Test
	public void valorParaPagarPorPessoa(){
		participante.contribuiu(categoriaBebida,30.0);
		participante2.contribuiu(categoriaBebida, 30.0);
		
		participante.consumiu(categoriaCarne);
		participante.consumiu(categoriaBebida);
		
		participante2.consumiu(categoriaCarne);
		
		assertEquals(50.0,grupo.valorFinal(categoriaCarne));
		assertEquals(60.0,grupo.valorFinal(categoriaBebida));
		
		assertEquals(110.0, grupo.valorFinal(participante));
		assertEquals(50.0,grupo.valorFinal(participante2));

		assertEquals(90.0,participante.valorContribuido());
		assertEquals(70.0,participante2.valorContribuido());
		
		assertEquals(20.0,grupo.valorParaPagar(participante));
		assertEquals(0.0,grupo.valorParaPagar(participante2));
	}
	
}
