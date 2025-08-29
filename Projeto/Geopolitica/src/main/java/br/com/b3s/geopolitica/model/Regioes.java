package br.com.b3s.geopolitica.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "geo_regioes")
public class Regioes {

	@jakarta.persistence.Id
	@Column(name = "id_regiao")
	private String Id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sigla")
	private String sigla;
	
	public Regioes() {
		
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(nome, sigla);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regioes other = (Regioes) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sigla, other.sigla);
	}

	@Override
	public String toString() {
		return "Regioes [Id=" + Id + ", Região=" + nome + ", Sigla=" + sigla + "]";
	}
}
