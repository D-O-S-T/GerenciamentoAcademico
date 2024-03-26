package IniciacaoCientifica;

// Classe Bolsa para representar as bolsas
class Bolsa {
	// Atributos
	private String tipo;
	private Aluno aluno;
	private boolean concedida;
	private double valor;
	
	// Construtor
	public Bolsa(String tipo, Aluno aluno, boolean concedida, double valor) {
		super();
		this.tipo = tipo;
		this.aluno = aluno;
		this.concedida = concedida;
		this.valor = valor;
	}

	// Getters e setters
}
