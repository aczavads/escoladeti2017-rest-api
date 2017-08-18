package br.unicesumar.pedido;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Embeddable;


@Embeddable
public class PedidoId implements Serializable {
	private String valor;
	
	public PedidoId() {
		this.valor = UUID.randomUUID().toString();
	}

	public PedidoId(String valor) {
		super();
		this.valor = valor;
	}

	@Override
	public String toString() {
		return this.valor;
	}
	
	public String getValor() {
		return valor;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		PedidoId other = (PedidoId) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
