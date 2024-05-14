package model;

public abstract class Pessoa {
    String nome;
    String email;
    String telefone;
    
    public Pessoa(String nome, String email, String telefone) {
        super();
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}