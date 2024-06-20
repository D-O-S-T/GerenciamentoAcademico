package com.exemplo.gerenciamentoacademico.jdbc.model;

import java.util.Date;

public class Projeto {
    private int id;
    private String titulo;
    private Date dataInicial;
    private Date dataFinal;
    private int qtdAulas;
    
    // Construtor padrão
    public Projeto() {
    }
    
    // Construtor com todos os campos
    public Projeto(int id, String titulo, Date dataInicial, Date dataFinal, int qtdAulas) {
        this.id = id;
        this.titulo = titulo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.qtdAulas = qtdAulas;
    }
    
    public Projeto(String titulo, Date dataInicial, Date dataFinal, int qtdAulas) {
    	this.titulo = titulo;
    	this.dataInicial = dataInicial;
    	this.dataFinal = dataFinal;
    	this.qtdAulas = qtdAulas;
    }
    
    // Getters e Setters
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
    
    public Date getDataInicial() {
        return dataInicial;
    }
    
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }
    
    public Date getDataFinal() {
        return dataFinal;
    }
    
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
    
    public int getQtdAulas() {
        return qtdAulas;
    }
    
    public void setQtdAulas(int qtdAulas) {
        this.qtdAulas = qtdAulas;
    }
    
    // Método toString para exibir informações do objeto
    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", qtdAulas=" + qtdAulas +
                '}';
    }
}
