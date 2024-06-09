package com.gerenciamentoAcademico.gerenciamentoAcademico.model;

public class Frequencia {
	private int id;
	private Aluno aluno;
	private double porcentagemFrequencia;
	
	public Frequencia(int id, Aluno aluno, double porcentagemFrequencia) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.porcentagemFrequencia = porcentagemFrequencia;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public double getPorcentagemFrequencia() {
		return porcentagemFrequencia;
	}
	public void setPorcentagemFrequencia(double porcentagemFrequencia) {
		this.porcentagemFrequencia = porcentagemFrequencia;
	}
	
	
}
