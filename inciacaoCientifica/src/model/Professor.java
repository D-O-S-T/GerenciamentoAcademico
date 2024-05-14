package model;

public class Professor extends Pessoa{
    int matriculaProfessor;
    String departamento;
    String areaAtuacao;
    
    
    public Professor(String nome, String email, String telefone, int matriculaProfessor, String departamento, String areaAtuacao) {
        super(nome, email, telefone);
        this.matriculaProfessor = matriculaProfessor;
        this.departamento = departamento;
       this.areaAtuacao = areaAtuacao;
    }


    public int getMatriculaProfessor() {
        return matriculaProfessor;
    }


    public void setMatriculaProfessor(int matriculaProfessor) {
        this.matriculaProfessor = matriculaProfessor;
    }


    public String getDepartamento() {
        return departamento;
    }


    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }


    public String getAreaAtuacao() {
        return areaAtuacao;
    }


    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
    
}
