package br.com.heron.divisordespesas.controller;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import br.com.heron.divisordespesas.model.configuracao.Categoria;
import br.com.heron.divisordespesas.repositorio.CategoriaRepository;
import br.com.heron.divisordespesas.repositorio.memoria.RepositorioCategoriaMemoria;

public class CategoriaControllerTest {

	private CategoriaRepository repositorio = new RepositorioCategoriaMemoria();
	private CategoriaController categoriaController;
	
	@Before
	public void setUp(){
		categoriaController = new CategoriaController(repositorio);
	}
	
	@Test
	public void criaCategoria() {
		Categoria categoria = categoriaController.criaCategoria("Carne");
		assertEquals("Carne",categoria.toString());
	}
	
	@Test
	public void buscaCategoria(){
		Categoria categoria = categoriaController.criaCategoria("Carne");
		
		Categoria pesquisada = categoriaController.busca("Carne");
		assertSame(categoria, pesquisada);
		assertEquals("Carne",pesquisada.toString());
	}
	
	@Test
	public void buscaCategoriaNaoCadastrada(){
		assertNull(categoriaController.busca("Carne"));
	}
	
	@Test
	public void buscaTodasCategorias(){
		categoriaController.criaCategoria("Carne");
		categoriaController.criaCategoria("Bebida");
		categoriaController.criaCategoria("Grade");
		
		assertEquals("[Bebida, Carne, Grade]",categoriaController.buscaTodos().toString());
	}
}