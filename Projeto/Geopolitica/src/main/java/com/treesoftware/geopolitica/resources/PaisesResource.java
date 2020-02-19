package com.treesoftware.geopolitica.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treesoftware.geopolitica.model.Paises;
import com.treesoftware.geopolitica.repository.PaisesRepository;

@RestController
@RequestMapping("/rest/paises")
public class PaisesResource {

	@Autowired
	private PaisesRepository repositorio;
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		List<Paises> listaPaises = repositorio.findAll();
		
		return listaPaises.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(listaPaises);
	}
	
	
}
