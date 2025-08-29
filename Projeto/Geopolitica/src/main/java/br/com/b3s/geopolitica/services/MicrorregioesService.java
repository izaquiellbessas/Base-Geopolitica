package br.com.b3s.geopolitica.services;

import java.util.List;
import java.util.Optional;

import br.com.b3s.geopolitica.model.Microrregioes;

public interface MicrorregioesService {

	public List<Microrregioes> findAll();
	
	public Optional<Microrregioes> findById(String id);
	
}
