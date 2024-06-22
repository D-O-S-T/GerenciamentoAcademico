package com.exemplo.gerenciamentoacademico.jdbc.model;

public class RelatorioAnalises {
    private int totalUsuarios;
    private int totalProfessores;
    private int totalAlunos;
    private int totalCoordenadores;
    private int totalAtividades;
    private int totalProjetos;
    private int totalEntregas;

    // Construtor padrão
    public RelatorioAnalises() {
    }

    // Getters e Setters
    public int getTotalUsuarios() {
        return totalUsuarios;
    }

    public void setTotalUsuarios(int totalUsuarios) {
        this.totalUsuarios = totalUsuarios;
    }

    public int getTotalProfessores() {
        return totalProfessores;
    }

    public void setTotalProfessores(int totalProfessores) {
        this.totalProfessores = totalProfessores;
    }

    public int getTotalAlunos() {
        return totalAlunos;
    }

    public void setTotalAlunos(int totalAlunos) {
        this.totalAlunos = totalAlunos;
    }

    public int getTotalCoordenadores() {
        return totalCoordenadores;
    }

    public void setTotalCoordenadores(int totalCoordenadores) {
        this.totalCoordenadores = totalCoordenadores;
    }

    public int getTotalAtividades() {
        return totalAtividades;
    }

    public void setTotalAtividades(int totalAtividades) {
        this.totalAtividades = totalAtividades;
    }

    public int getTotalProjetos() {
        return totalProjetos;
    }

    public void setTotalProjetos(int totalProjetos) {
        this.totalProjetos = totalProjetos;
    }

    public int getTotalEntregas() {
        return totalEntregas;
    }

    public void setTotalEntregas(int totalEntregas) {
        this.totalEntregas = totalEntregas;
    }
}

