package IniciacaoCientifica;

import java.util.List;

// Classe Aluno para representar os alunos
class Aluno {
	// Atributos
	private String nome;
	private String cpf;
	private String endereco;
	private String contato;
	private List<Disciplina> disciplinasMatriculadas;
	
	// Construtor
	public Aluno(String nome, String cpf, String endereco, String contato) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.contato = contato;
	}

	// Getters e setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
