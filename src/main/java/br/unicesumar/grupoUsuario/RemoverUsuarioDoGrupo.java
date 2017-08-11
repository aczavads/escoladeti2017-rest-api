package br.unicesumar.grupoUsuario;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RemoverUsuarioDoGrupo {
	public final String idDoGrupo;
	public final String idDoUsuario;
	
	@JsonCreator
	public RemoverUsuarioDoGrupo(
			@JsonProperty("idDoGrupo") String idDoGrupo, 
			@JsonProperty("idDoUsuario") String idDoUsuario) {
		this.idDoGrupo = idDoGrupo;
		this.idDoUsuario = idDoUsuario;
	}

}
