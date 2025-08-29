package br.com.b3s.geopolitica.services;

import java.util.List;

import br.com.b3s.geopolitica.model.PaisesBandeiras;

public interface PaisesBandeirasService {

	public void save(PaisesBandeiras pb);
	public void remove(PaisesBandeiras pb);
	public List<PaisesBandeiras> findAll();
	public List<PaisesBandeiras> retornarTodasDoPais(String isoAlpha3);
	
}
