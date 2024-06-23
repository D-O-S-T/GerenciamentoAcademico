package com.exemplo.gerenciamentoacademico.jdbc.model;

import java.time.LocalDate;

public class Atividade {
    private int id;
    private String titulo;
    private String conteudo;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private int projetoId;
    private String projetoTitulo; // Nome do projeto, não persistido no banco

    public Atividade() {
    }

    public Atividade(int id, String titulo, String conteudo, LocalDate dataInicial, LocalDate dataFinal, int projetoId) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.projetoId = projetoId;
    }
    
    public Atividade(int id, String titulo, String conteudo, LocalDate dataInicial, LocalDate dataFinal) {
    	this.id = id;
    	this.titulo = titulo;
    	this.conteudo = conteudo;
    	this.dataInicial = dataInicial;
    	this.dataFinal = dataFinal;
    }
    
	public Atividade(int id, String titulo, String conteudo, LocalDate dataInicial, LocalDate dataFinal, int projetoId,
			String projetoTitulo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.projetoId = projetoId;
		this.projetoTitulo = projetoTitulo;
	}

	public Atividade(String titulo, String conteudo, LocalDate dataInicial, LocalDate dataFinal, int projetoId) {
		super();
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.projetoId = projetoId;
		
	}
	
	public Atividade(String titulo, String conteudo, LocalDate dataInicial, LocalDate dataFinal) {
		super();
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		
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

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
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

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    public String getProjetoTitulo() {
        return projetoTitulo;
    }

    public void setProjetoTitulo(String projetoTitulo) {
        this.projetoTitulo = projetoTitulo;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", projetoId=" + projetoId +
                ", projetoTitulo='" + projetoTitulo + '\'' +
                '}';
    }
}
