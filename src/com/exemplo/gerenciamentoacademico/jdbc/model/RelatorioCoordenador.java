package com.exemplo.gerenciamentoacademico.jdbc.model;

public class RelatorioCoordenador {
    private int id;
    private String titulo;
    private String relatorio;
    private int coordenadorId;

    public RelatorioCoordenador(int id, String titulo, String relatorio, int coordenadorId) {
        this.id = id;
        this.titulo = titulo;
        this.relatorio = relatorio;
        this.coordenadorId = coordenadorId;
    }

    public RelatorioCoordenador(String titulo, String relatorio, int coordenadorId) {
        this.titulo = titulo;
        this.relatorio = relatorio;
        this.coordenadorId = coordenadorId;
    }
    
    public RelatorioCoordenador() {

    }

    // Getters e Setters (gerados automaticamente)

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

    public int getCoordenadorId() {
        return coordenadorId;
    }

    public void setCoordenadorId(int coordenadorId) {
        this.coordenadorId = coordenadorId;
    }

    @Override
    public String toString() {
        return "RelatorioCoordenador{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", relatorio='" + relatorio + '\'' +
                ", coordenadorId=" + coordenadorId +
                '}';
    }
}

