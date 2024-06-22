package com.exemplo.gerenciamentoacademico.jdbc.model;

public class Professor {
    private int id;
    private String nome;
    private String email;
    private String lattes;
    private String login;
    private String senha;
    private String areaAtuacao;

    // Construtor com todos os campos
    public Professor(int id, String nome, String email, String lattes, String login, String senha, String areaAtuacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.lattes = lattes;
        this.login = login;
        this.senha = senha;
        this.areaAtuacao = areaAtuacao;
    }
    
    public Professor(String nome, String email, String lattes, String login, String senha, String areaAtuacao) {
    	this.nome = nome;
    	this.email = email;
    	this.lattes = lattes;
    	this.login = login;
    	this.senha = senha;
    	this.areaAtuacao = areaAtuacao;
    }
    
    public Professor(String nome, String email, String lattes, String areaAtuacao) {
    	this.nome = nome;
    	this.email = email;
    	this.lattes = lattes;
    	this.areaAtuacao = areaAtuacao;
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

    public String getLattes() {
        return lattes;
    }

    public void setLattes(String lattes) {
        this.lattes = lattes;
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

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    // Método toString para representação textual do objeto
    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", lattes='" + lattes + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", areaAtuacao='" + areaAtuacao + '\'' +
                '}';
    }
}
