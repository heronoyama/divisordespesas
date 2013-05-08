package br.com.heron.divisordespesas.consumos;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.heron.divisordespesas.configuracao.Categoria;
import br.com.heron.divisordespesas.grupo.Participante;

public class ConsumoParticipanteTest {

	private Participante participante = new Participante("Heron");
	
	@Test
	public void inicializaListaParticipante(){
		assertEquals("Heron : []",participante.consumo().toString());
	}
	
	@Test
	public void adicionaConsumo(){
		ConsumoParticipante consumo = new ConsumoParticipante(participante);
		consumo.adiciona(new Categoria("Carne"));
		assertEquals("Heron : [Carne]", consumo.toString());
	}
	
	@Test
	public void adicionaDiversosConsumos(){
		ConsumoParticipante consumo = new ConsumoParticipante(participante);
		Categoria categoriaCarne = new Categoria("Carne");
		consumo.adiciona(categoriaCarne);
		consumo.adiciona(new Categoria("Bebida"));
		consumo.adiciona(categoriaCarne);
		assertEquals("Heron : [Bebida, Carne]", consumo.toString());
	}

}
