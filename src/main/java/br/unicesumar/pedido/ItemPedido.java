package br.unicesumar.pedido;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import br.unicesumar.produto.Produto;
import br.unicesumar.produto.ProdutoId;


@Entity
public class ItemPedido {
	@EmbeddedId
	@AttributeOverride(name="valor", column=@Column(name="id"))
	private ItemPedidoId id;
	
	private BigDecimal quantidade;

//	@ManyToOne(targetEntity=Produto.class)
//	@JoinTable(
//	        name = "produto", 
//	        joinColumns = @JoinColumn(name = "id"), 
//	        inverseJoinColumns = @JoinColumn(name = "produto_id"))
	@AttributeOverride(name="valor", column=@Column(name="produto_id"))
	private ProdutoId produtoId;
	
	public ItemPedido() {
		this.id = new ItemPedidoId();
	}

	public ItemPedido(Produto produto, BigDecimal quantidade) {
		this();
		this.quantidade = quantidade;
		this.produtoId = produto.getId();
	}

	public ItemPedidoId getId() {
		return id;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public ProdutoId getProdutoId() {
		return produtoId;
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
