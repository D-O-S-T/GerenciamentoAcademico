package com.exemplo.gerenciamentoacademico.jdbc.model;

import java.time.LocalDate;

public class Entrega {
    private int id;
    private String conteudo;
    private LocalDate dataEntrega;
    private int professorId;
    private int alunoDaEntregaId;
    private int atividadeId;

    public Entrega() {
    }

    public Entrega(int id, String conteudo, LocalDate dataEntrega, int professorId, int alunoDaEntregaId, int atividadeId) {
        this.id = id;
        this.conteudo = conteudo;
        this.dataEntrega = dataEntrega;
        this.professorId = professorId;
        this.alunoDaEntregaId = alunoDaEntregaId;
        this.atividadeId = atividadeId;
    }

    public Entrega(String conteudo, LocalDate dataEntrega, int professorId, int alunoDaEntregaId, int atividadeId) {
        this.conteudo = conteudo;
        this.dataEntrega = dataEntrega;
        this.professorId = professorId;
        this.alunoDaEntregaId = alunoDaEntregaId;
        this.atividadeId = atividadeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public int getAlunoDaEntregaId() {
        return alunoDaEntregaId;
    }

    public void setAlunoDaEntregaId(int alunoDaEntregaId) {
        this.alunoDaEntregaId = alunoDaEntregaId;
    }

    public int getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(int atividadeId) {
        this.atividadeId = atividadeId;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "id=" + id +
                ", conteudo='" + conteudo + '\'' +
                ", dataEntrega=" + dataEntrega +
                ", professorId=" + professorId +
                ", alunoDaEntregaId=" + alunoDaEntregaId +
                ", atividadeId=" + atividadeId +
                '}';
    }
}

