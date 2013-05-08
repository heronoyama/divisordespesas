package br.com.heron.divisordespesas.consumos;

import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.List;

import br.com.heron.divisordespesas.configuracao.Categoria;
import br.com.heron.divisordespesas.grupo.Participante;

public class ConsumoParticipante {

	private Participante participante;
	private List<Categoria> categoriasConsumidas = new ArrayList<Categoria>();
	
	public ConsumoParticipante(Participante participante) {
		this.participante = participante;
	}
	
	@Override
	public String toString() {
		return participante.toString() + " : "+categorias().toString();
	}

	public void adiciona(Categoria... categorias) {
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

}
