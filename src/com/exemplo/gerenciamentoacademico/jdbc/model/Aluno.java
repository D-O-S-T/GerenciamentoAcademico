package com.exemplo.gerenciamentoacademico.jdbc.model;

public class Aluno {
    private int id; // não usado no front-end (autoincrement)
    private int usuarioId; // foreign key para Usuario
    private String matricula;
    private String curso;
    private String nome;
    private String email;
    private String lattes;

    // Construtor para criar Aluno sem referência a usuarioId (para uso no front-end)
    public Aluno(String matricula, String curso, String nome, String email, String lattes) {
        this.matricula = matricula;
        this.curso = curso;
        this.nome = nome;
        this.email = email;
        this.lattes = lattes;
    }
    
    public Aluno(int id, String matricula, String curso, String nome, String email, String lattes) {
    	this.id = id;
    	this.matricula = matricula;
    	this.curso = curso;
    	this.nome = nome;
    	this.email = email;
    	this.lattes = lattes;
    }

    // Construtor para criar Aluno com referência a usuarioId (para uso no back-end)
    public Aluno(int id, int usuarioId, String matricula, String curso, String nome, String email, String lattes) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.matricula = matricula;
        this.curso = curso;
        this.nome = nome;
        this.email = email;
        this.lattes = lattes;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    // Não há setId(int id) porque id é autoincrement no banco de dados

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
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

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", usuarioId=" + usuarioId + ", matricula=" + matricula + ", curso=" + curso + ", nome=" + nome
                + ", email=" + email + ", lattes=" + lattes + "]";
    }
}

