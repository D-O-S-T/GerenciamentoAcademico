package IniciacaoCientifica;

// Classe principal que contém o método main para executar o sistema
public class ClassePrincipal {
	public static void main(String[] args) {

		SistemaGestaoAcademica sistema = new SistemaGestaoAcademica();

		// Exemplo de uso do sistema
		Aluno aluno1 = new Aluno(
				"Fulano", 
				"123.456.789-00", 
				"Rua A", 
				"fulano@example.com"
		);
		sistema.cadastrarAluno(aluno1);

		// Cadastramento de curso
		Curso curso1 = new Curso("Engenharia de Software", 240);
		sistema.cadastrarCurso(curso1);

		// Exemplo de solicitação de bolsa
		Bolsa bolsa1 = new Bolsa("Bolsa de Estudo", aluno1, false, 500.00);
		sistema.solicitarBolsa(bolsa1);
	}
}
