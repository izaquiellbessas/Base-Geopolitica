package br.com.b3s.geopolitica.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "geo_microrregioes")
public class Microrregioes {

	@jakarta.persistence.Id
	@Column(name = "id_microrregiao")
	private String Id;
	
	@Column(name = "nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_mesorregiao")
	private Mesorregioes mesorregiao;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_estado")
	private Estados estado;
	
	public Microrregioes() {
		
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
		Microrregioes other = (Microrregioes) obj;
		return Objects.equals(Id, other.Id);
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

	public Mesorregioes getMesorregiao() {
		return mesorregiao;
	}

	public void setMesorregiao(Mesorregioes mesorregiao) {
		this.mesorregiao = mesorregiao;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Microrregioes [Id=" + Id + ", Microrregião=" + nome + ", Mesorregião=" + mesorregiao + ", Estado=" + estado
				+ "]";
	}
	
}
