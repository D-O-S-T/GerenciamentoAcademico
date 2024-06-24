
package com.exemplo.gerenciamentoacademico.jdbc.model;



public class FeedbackProfessor {
    


	private int id;
    private String titulo;
    private String feedback;
    private int professorId;
    private int alunoId;
    private String alunoNome;
    private String professorNome;
    
    

    // Construtor padrão
    public FeedbackProfessor() {
    }
    

	public FeedbackProfessor(String titulo, String feedback, int professorId, String alunoNome) {
		super();
		this.titulo = titulo;
		this.feedback = feedback;
		this.professorId = professorId;
		this.alunoNome = alunoNome;
	}
    
    

    // Construtor com parâmetros
    public FeedbackProfessor(int id, String titulo, String feedback, int professorId, int alunoId) {
        this.id = id;
        this.titulo = titulo;
        this.feedback = feedback;
        this.professorId = professorId;
        this.alunoId = alunoId;
    }
    
    public FeedbackProfessor(String titulo, String feedback, int professorId, int alunoId) {
		super();
		this.titulo = titulo;
		this.feedback = feedback;
		this.professorId = professorId;
		this.alunoId = alunoId;
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

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

 

	public String getAlunoNome() {
		return alunoNome;
	}

	public void setAlunoNome(String alunoNome) {
		this.alunoNome = alunoNome;
	}
	
	 // Novo setter para professorNome
    public void setProfessorNome(String professorNome) {
        this.professorNome = professorNome;
    }

    // Novo getter para professorNome
    public String getProfessorNome() {
        return professorNome;
    }


	@Override
	public String toString() {
		return "FeedbackProfessor [id=" + id + ", titulo=" + titulo + ", feedback=" + feedback + ", professorId="
				+ professorId + ", alunoId=" + alunoId + ", alunoNome=" + alunoNome + ", professorNome=" + professorNome
				+ "]";
	}
    
    
}
