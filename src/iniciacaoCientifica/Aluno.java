package iniciacaoCientifica;

public class Aluno {
	// Atributos
	private String nome;
	private String curso; 
	private int matricula;
	private String[] documentos;
	private double coeficienteRendimento;
	private Double[] notas;
	
	// Construtor
	public Aluno(String nome, String curso, int matricula, String[] documentos, Double[] notas) {
		this.nome = nome;
		this.curso = curso;
		this.matricula = matricula;
		this.documentos = documentos;
		this.notas = notas;
		this.coeficienteRendimento = calcularCoeficienteRendimento();
	}
	
	// ------------------------------- Métodos ------------------------------- //
    // Get
	public String getNome() {
        return nome;
    }
    public String getCurso() {
        return curso;
    }
    public int getMatricula() {
        return matricula;
    }
    public String[] getDocumentos() {
        return documentos;
    }
    
    public double calcularCoeficienteRendimento() {
        double somaNotas = 0.0;
        double somaCreditos = 0.0;
        for (int i = 0; i < notas.length; i++) {
            somaNotas += notas[i];
            somaCreditos += 1.0; // Considerando 1 crédito por disciplina
        }
        return somaNotas / somaCreditos;
    }
    
    public double getCoeficienteRendimento() {
    	return coeficienteRendimento;
    }
    
    // Retorna true apenas para os alunos que atendem aos critérios de seleção
    public boolean isSelecionado() {
        CriteriosSelecao criterios = new CriteriosSelecao(this.getCoeficienteRendimento());
        return criterios.isAlunoSelecionado(this);
    }
	
	// verificar se o aluno atende aos requisitos da bolsa
	public void inscreverBolsa(Bolsa bolsa) {
		System.out.println("Inscrever o aluno em uma bolsa.");
	}
	
	// verificar se o projeto está disponível e se o aluno é elegível
	public void inscreverProjeto() {
		System.out.println("A qual projeto a bolsa está associada.");
	}
	
	// recuperar o histórico de bolsas do aluno do banco de dados
	public void consultarHistorico() {
		System.out.println("Consultar o histórico de bolsas do aluno.");
	}
}
