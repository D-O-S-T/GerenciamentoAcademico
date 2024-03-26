package IniciacaoCientifica;

import java.util.List;

// Classe Curso para representar os cursos
class Curso {
	// Atributos
	private String nome;
	private int cargaHoraria;
	private List<Disciplina> disciplinas;
	
	// Construtor
	public Curso(String nome, int cargaHoraria) {
		super();
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
	}

	// Getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
