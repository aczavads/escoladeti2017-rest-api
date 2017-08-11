package br.unicesumar.grupoUsuario;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GrupoUsuarioDTO {
	private String id;
	private String nome;

	public GrupoUsuarioDTO() {
		// TODO Auto-generated constructor stub
	}

	@JsonCreator
	public GrupoUsuarioDTO(
			@JsonProperty("id") String id, 
			@JsonProperty("nome") String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
