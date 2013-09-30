package br.com.heron.divisordespesas.model.consumos;

import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.List;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.evento.Participante;

public class ConsumoParticipante {

	private Integer id;
	private Participante participante;
	private List<Categoria> categoriasConsumidas = new ArrayList<Categoria>();
	
	public ConsumoParticipante(Participante participante) {
		setParticipante(participante);
	}

	private void setParticipante(Participante participante) {
		if(participante == null)
			throw new IllegalArgumentException("Consumo Participante deve ter um participante associado");
		
		this.participante = participante;
	}
	
	@Override
	public String toString() {
		return participante.toString() + " : "+categorias().toString();
	}
	
	public void adiciona(Categoria... categorias) {
		if(categorias == null)
			throw new IllegalArgumentException("Consumo Participante deve receber uma Categoria como consumo");

		for (Categoria categoria : categorias) {
			if(!consumiu(categoria))
				categorias().add(categoria);
		}
		sort(categoriasConsumidas);
	}

	public boolean consumiu(Categoria categoria) {
		return categorias().contains(categoria);
	}
	
	public List<Categoria> categorias() {
		return categoriasConsumidas;
	}

	public Participante getParticipante() {
		return participante;
	}

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id;}

}
