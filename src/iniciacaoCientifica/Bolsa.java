package iniciacaoCientifica;

public class Bolsa {
	// Atributos
	private String modalidade;
	private double valor; 
	private String[] requisitos;
	private Aluno bolsista;
	
	// Construtor
	public Bolsa(String modalidade, double valor, String[] requisitos) {
		this.modalidade = modalidade;
		this.valor = valor;
		this.requisitos = requisitos;
	}
	
	// ------------------------------- Métodos ------------------------------- //
	// Set
    public void setBolsista(Aluno bolsista) {
    	System.out.println("Bolsa adicionada ao bolsista selecionado.");
    	this.bolsista = bolsista;
    }
    
    // Get
	public String getModalidade() {
        return modalidade;
    }
    public double getValor() {
        return valor;
    }
    public String[] getRequisitos() {
        return requisitos;
    }
    public Aluno getBolsista() {
        return bolsista;
    }
    
    // cadastrar os requisitos da bolsa no banco de dados
	public void cadastrarRequisitos() {
		System.out.println("A bolsa necessita de requisitos.");
	}
	// implementar os critérios de seleção de bolsistas
	public void selecionarBolsista() {
		System.out.println("Escolha o bolsista.");
	}
	
	// monitorar o cumprimento dos requisitos da bolsa e gerar relatórios
	public void monitorarBolsa() {
		System.out.println("Status da bolsa: null.");
	}
}

