package br.com.heron.divisordespesas;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class CenarioRealTest {

	private AmbienteReal ambiente = new AmbienteReal();

	@Test
	public void gastoTotal(){
		assertEquals(227.0,ambiente.evento.contribuicaoTotal());
	}
	
	@Test
	public void gastoPorCategoria(){
		assertEquals(80.0, ambiente.evento.contribuicao(ambiente.carne));
		assertEquals(85.0,ambiente.evento.contribuicao(ambiente.cerveja));
		assertEquals(40.5,ambiente.evento.contribuicao(ambiente.aluguel));
		assertEquals(21.50,ambiente.evento.contribuicao(ambiente.multa));
	}
	
	@Test
	public void divisaoPorCategoria(){
		assertEquals(16.0, ambiente.evento.valorFinal(ambiente.carne));
		assertEquals(21.25, ambiente.evento.valorFinal(ambiente.cerveja));
		assertEquals(8.1, ambiente.evento.valorFinal(ambiente.aluguel));
		assertEquals(4.3, ambiente.evento.valorFinal(ambiente.multa));
	}
	
	@Test
	public void valorFinalPorParticipante(){
		assertEquals(49.65, ambiente.evento.valorFinal(ambiente.heron));
		assertEquals(49.65, ambiente.evento.valorFinal(ambiente.joao));
		assertEquals(49.65, ambiente.evento.valorFinal(ambiente.rafael));
		assertEquals(49.65, ambiente.evento.valorFinal(ambiente.danilo));
		assertEquals(28.40, ambiente.evento.valorFinal(ambiente.paola));
	}
	
	@Test
	public void valorGastoPorParticipante(){
		assertEquals(80.0, ambiente.heron.valorContribuido());
		assertEquals(35.0, ambiente.joao.valorContribuido());
		assertEquals(62.0, ambiente.rafael.valorContribuido());
		assertEquals(50.0, ambiente.danilo.valorContribuido());
		assertEquals(0.0, ambiente.paola.valorContribuido());
	}
	
	@Test
	public void valorCadaParticipanteDevePagar(){
		assertEquals(0.0,ambiente.evento.valorParaPagar(ambiente.heron));
		assertEquals(14.65,ambiente.evento.valorParaPagar(ambiente.joao));
		assertEquals(0.0,ambiente.evento.valorParaPagar(ambiente.rafael));
		assertEquals(0.0,ambiente.evento.valorParaPagar(ambiente.danilo));
		assertEquals(28.4,ambiente.evento.valorParaPagar(ambiente.paola));
	}
	
	@Test
	public void valorCadaParticipanteDeveReceber(){
		assertEquals(30.35,ambiente.evento.valorParaReceber(ambiente.heron));
		assertEquals(0.0,ambiente.evento.valorParaReceber(ambiente.joao));
		assertEquals(12.35,ambiente.evento.valorParaReceber(ambiente.rafael));
		assertEquals(0.35,ambiente.evento.valorParaReceber(ambiente.danilo));
		assertEquals(0.0,ambiente.evento.valorParaReceber(ambiente.paola));
	}
	
}