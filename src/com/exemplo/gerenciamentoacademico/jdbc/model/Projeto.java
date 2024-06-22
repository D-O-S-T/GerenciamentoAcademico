package com.exemplo.gerenciamentoacademico.jdbc.model;

import java.sql.Date;

public class Projeto {
    private int id;
    private String titulo;
    private String conteudo;
    private Date dataInicial;
    private Date dataFinal;
    private int professorId;
    private int alunoBolsistaId;
    private int alunoVoluntarioId;
    
    private String professorNome;
    private String alunoBolsistaNome;
    private String alunoVoluntarioNome;
    
    public Projeto(int id, String titulo, String conteudo, Date dataInicial, Date dataFinal, int professorId, int alunoBolsistaId, int alunoVoluntarioId, String professorNome, String alunoBolsistaNome, String alunoVoluntarioNome) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.professorId = professorId;
        this.alunoBolsistaId = alunoBolsistaId;
        this.alunoVoluntarioId = alunoVoluntarioId;
        this.professorNome = professorNome;
        this.alunoBolsistaNome = alunoBolsistaNome;
        this.alunoVoluntarioNome = alunoVoluntarioNome;
    }

    public Projeto(int id, String titulo, String conteudo, Date dataInicial, Date dataFinal, int professorId, int alunoBolsistaId, int alunoVoluntarioId) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.professorId = professorId;
        this.alunoBolsistaId = alunoBolsistaId;
        this.alunoVoluntarioId = alunoVoluntarioId;
    }

    public Projeto(String titulo, String conteudo, Date dataInicial, Date dataFinal, int professorId, int alunoBolsistaId, int alunoVoluntarioId) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.professorId = professorId;
        this.alunoBolsistaId = alunoBolsistaId;
        this.alunoVoluntarioId = alunoVoluntarioId;
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

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public int getAlunoBolsistaId() {
        return alunoBolsistaId;
    }

    public void setAlunoBolsistaId(int alunoBolsistaId) {
        this.alunoBolsistaId = alunoBolsistaId;
    }

    public int getAlunoVoluntarioId() {
        return alunoVoluntarioId;
    }

    public void setAlunoVoluntarioId(int alunoVoluntarioId) {
        this.alunoVoluntarioId = alunoVoluntarioId;
    }

    public String getProfessorNome() {
        return professorNome;
    }

    public void setProfessorNome(String professorNome) {
        this.professorNome = professorNome;
    }

    public String getAlunoBolsistaNome() {
        return alunoBolsistaNome;
    }

    public void setAlunoBolsistaNome(String alunoBolsistaNome) {
        this.alunoBolsistaNome = alunoBolsistaNome;
    }

    public String getAlunoVoluntarioNome() {
        return alunoVoluntarioNome;
    }

    public void setAlunoVoluntarioNome(String alunoVoluntarioNome) {
        this.alunoVoluntarioNome = alunoVoluntarioNome;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", professorId=" + professorId +
                ", alunoBolsistaId=" + alunoBolsistaId +
                ", alunoVoluntarioId=" + alunoVoluntarioId +
                '}';
    }
}

   