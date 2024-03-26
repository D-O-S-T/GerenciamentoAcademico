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
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public List<Aluno> getAlunosMatriculados() {
		return alunosMatriculados;
	}

	public void setAlunosMatriculados(List<Aluno> alunosMatriculados) {
		this.alunosMatriculados = alunosMatriculados;
	}
} 
