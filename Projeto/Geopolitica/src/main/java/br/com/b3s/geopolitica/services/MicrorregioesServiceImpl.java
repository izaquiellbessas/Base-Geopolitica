package br.com.b3s.geopolitica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.b3s.geopolitica.model.Microrregioes;
import br.com.b3s.geopolitica.repository.MicrorregioesRepository;

@Service
public class MicrorregioesServiceImpl implements MicrorregioesService {

	@Autowired
	private MicrorregioesRepository repository;
	
	@Override
	public List<Microrregioes> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Optional<Microrregioes> findById(String id) {
		return repository.findById(id);
	}
	
}
