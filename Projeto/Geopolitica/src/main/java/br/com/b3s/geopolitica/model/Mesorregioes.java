package br.com.b3s.geopolitica.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "geo_mesorregioes")
public class Mesorregioes {

	@jakarta.persistence.Id
	@Column(name = "id_mesorregiao")
	private String Id;
	
	@Column(name = "nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_estado")
	private Estados estado;
	
	public Mesorregioes() {
		
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

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesorregioes other = (Mesorregioes) obj;
		return Objects.equals(Id, other.Id);
	}

	@Override
	public String toString() {
		return "Mesorregioes [Id=" + Id + ", Mesorregião=" + nome + ", Estado=" + estado + "]";
	}
	
}
