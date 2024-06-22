package com.exemplo.gerenciamentoacademico.jdbc.model;

public class RelatorioProfessor {
    private int id;
    private String titulo;
    private String relatorio;
    private int professorId;

    public RelatorioProfessor(int id, String titulo, String relatorio, int professorId) {
        this.id = id;
        this.titulo = titulo;
        this.relatorio = relatorio;
        this.professorId = professorId;
    }

    public RelatorioProfessor(String titulo, String relatorio, int professorId) {
        this.titulo = titulo;
        this.relatorio = relatorio;
        this.professorId = professorId;
    }
    
    public RelatorioProfessor(String titulo, String relatorio) {
    	this.titulo = titulo;
    	this.relatorio = relatorio;
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

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    @Override
    public String toString() {
        return "RelatorioProfessor{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", relatorio='" + relatorio + '\'' +
                ", professorId=" + professorId +
                '}';
    }
}
