package br.com.heron.divisordespesas.web;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.heron.divisordespesas.controller.EventoController;
import br.com.heron.divisordespesas.model.evento.Evento;
import br.com.heron.divisordespesas.repositorio.EventoRepository;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioEventoMemoria;
import br.com.heron.divisordespesas.web.dao.EventoHeadDTO;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/eventos")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class EventoResource {

	private EventoRepository repositorio = new RepositorioEventoMemoria();
	private EventoController controller = new EventoController(repositorio);
	
	@GET
	public List<Evento> todos(){
		return controller.todos();
	}
	
	@POST
	public Evento criarEventoBase(EventoHeadDTO evento) {
		Evento eventoCriado = controller.criaEvento(evento.nome);
		return eventoCriado;
	}
	
	
}
