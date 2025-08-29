package br.com.b3s.geopolitica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.b3s.geopolitica.model.PaisesBandeiras;

@Repository
public interface PaisesBandeirasRepository extends JpaRepository<PaisesBandeiras, Integer> {

	@Query(value = "SELECT * FROM geo_paises_bandeiras WHERE fk_pais_iso_alpha3 = :isoAlpha3 ORDER BY id_pais_bandeira", nativeQuery = true)
	List<PaisesBandeiras> retornarTodasDoPais(String isoAlpha3);
	
}
