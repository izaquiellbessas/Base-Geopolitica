package br.com.b3s.geopolitica.services;

import java.util.List;

import br.com.b3s.geopolitica.model.Paises;

public interface PaisesService {

	public void save(Paises pais);
	public void edit(Paises pais);
	public void remove(Paises pais);
	public List<Paises> findAll();
	
}
