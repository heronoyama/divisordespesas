package br.com.heron.divisordespesas.repositorio.memoria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioMemoria<T> {
	
	protected Integer id = 1;
	protected Map<Integer,T> valores = new HashMap<Integer,T>();
	
	protected void persiste(T grupo) {
		valores.put(id, grupo);
		id++;
	}
	
	public T find(Integer id){
		return valores.get(id);
	}
	
	public List<T> findAll() {
		return new ArrayList<T>(valores.values());
	}
	
	public void clear(){
		valores = new HashMap<Integer,T>();
	}
	
}