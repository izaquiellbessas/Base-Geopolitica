package br.com.b3s.geopolitica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.b3s.geopolitica.model.Regioes;
import br.com.b3s.geopolitica.repository.RegioesRepository;

@Service
public class RegioesServiceImpl implements RegioesService {

	@Autowired
	private RegioesRepository repository;
	
	@Override
	public List<Regioes> findAll() {
		return repository.findAll();
	}

}
