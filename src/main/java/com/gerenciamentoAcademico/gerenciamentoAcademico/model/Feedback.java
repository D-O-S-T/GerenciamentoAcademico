package com.gerenciamentoAcademico.gerenciamentoAcademico.model;

public class Feedback {
	private int id;
	private Aluno aluno;
	private Professor professor;
	private String feedbackAluno;
	private String feedbackProfessor;
	
	public Feedback(int id, Aluno aluno, Professor professor, String feedbackAluno, String feedbackProfessor) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.professor = professor;
		this.feedbackAluno = feedbackAluno;
		this.feedbackProfessor = feedbackProfessor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getFeedbackAluno() {
		return feedbackAluno;
	}

	public void setFeedbackAluno(String feedbackAluno) {
		this.feedbackAluno = feedbackAluno;
	}

	public String getFeedbackProfessor() {
		return feedbackProfessor;
	}

	public void setFeedbackProfessor(String feedbackProfessor) {
		this.feedbackProfessor = feedbackProfessor;
	}
}
