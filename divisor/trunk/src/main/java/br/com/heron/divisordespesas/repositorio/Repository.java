package br.com.heron.divisordespesas.repositorio;

import java.util.List;

public interface Repository<T> {

	public void save(T objeto);
	public T find(Integer id);
	public List<T> findAll();
	public void clear();
	
}
