package br.com.heron.divisordespesas.model.evento.calculadora;

import static java.util.Arrays.asList;
import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.consumos.ConsumoParticipante;
import br.com.heron.divisordespesas.model.evento.Participante;

class CalculadoraGastos {

	private List<ConsumoParticipante> consumos = new ArrayList<ConsumoParticipante>();
	
	public CalculadoraGastos(List<Participante> participantes){
		for (Participante participante : participantes) {
			consumos.add(participante.consumo());			
		}
	}

	public List<Categoria> consumos() {
		Set<Categoria> categoriasConsumidas = new HashSet<Categoria>();
		
		for (ConsumoParticipante consumo : consumos) {
			categoriasConsumidas.addAll(consumo.categorias());
		}
		
		List<Categoria> todasCategorias = asList(categoriasConsumidas.toArray(new Categoria[0]));
		sort(todasCategorias);
		return todasCategorias;
	}

	public List<Participante> consumidores(Categoria categoria) {
		List<Participante> consumidores = new ArrayList<Participante>();
		for (ConsumoParticipante consumo : consumos) {
			if(consumo.consumiu(categoria))
				consumidores.add(consumo.getParticipante());
		}
		sort(consumidores);
		return consumidores;
	}
	
}
