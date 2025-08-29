package br.com.b3s.geopolitica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.b3s.geopolitica.model.Paises;
import br.com.b3s.geopolitica.repository.PaisesRepository;

@Service
public class PaisesServiceImpl implements PaisesService {

	@Autowired
	private PaisesRepository repository;
	
	@Override
	public void save(Paises pais) {
		repository.save(pais);
	}

	@Override
	public void edit(Paises pais) {
		repository.save(pais);
	}

	@Override
	public void remove(Paises pais) {
		repository.delete(pais);
	}

	@Override
	public List<Paises> findAll() {
		return repository.findAll();
	}

}
