package edu.undf.SGA.IC.model;

public class Coordenador extends Pessoa{
    String cargo;
    String departamento;
    
    public Coordenador(String nome, String email, String telefone, String cargo, String departamento) {
        super(nome, email, telefone);
        this.cargo = cargo;
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    

}
