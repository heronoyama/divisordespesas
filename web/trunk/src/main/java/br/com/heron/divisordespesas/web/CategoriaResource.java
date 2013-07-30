package br.com.heron.divisordespesas.web;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import br.com.heron.divisordespesas.controller.CategoriaController;
import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.repositorio.CategoriaRepository;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioCategoriaMemoria;

import com.sun.jersey.spi.resource.Singleton;


@Singleton
@Path("/categorias")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class CategoriaResource {

	private CategoriaRepository repositorio = new RepositorioCategoriaMemoria();
	private CategoriaController controller = new CategoriaController(repositorio);
	
	@GET
	public List<Categoria> todas(){
		return controller.buscaTodos();
	}
	
	@POST
	public void salvaCategoria(JSONObject object) throws JSONException{
		controller.criaCategoria(object.getString("nome"));
	}
	
	@GET
	@Path("/id/{id}")
	public Categoria getCategoria(@PathParam("id") int id){
		controller.
	}
	
	
}