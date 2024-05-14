package model;

import java.sql.Date;
//import java.util.List;

public class ProjetoPesquisa {
    private String id;
    private String titulo;
    private String descricao;
    private Professor professorResponsavel;
    private Aluno alunosParticipantes;
    //private List<Aluno> alunosParticipantes;
    //private java.util.Date dataInicio;
    //private java.util.Date dataTermino;
    //private String status;
    
    public ProjetoPesquisa(String id, String titulo, String descricao, Professor professorResponsavel,
            Aluno alunosParticipantes, Date dataInicio, Date dataTermino, String status) {
        super();
        this.setId(id);
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.setProfessorResponsavel(professorResponsavel);
        this.setAlunosParticipantes(alunosParticipantes);
        //this.setDataInicio(dataInicio);
        //this.setDataTermino(dataTermino);
        //this.setStatus(status);
    }

	/*public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	*/
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Professor getProfessorResponsavel() {
		return professorResponsavel;
	}

	public void setProfessorResponsavel(Professor professorResponsavel) {
		this.professorResponsavel = professorResponsavel;
	}

	public Aluno getAlunosParticipantes() {
		return alunosParticipantes;
	}

	public void setAlunosParticipantes(Aluno alunosParticipantes) {
		this.alunosParticipantes = alunosParticipantes;
	}

	
    
    
}
