package com.exemplo.gerenciamentoacademico.jdbc.model;

public class FeedbackAluno {


	private int id;
	private String titulo;
	private String feedback;
	private int alunoId;
	private int professorId;
	
	private String alunoNome;
	private String professorNome;

	// Construtores
	public FeedbackAluno() {
	}
	
	
	public FeedbackAluno(String titulo, String feedback, int alunoId, int professorId, String alunoNome,
			String professorNome) {
		super();
		this.titulo = titulo;
		this.feedback = feedback;
		this.alunoId = alunoId;
		this.professorId = professorId;
		this.alunoNome = alunoNome;
		this.professorNome = professorNome;
	}

	
	public FeedbackAluno(int id, String titulo, String feedback, int alunoId, int professorId, String alunoNome,
			String professorNome) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.feedback = feedback;
		this.alunoId = alunoId;
		this.professorId = professorId;
		this.alunoNome = alunoNome;
		this.professorNome = professorNome;
	}

	
	

	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}



	public String getAlunoNome() {
		return alunoNome;
	}


	public void setAlunoNome(String alunoNome) {
		this.alunoNome = alunoNome;
	}


	public String getProfessorNome() {
		return professorNome;
	}


	public void setProfessorNome(String professorNome) {
		this.professorNome = professorNome;
	}
	
	
	// toString() para representação textual do objeto
		@Override
		public String toString() {
			return "FeedbackAluno{" + "id=" + id + ", titulo='" + titulo + '\'' + ", feedback='" + feedback + '\''
					+ ", alunoId=" + alunoId + ", professorId=" + professorId + '}';
		}

}
