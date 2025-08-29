package br.com.b3s.geopolitica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.b3s.geopolitica.model.Estados;

@Repository
public interface EstadosRepository extends JpaRepository<Estados, String> {

}
