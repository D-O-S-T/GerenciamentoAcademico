package com.gerenciamentoAcademico.gerenciamentoAcademico.model;

public class Aluno {
	private int id;
	private int matricula;
	private String nome;
	private String email;
	private String linkLattes;
	private Projeto projeto;
	private Professor professor;
	
	public Aluno(int id, int matricula, String nome, String email, String linkLattes, Projeto projeto,
			Professor professor) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.linkLattes = linkLattes;
		this.projeto = projeto;
		this.professor = professor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLinkLattes() {
		return linkLattes;
	}
	public void setLinkLattes(String linkLattes) {
		this.linkLattes = linkLattes;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
}
