package br.com.heron.divisordespesas;

import java.util.Arrays;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.model.evento.Participante;

public class AmbienteReal {
	
	public Participante heron;
	public Participante joao;
	public Participante danilo;
	public Participante rafael;
	public Participante paola;
	public Evento evento;
	public Categoria carne;
	public Categoria cerveja;
	public Categoria aluguel;
	public Categoria multa;
	
	public AmbienteReal(){
		heron = new Participante("Heron");
		joao = new Participante("Joao");
		danilo = new Participante("Danilo");
		rafael = new Participante("Rafael");
		paola = new Participante("Paola");
		
		evento = new Evento(Arrays.asList(heron,joao,danilo,rafael,paola));
		
		contribuintesDeCarne();
		contribuintesDeCerveja();
		contribuintesDeAluguel();
		
		consumidores();
		
	}

	private void consumidores() {
		heron.consumiu(carne, cerveja, aluguel, multa);
		
		joao.consumiu(carne, cerveja, multa, aluguel);
		
		rafael.consumiu(carne, cerveja, aluguel, multa);
		
		danilo.consumiu(carne, cerveja, aluguel, multa);
		
		paola.consumiu(carne, aluguel, multa);
	}

	private void contribuintesDeAluguel() {
		aluguel = new Categoria("Aluguel");
		multa = new Categoria("Multa");

		rafael.contribuiu(aluguel, 40.50);
		rafael.contribuiu(multa, 21.5);
	}

	private void contribuintesDeCerveja() {
		cerveja = new Categoria("Cerveja");
		heron.contribuiu(cerveja, 50.0);
		joao.contribuiu(cerveja, 35.0);
	}

	private void contribuintesDeCarne() {
		carne = new Categoria("Carne");
		heron.contribuiu(carne, 30.0);
		danilo.contribuiu(carne, 50.0);
		
	}

}
