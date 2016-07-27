package br.com.heron.divisordespesas.model;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EntidadeTest {

	private static class EntidadeFake extends Entidade{
		private String atributoString = "Helloworld";
		private int primitivoInteiro = 2;
		private Integer objetoManoloInteiro = 3;
		
		public void setString(String string) { atributoString = string; }
		public void setInt(int i) { primitivoInteiro = i;}
		public void setInteger(int i) {objetoManoloInteiro = i;	}
		
	}
	
	@Test
	public void testModeloInicial() throws Exception{
		EntidadeFake fake = new EntidadeFake();
		List<Atributo> atributos = fake.getDeclaracaoParaPersistecia();
		Assert.assertEquals("atributoString [String]: Helloworld", atributos.get(0).toString());
		Assert.assertEquals("objetoManoloInteiro [Integer]: 3", atributos.get(1).toString());
		Assert.assertEquals("primitivoInteiro [int]: 2", atributos.get(2).toString());

	}
	
	@Test
	public void testModeloModificado() throws Exception{
		EntidadeFake fake = new EntidadeFake();
		fake.setString("Teste");
		fake.setInt(3);
		fake.setInteger(4);
		
		List<Atributo> atributos = fake.getDeclaracaoParaPersistecia();
		Assert.assertEquals("atributoString [String]: Teste", atributos.get(0).toString());
		Assert.assertEquals("objetoManoloInteiro [Integer]: 4", atributos.get(1).toString());
		Assert.assertEquals("primitivoInteiro [int]: 3", atributos.get(2).toString());

	}

}
