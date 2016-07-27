package br.com.heron.divisordespesas.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Entidade {
	
	public List<Atributo> getDeclaracaoParaPersistecia() {
		List<Atributo> atributos = new ArrayList<>();
		
		for (Field atributo : getClass().getDeclaredFields()) {
			String atributoDeclarado = atributo.getName();
			atributo.setAccessible(true);
			try {
				Object valor = atributo.get(this);
				atributos.add(new Atributo(atributoDeclarado, atributo.getType().getSimpleName(),valor.toString()));
				System.out.println(atributo.getType().getSimpleName());
			} catch (Exception e) {
				throw new RuntimeException("Deu ruim!" + e.getMessage());
			}
			atributo.setAccessible(false);
		}
		
		Collections.sort(atributos);
		return atributos;
	}

}
