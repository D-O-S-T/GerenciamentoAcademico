package com.gerenciamentoAcademico.gerenciamentoAcademico.model;

import java.time.LocalDate;

public class Bolsa {
	private int id;
	private Aluno aluno;
	private double valor;
	private LocalDate dataInicial;
	private LocalDate datafinal;
	
	public Bolsa(int id, Aluno aluno, double valor, LocalDate dataInicial, LocalDate datafinal) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.valor = valor;
		this.dataInicial = dataInicial;
		this.datafinal = datafinal;
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}
	public LocalDate getDatafinal() {
		return datafinal;
	}
	public void setDatafinal(LocalDate datafinal) {
		this.datafinal = datafinal;
	}
	
	
}
