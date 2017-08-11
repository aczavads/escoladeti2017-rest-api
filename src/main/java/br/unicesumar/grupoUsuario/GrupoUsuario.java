package br.unicesumar.grupoUsuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.unicesumar.usuarioPersistente.Usuario;

@Entity
public class GrupoUsuario {
	@Id
	private String id;
	private String nome;

	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Usuario> usuarios = new HashSet<>();
	
	public void vincular(Usuario usuario) {
		if (!this.usuarios.add(usuario)) {
			throw new UsuarioJaVinculadoAoGrupoException("Não foi possível vincular o usuário ["+ usuario.getNome()+"] ao grupo [" + this.nome+"]");
		}
	}
	
	public GrupoUsuario() {
		this.id = UUID.randomUUID().toString();
	}
	
	public GrupoUsuario(String nome) {
		this();
		this.nome = nome;
	}
	
	public String getId() {
		return this.id;
	}

	public String getNome() {
		return nome;
	}

	public List<Usuario> getUsuarios() {
		return Collections.unmodifiableList(new ArrayList(usuarios));
	}

	public void remover(Usuario usuario) {
		this.usuarios = this.usuarios.stream().filter(u -> !u.getId().equals(usuario.getId())).collect(Collectors.toSet());
		
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
		GrupoUsuario other = (GrupoUsuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
