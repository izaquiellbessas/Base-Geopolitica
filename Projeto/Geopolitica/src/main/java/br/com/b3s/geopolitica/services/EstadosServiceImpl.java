package br.com.b3s.geopolitica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.b3s.geopolitica.model.Estados;
import br.com.b3s.geopolitica.repository.EstadosRepository;

@Service
public class EstadosServiceImpl implements EstadosService {

	@Autowired
	private EstadosRepository repository;
	
	@Override
	public List<Estados> findAll() {
		return repository.findAll();
	}
	
}
