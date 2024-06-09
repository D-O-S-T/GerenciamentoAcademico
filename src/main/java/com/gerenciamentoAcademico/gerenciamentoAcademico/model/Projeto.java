package com.gerenciamentoAcademico.gerenciamentoAcademico.model;

import java.time.LocalDate;

public class Projeto {
	private int id;
	private String titulo;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private	int horasPorSemana;
	
	public Projeto(int id, String titulo, LocalDate dataInicial, LocalDate dataFinal, int horasPorSemana) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.horasPorSemana = horasPorSemana;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public int getHorasPorSemana() {
		return horasPorSemana;
	}

	public void setHorasPorSemana(int horasPorSemana) {
		this.horasPorSemana = horasPorSemana;
	}
	
}
