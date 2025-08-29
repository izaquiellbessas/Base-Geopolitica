package br.com.b3s.geopolitica.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "geo_paises")
public class Paises {

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "iso_alpha2")
	private String isoAlpha2;
	
	@Id
	@Column(name = "iso_alpha3")
	private String isoAlpha3;
	
	@Column(name = "iso_numero")
	private String isoNumero;

	public Paises() {
	}

	public Paises(String nome, String isoAlpha2, String isoAlpha3, String isoNumero) {
		super();
		this.nome = nome;
		this.isoAlpha2 = isoAlpha2;
		this.isoAlpha3 = isoAlpha3;
		this.isoNumero = isoNumero;
	}

	public Paises(String nome, String isoAlpha3) {
		super();
		this.nome = nome;
		this.isoAlpha3 = isoAlpha3;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIsoAlpha2() {
		return isoAlpha2;
	}

	public void setIsoAlpha2(String isoAlpha2) {
		this.isoAlpha2 = isoAlpha2;
	}

	public String getIsoAlpha3() {
		return isoAlpha3;
	}

	public void setIsoAlpha3(String isoAlpha3) {
		this.isoAlpha3 = isoAlpha3;
	}

	public String getIsoNumero() {
		return isoNumero;
	}

	public void setIsoNumero(String isoNumero) {
		this.isoNumero = isoNumero;
	}

	@Override
	public String toString() {
		return "Paises [nome=" + nome + ", isoAlpha2=" + isoAlpha2 + ", isoAlpha3=" + isoAlpha3 + ", isoNumero="
				+ isoNumero + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(isoAlpha3);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paises other = (Paises) obj;
		return Objects.equals(isoAlpha3, other.isoAlpha3);
	}

}
