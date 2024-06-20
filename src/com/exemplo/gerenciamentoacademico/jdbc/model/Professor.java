package com.exemplo.gerenciamentoacademico.jdbc.model;

public class Professor {
	private int id;
    private int usuarioId;
    private String areaAtuacao;
    private String nome;
    private String email;
    private String lattes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLattes() {
        return lattes;
    }

    public void setLattes(String lattes) {
        this.lattes = lattes;
    }

    public Professor(int id, int usuarioId, String areaAtuacao, String nome, String email, String lattes) {
        super();
        this.id = id;
        this.usuarioId = usuarioId;
        this.areaAtuacao = areaAtuacao;
        this.nome = nome;
        this.email = email;
        this.lattes = lattes;
    }

    public Professor(int usuarioId, String areaAtuacao, String nome, String email, String lattes) {
        super();
        this.areaAtuacao = areaAtuacao;
        this.nome = nome;
        this.email = email;
        this.lattes = lattes;
    }

    @Override
    public String toString() {
        return "Professor [id=" + id + ", usuarioId=" + usuarioId + ", areaAtuacao=" + areaAtuacao + ", nome=" + nome
                + ", email=" + email + ", lattes=" + lattes + "]";
    }
}
