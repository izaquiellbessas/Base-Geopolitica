package br.com.b3s.geopolitica.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "geo_estados")
public class Estados {

	@Id
	@Column(name = "id_estado")
	private String id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sigla_uf")
	private String sigla;
	
	@ManyToOne
	@JoinColumn(name = "fk_pais")
	private Paises pais;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_regiao")
	private Regioes regioes;
	
	public Estados() {
		this.pais = new Paises();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Paises getPais() {
		return pais;
	}

	public void setPais(Paises pais) {
		this.pais = pais;
	}

	public Regioes getRegioes() {
		return regioes;
	}

	public void setRegioes(Regioes regioes) {
		this.regioes = regioes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, pais, sigla);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estados other = (Estados) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(pais, other.pais)
				&& Objects.equals(sigla, other.sigla);
	}

	@Override
	public String toString() {
		return "Estados [Id=" + id + ", Estado=" + nome + ", Sigla=" + sigla + ", País=" + pais + ", Região=" + regioes
				+ "]";
	}
}
