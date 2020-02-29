package com.treesoftware.geopolitica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regioes")
public class Regioes {
	
	@Id
	@Column(name = "id_regiao", updatable = false)
	private int idRegiao;
	
	@Column(name = "nome")
	private String nome;
	
	public Regioes() {
		super();
	}

	public Regioes(int idRegiao, String nome) {
		super();
		this.idRegiao = idRegiao;
		this.nome = nome;
	}

	public int getIdRegiao() {
		return idRegiao;
	}

	public void setIdRegiao(int idRegiao) {
		this.idRegiao = idRegiao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
