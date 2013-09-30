package br.com.heron.divisordespesas.modelconsumos;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.consumos.ConsumoParticipante;
import br.com.heron.divisordespesas.model.evento.Participante;

public class ConsumoParticipanteTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private Participante participante = new Participante("Heron");
	
	@Test
	public void inicializaListaParticipante(){
		assertEquals("Heron : []",participante.consumo().toString());
	}
	
	@Test
	public void adicionaConsumo(){
		ConsumoParticipante consumo = criaConsumoParticipante();
		consumo.adiciona(new Categoria("Carne"));
		assertEquals("Heron : [Carne]", consumo.toString());
	}
	
	@Test
	public void adicionaDiversosConsumos(){
		ConsumoParticipante consumo = criaConsumoParticipante();
		Categoria categoriaCarne = new Categoria("Carne");
		consumo.adiciona(categoriaCarne);
		consumo.adiciona(new Categoria("Bebida"));
		consumo.adiciona(categoriaCarne);
		assertEquals("Heron : [Bebida, Carne]", consumo.toString());
	}
	
	@Test
	public void naoCriaConsumoParticipanteSemParticipante(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Consumo Participante deve ter um participante associado");
		new ConsumoParticipante(null);
	}
	
	@Test
	public void naoConsomeCategoriaNula(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Consumo Participante deve receber uma Categoria como consumo");
		criaConsumoParticipante().adiciona((Categoria[])null);
	}
	
	private ConsumoParticipante criaConsumoParticipante() {
		return new ConsumoParticipante(participante);
	}

}
