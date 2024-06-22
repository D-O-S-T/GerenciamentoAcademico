package com.exemplo.gerenciamentoacademico.jdbc.model;

public class Aluno {
    private int id;
    private String matricula;
    private String nome;
    private String email;
    private String lattes;
    private String login;
    private String senha;

   
    public Aluno(int id, String matricula, String nome, String email, String lattes, String login, String senha) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.lattes = lattes;
        this.login = login;
        this.senha = senha;
    }
    
    public Aluno(String matricula, String nome, String email, String lattes, String login, String senha) {
    	this.matricula = matricula;
    	this.nome = nome;
    	this.email = email;
    	this.lattes = lattes;
    	this.login = login;
    	this.senha = senha;
    }
    
    public Aluno(String matricula, String nome, String email, String lattes) {
    	this.matricula = matricula;
    	this.nome = nome;
    	this.email = email;
    	this.lattes = lattes;
    }
    
    
    public Aluno(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", lattes='" + lattes + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
