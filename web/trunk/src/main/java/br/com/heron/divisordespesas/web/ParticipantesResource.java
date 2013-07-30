package br.com.heron.divisordespesas.web;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.heron.divisordespesas.controller.ParticipanteController;
import br.com.heron.divisordespesas.model.grupo.Participante;
import br.com.heron.divisordespesas.repositorio.ParticipanteRepository;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioParticipanteMemoria;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/participantes")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ParticipantesResource {

	private ParticipanteRepository repositorio = new RepositorioParticipanteMemoria();
	private ParticipanteController controller = new ParticipanteController(repositorio);
	
	@GET
	public List<Participante> todas(){
		return controller.buscaTodos();
	}

}
