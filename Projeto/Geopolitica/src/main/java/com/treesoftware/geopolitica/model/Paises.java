package com.treesoftware.geopolitica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paises")
public class Paises {

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "iso_alpha2")
	private String isoAlpha2;
	
	@Id
	@Column(name = "iso_alpha3", updatable = false)
	private String isoAlpha3;
	
	@Column(name = "iso_numero")
	private String isoNumero;

	public Paises() {
		super();
	}
	
	public Paises(String nome, String isoAlpha3) {
		super();
		this.nome = nome;
		this.isoAlpha3 = isoAlpha3;
	}

	public Paises(String nome, String isoAlpha2, String isoAlpha3, String isoNumero) {
		super();
		this.nome = nome;
		this.isoAlpha2 = isoAlpha2;
		this.isoAlpha3 = isoAlpha3;
		this.isoNumero = isoNumero;
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
	

}
