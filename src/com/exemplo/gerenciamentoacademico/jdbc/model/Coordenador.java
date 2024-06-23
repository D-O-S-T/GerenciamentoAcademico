package com.exemplo.gerenciamentoacademico.jdbc.model;

public class Coordenador {
    private int id;
    private String nome;
    private String email;
    private String login;
    private String senha;

    public Coordenador(int id, String nome, String email, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }
    
    public Coordenador(String nome, String email, String login, String senha) {
    	this.nome = nome;
    	this.email = email;
    	this.login = login;
    	this.senha = senha;
    }
    
    public Coordenador(String nome, String email) {
    	this.nome = nome;
    	this.email = email;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}

