package com.gerenciamentoAcademico.gerenciamentoAcademico.model;

import java.util.Set;

public class Grupo {
	private int id;
	private String nome;
	private Set<Permissao> permissoes;
	
	public Grupo(int id, String nome, Set<Permissao> permissoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.permissoes = permissoes;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Permissao> getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(Set<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	
}
