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

import com.treesoftware.geopolitica.model.Regioes;
import com.treesoftware.geopolitica.repository.RegioesRepository;

@RestController
@RequestMapping("/rest/regioes")
public class RegioesResource {

	@Autowired
	private RegioesRepository repositorio;
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		List<Regioes> lista = repositorio.findAll();
		
		return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
	}
	
	@PostMapping
	public ResponseEntity<Regioes> cadastrarNovo(@RequestBody Regioes regiao, HttpServletResponse response) {
		Regioes novo = repositorio.save(regiao);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/consulta/id/{codigo}").buildAndExpand(novo.getIdRegiao()).toUri();
		
		response.setHeader("Locatin", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(novo);
	}
	
	@GetMapping("/consulta/id/{codigo}")
	public Regioes consultaPorCodigo(@PathVariable Integer id) {
		return this.repositorio.findById(id).orElse(null);
	}
	
}
