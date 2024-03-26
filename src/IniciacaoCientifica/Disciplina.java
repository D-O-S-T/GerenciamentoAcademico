package IniciacaoCientifica;

import java.util.List;

// Classe Disciplina para representar as disciplinas
class Disciplina {
	// Atributos
	private String nome;
	private int cargaHoraria;
	private List<Aluno> alunosMatriculados;
	
	// Construtor
	public Disciplina(String nome, int cargaHoraria, List<Aluno> alunosMatriculados) {
		super();
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.alunosMatriculados = alunosMatriculados;
	}

	// Getters e setters
} 
