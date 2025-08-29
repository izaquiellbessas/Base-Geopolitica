package br.com.b3s.geopolitica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.b3s.geopolitica.model.Paises;

@Repository
public interface PaisesRepository extends JpaRepository<Paises, String> {

}
