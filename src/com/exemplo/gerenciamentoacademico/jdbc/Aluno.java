package com.exemplo.gerenciamentoacademico.jdbc;

public class Aluno {
	private int id;
    private int usuarioId;
    private String matricula;
    private String curso;
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

    public Aluno(int id, int usuarioId, String matricula, String curso, String nome, String email, String lattes) {
        super();
        this.id = id;
        this.usuarioId = usuarioId;
        this.matricula = matricula;
        this.curso = curso;
        this.nome = nome;
        this.email = email;
        this.lattes = lattes;
    }

    public Aluno(int usuarioId, String matricula, String curso, String nome, String email, String lattes) {
        super();
        this.matricula = matricula;
        this.curso = curso;
        this.nome = nome;
        this.email = email;
        this.lattes = lattes;
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", usuarioId=" + usuarioId + ", matricula=" + matricula + ", curso=" + curso
                + ", nome=" + nome + ", email=" + email + ", lattes=" + lattes + "]";
    }
}
