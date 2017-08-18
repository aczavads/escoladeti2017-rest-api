package br.unicesumar.grupoUsuario.commands;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AdicionarUsuarioAoGrupo {
	public final String idDoGrupo;
	public final String idDoUsuario;
	
	@JsonCreator
	public AdicionarUsuarioAoGrupo(
			@JsonProperty("idDoGrupo") String idDoGrupo, 
			@JsonProperty("idDoUsuario") String idDoUsuario) {
		this.idDoGrupo = idDoGrupo;
		this.idDoUsuario = idDoUsuario;
	}
	

}
