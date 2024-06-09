package com.gerenciamentoAcademico.gerenciamentoAcademico.model;

import java.util.Set;

public class Usuario {
	private int id;
	private int cpf;
	private String senha;
	private Set<Grupo> grupos;
	
	public Usuario(int id, int cpf, String senha, Set<Grupo> grupos) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.senha = senha;
		this.grupos = grupos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Set<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	
	
}
