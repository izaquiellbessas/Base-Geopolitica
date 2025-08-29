package br.com.b3s.geopolitica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.b3s.geopolitica.model.Mesorregioes;
import br.com.b3s.geopolitica.repository.MesorregioesRepository;

@Service
public class MesorregioesServiceImpl implements MesorregioesService {

	@Autowired
	private MesorregioesRepository repository;
	
	@Override
	public List<Mesorregioes> findAll() {
		return repository.findAll();
	}

}
