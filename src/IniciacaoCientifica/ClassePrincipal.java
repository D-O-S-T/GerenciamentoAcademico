package IniciacaoCientifica;

import java.util.List;

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
		
		// Impressão dos dados cadastrados
        System.out.println("Alunos cadastrados:");
        List<Aluno> alunos = sistema.getAlunos();
        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome() + ", CPF: " + aluno.getCpf());
        }

        System.out.println("\nCursos cadastrados:");
        List<Curso> cursos = sistema.getCursos();
        for (Curso curso : cursos) {
            System.out.println("Nome: " + curso.getNome() + ", Carga Horária: " + curso.getCargaHoraria());
        }

        System.out.println("\nBolsas solicitadas:");
        List<Bolsa> bolsas = sistema.getBolsas();
        for (Bolsa bolsa : bolsas) {
            System.out.println("Tipo: " + bolsa.getTipo() + ", Aluno: " + bolsa.getAluno().getNome() + ", Valor: " + bolsa.getValor());
        }
	}
}
