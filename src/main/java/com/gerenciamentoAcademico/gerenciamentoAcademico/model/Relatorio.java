package com.gerenciamentoAcademico.gerenciamentoAcademico.model;

import java.time.LocalDate;

public class Relatorio {
	private int id;
	private LocalDate dataEmissao;
	private LocalDate dataCorrespondente;
	private String informacoes;
	private Professor professor;
	private Aluno aluno;
	
	public Relatorio(int id, LocalDate dataEmissao, LocalDate dataCorrespondente, String informacoes,
			Professor professor, Aluno aluno) {
		super();
		this.id = id;
		this.dataEmissao = dataEmissao;
		this.dataCorrespondente = dataCorrespondente;
		this.informacoes = informacoes;
		this.professor = professor;
		this.aluno = aluno;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public LocalDate getDataCorrespondente() {
		return dataCorrespondente;
	}
	public void setDataCorrespondente(LocalDate dataCorrespondente) {
		this.dataCorrespondente = dataCorrespondente;
	}
	public String getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
}
