package iniciacaoCientifica;

public class Projeto {
	// Atributos
	private String tema;
	private String orientador; 
	private Aluno bolsista;
	
	// Construtor
	public Projeto(String tema, String orientador, Aluno bolsista) {
		this.tema = tema;
		this.orientador = orientador;
		this.bolsista = bolsista;
	}
	
	// ------------------------------- Métodos ------------------------------- //
    // Get
	public String getTema() {
        return tema;
    }
    public String getOrientador() {
        return orientador;
    }
    public Aluno getBolsista() {
        return bolsista;
    }
    
	// verificar o andamento do projeto e atualizar o status
	public void acompanharProjeto() {
		System.out.println("Checar se o projeto está disponível.");
	}
}
