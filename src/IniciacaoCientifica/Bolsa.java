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
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public boolean isConcedida() {
		return concedida;
	}

	public void setConcedida(boolean concedida) {
		this.concedida = concedida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
