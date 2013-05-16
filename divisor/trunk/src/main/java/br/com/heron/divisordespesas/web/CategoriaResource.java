package br.com.heron.divisordespesas.web;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.heron.divisordespesas.controller.CategoriaController;
import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioCategoriaMemoria;


@Path("/categorias")
public class CategoriaResource {
	
	@GET
	@Path("/all")
	@Produces(APPLICATION_JSON)
	public List<Categoria> todas(){
		
		CategoriaController controller = new CategoriaController(new RepositorioCategoriaMemoria());
		controller.criaCategoria("Carne");
		controller.criaCategoria("Bebida");
		return controller.buscaTodos();
	}

}