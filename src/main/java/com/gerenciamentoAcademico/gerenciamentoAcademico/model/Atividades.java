package com.gerenciamentoAcademico.gerenciamentoAcademico.model;

import java.time.LocalDate;

public class Atividades {
	private int id;
	private Projeto projeto;
	private Aluno aluno;
	private Professor professor;
	private String titulo;
	private String descricao;
	private LocalDate dataPostagem;
	private LocalDate dataEntrega;
	
	public Atividades(int id, Projeto projeto, Aluno aluno, Professor professor, String titulo, String descricao,
			LocalDate dataPostagem, LocalDate dataEntrega) {
		super();
		this.id = id;
		this.projeto = projeto;
		this.aluno = aluno;
		this.professor = professor;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataPostagem = dataPostagem;
		this.dataEntrega = dataEntrega;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(LocalDate dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	
}
