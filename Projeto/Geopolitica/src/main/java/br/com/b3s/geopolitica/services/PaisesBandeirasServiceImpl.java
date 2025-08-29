package br.com.b3s.geopolitica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.b3s.geopolitica.model.PaisesBandeiras;
import br.com.b3s.geopolitica.repository.PaisesBandeirasRepository;

@Service
public class PaisesBandeirasServiceImpl implements PaisesBandeirasService {

	@Autowired
	private PaisesBandeirasRepository repository;
	
	@Override
	public void save(PaisesBandeiras pb) {
		repository.save(pb);
	}

	@Override
	public void remove(PaisesBandeiras pb) {
		repository.delete(pb);
	}

	@Override
	public List<PaisesBandeiras> findAll() {
		return repository.findAll();
	}

	@Override
	public List<PaisesBandeiras> retornarTodasDoPais(String isoAlpha3) {
		return repository.retornarTodasDoPais(isoAlpha3);
	}

}
