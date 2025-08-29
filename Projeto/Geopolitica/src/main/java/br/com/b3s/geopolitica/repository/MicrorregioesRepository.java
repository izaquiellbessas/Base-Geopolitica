package br.com.b3s.geopolitica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.b3s.geopolitica.model.Microrregioes;

@Repository
public interface MicrorregioesRepository extends JpaRepository<Microrregioes, String> {

}
