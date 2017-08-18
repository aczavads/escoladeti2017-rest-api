package br.unicesumar.grupoUsuario.dtos;


public class GrupoUsuarioDTO {
	private String id;
	private String nome;

	public GrupoUsuarioDTO(
			String id, 
			String nome) {
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
