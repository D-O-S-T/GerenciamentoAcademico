package com.exemplo.gerenciamentoacademico.jdbc;

public class Coordenacao {
	private int id;
    private int usuarioId;
    private String departamento;
    private String nome;
    private String email;

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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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

    public Coordenacao(int id, int usuarioId, String departamento, String nome, String email) {
        super();
        this.id = id;
        this.usuarioId = usuarioId;
        this.departamento = departamento;
        this.nome = nome;
        this.email = email;
    }

    public Coordenacao(int usuarioId, String departamento, String nome, String email) {
        super();
        this.departamento = departamento;
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Coordenacao [id=" + id + ", usuarioId=" + usuarioId + ", departamento=" + departamento + ", nome=" + nome
                + ", email=" + email + "]";
    }
}
