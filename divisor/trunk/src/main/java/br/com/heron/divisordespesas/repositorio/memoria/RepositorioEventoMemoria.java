package br.com.heron.divisordespesas.repositorio.memoria;

import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.repositorio.EventoRepository;

public class RepositorioEventoMemoria extends RepositorioMemoria<Evento> implements EventoRepository {
	
	public void save(Evento evento){
		evento.setId(id);
		persiste(evento);
	}
	
}
