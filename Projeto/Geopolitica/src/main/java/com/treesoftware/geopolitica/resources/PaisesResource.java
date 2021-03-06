package com.treesoftware.geopolitica.resources;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.treesoftware.geopolitica.model.Paises;
import com.treesoftware.geopolitica.repository.PaisesRepository;

@RestController
@RequestMapping("/rest/paises")
public class PaisesResource {

	@Autowired
	private PaisesRepository repositorio;
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		List<Paises> lista = repositorio.findAll();
		
		return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
	}
	
	@PostMapping
	public ResponseEntity<Paises> cadastrarNovo(@RequestBody Paises pais, HttpServletResponse response) {
		Paises novo = repositorio.save(pais);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/consulta/isoAlpha3/{codigo}").buildAndExpand(novo.getIsoAlpha3()).toUri();
		
		response.setHeader("Locatin", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(novo);
	}
	
	@GetMapping("/consulta/isoAlpha3/{codigo}")
	public Paises consultaPorCodigo(@PathVariable String isoAlpha3) {
		return this.repositorio.findById(isoAlpha3).orElse(null);
	}
	
}
