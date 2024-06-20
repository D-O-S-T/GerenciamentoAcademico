package com.exemplo.gerenciamentoacademico.jdbc.model;

public class Usuario {
	private int id;
	private String login;
	private String email;
	private String senha;
	private String tipoUsuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void getLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String gettipoUsuario() {
		return tipoUsuario;
	}

	public void settipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario(int id, String login, String email, String senha, String tipoUsuario) {
		super();
		this.id = id;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario(String login, String email, String senha, String tipoUsuario) {
		super();
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", email=" + email + ", senha=" + senha
				+ ", tipoUsuario=" + tipoUsuario + "]";
	}

}
