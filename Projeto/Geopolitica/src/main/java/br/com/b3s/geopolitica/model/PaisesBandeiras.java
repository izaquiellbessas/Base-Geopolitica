package br.com.b3s.geopolitica.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "geo_paises_bandeiras")
public class PaisesBandeiras {

	@Id
	@Column(name = "id_pais_bandeira")
	private int id;
	
	@Column(name = "bandeira_descricao")
	private String descricao;
	
	@Lob
	@Column(name = "img_bandeira")
	private byte[] imagem;
	
	@ManyToOne
	@JoinColumn(name = "fk_pais_iso_alpha3")
	private Paises pais;
	
	@Column(name = "img_nome")
	private String imagemNome;
	
	@Column(name = "img_mime_type")
	private String imagemMimeType;
	
	public PaisesBandeiras() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Paises getPais() {
		return pais;
	}

	public void setPais(Paises pais) {
		this.pais = pais;
	}
	
	public String getImagemNome() {
		return imagemNome;
	}

	public void setImagemNome(String imagemNome) {
		this.imagemNome = imagemNome;
	}

	public String getImagemMimeType() {
		return imagemMimeType;
	}

	public void setImagemMimeType(String imagemMimeType) {
		this.imagemMimeType = imagemMimeType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaisesBandeiras other = (PaisesBandeiras) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Bandeiras [id=" + id + ", Arquivo=" + imagemNome + ", Tipo=" + imagemMimeType + ", Descrição=" + descricao + ", País=" + pais + "]";
	}
}
