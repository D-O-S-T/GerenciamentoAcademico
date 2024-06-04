package edu.undf.SGA.IC.model;

public class Atividades {
    private String nomeAtividade;
    private String descricao;
    private String dataAtividade;
    private String aluno;

    public Atividades(String nomeAtividade, String descricao, String dataAtividade, String alunos) {
        this.nomeAtividade = nomeAtividade;
        this.descricao = descricao;
        this.dataAtividade = dataAtividade;
        this.aluno = alunos;
    }

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    public String getProfessor() {
        return descricao;
    }

    public void setProfessor(String professor) {
        this.descricao = professor;
    }

    public String getDataAtividade() {
        return dataAtividade;
    }

    public void setDataAtividade(String dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    public String getAlunos() {
        return aluno;
    }

    public void setAlunos(String alunos) {
        this.aluno = alunos;
    }
}
