package br.unicesumar.produto;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class Produto {
	@EmbeddedId
	@AttributeOverride(name="valor", column=@Column(name="id"))
	private ProdutoId id;
	private String nome;
	
	public Produto() {
		this.id = new ProdutoId();
	}

	public Produto(String nome) {
		this.id = id;
		this.nome = nome;
	}

	public ProdutoId getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	

}
