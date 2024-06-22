package com.exemplo.gerenciamentoacademico.jdbc.model;

import java.util.Date;

public class Projeto {
    private int id;
    private String titulo;
    private Date dataInicial;
    private Date dataFinal;
    private Professor professor;
    private Aluno alunoBolsista;
    private Aluno alunoVoluntario;
    
    
    // Constructor for inserting a new projeto without ID
    public Projeto(String titulo, Date dataInicial, Date dataFinal, Professor professor, Aluno alunoBolsista, Aluno alunoVoluntario) {
        this.titulo = titulo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.professor = professor;
        this.alunoBolsista = alunoBolsista;
        this.alunoVoluntario = alunoVoluntario;
    }

    public Projeto(String titulo, Date dataInicial, Date dataFinal, Professor professor) {
        this.titulo = titulo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.professor = professor;
    }

    public Projeto(int id, String titulo, Date dataInicial, Date dataFinal, Professor professor, Aluno alunoBolsista, Aluno alunoVoluntario) {
        this.id = id;
        this.titulo = titulo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.professor = professor;
        this.alunoBolsista = alunoBolsista;
        this.alunoVoluntario = alunoVoluntario;
    }

    // Getters e setters para os atributos

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

    public Professor getProfessor() {
        return professor;
    }
    
    

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Aluno getAlunoBolsista() {
        return alunoBolsista;
    }

    public void setAlunoBolsista(Aluno alunoBolsista) {
        this.alunoBolsista = alunoBolsista;
    }

    public Aluno getAlunoVoluntario() {
        return alunoVoluntario;
    }

    public void setAlunoVoluntario(Aluno alunoVoluntario) {
        this.alunoVoluntario = alunoVoluntario;
    }

    @Override
    public String toString() {
        return "Projeto [id=" + id + ", titulo=" + titulo + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal
                + ", professor=" + professor + ", alunoBolsista=" + alunoBolsista + ", alunoVoluntario=" + alunoVoluntario + "]";
    }
}

