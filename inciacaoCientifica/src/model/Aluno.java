package model;

public class Aluno extends Pessoa{
    int matriculaAluno;
    String curso;
    String semestre;
    String periodo;
    String cpf;
    
    
    public Aluno(String nome, String email, String telefone, int  matriculaAluno, String curso, String semestre, String periodo, String cpf) {
        super(nome, email, telefone);
        this.matriculaAluno = matriculaAluno;
        this.curso = curso;
        this.semestre = semestre;
        this.periodo = periodo;
        this.cpf = cpf;
    }


    public int getMatriculaAluno() {
        return matriculaAluno;
    }


    public void setMatriculaAluno(int matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }


    public String getCurso() {
        return curso;
    }


    public void setCurso(String curso) {
        this.curso = curso;
    }


    public String getSemestre() {
        return semestre;
    }


    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }


    public String getPeriodo() {
        return periodo;
    }


    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
