package br.unicesumar.pedido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@EmbeddedId
	@AttributeOverride(name="valor", column=@Column(name="id"))
	private PedidoId id;
	
	private Integer numero;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="pedido_id", referencedColumnName="id")
	private List<ItemPedido> itens = new ArrayList<>();

	
	public Pedido() {
		this.id = new PedidoId();
	}
		
	public Pedido(Integer numero, List<ItemPedido> itens) {
		this();
		this.numero = numero;
		this.itens = itens;
	}
	
	public PedidoId getId() {
		return id;
	}

	public Integer getNumero() {
		return numero;
	}

	public List<ItemPedido> getItens() {
		return Collections.unmodifiableList(itens);
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	


}



