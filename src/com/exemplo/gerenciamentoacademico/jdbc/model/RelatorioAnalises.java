package com.exemplo.gerenciamentoacademico.jdbc.model;

public class RelatorioAnalises {
    private int totalUsuarios;
    private int totalProfessores;
    private int totalAlunos;
    private int totalCoordenadores;
    private int totalAtividades;
    private int totalProjetos;
    private int totalEntregas;

    // Default constructor
    public RelatorioAnalises() {
    }

    // Parameterized constructor
    public RelatorioAnalises(int totalUsuarios, int totalProfessores, int totalAlunos, int totalCoordenadores, int totalAtividades, int totalProjetos, int totalEntregas) {
        this.totalUsuarios = totalUsuarios;
        this.totalProfessores = totalProfessores;
        this.totalAlunos = totalAlunos;
        this.totalCoordenadores = totalCoordenadores;
        this.totalAtividades = totalAtividades;
        this.totalProjetos = totalProjetos;
        this.totalEntregas = totalEntregas;
    }

    // Getters and Setters
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



