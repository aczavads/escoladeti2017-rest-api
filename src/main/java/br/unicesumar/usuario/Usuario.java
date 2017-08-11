package br.unicesumar.usuario;

import java.util.UUID;

public class Usuario {
	private String id;
	private String login;
	private String senha;
	private String nome;

	
	public Usuario() {
		this.id = UUID.randomUUID().toString();
	}
	
	public Usuario(String login, String senha, String nome) {
		this();
		this.login = login;
		this.senha = senha;
		this.nome = nome;
	}
	
	public String getId() {
		return this.id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getNome() {
		return nome;
	}
	
	
	
	
	

}
