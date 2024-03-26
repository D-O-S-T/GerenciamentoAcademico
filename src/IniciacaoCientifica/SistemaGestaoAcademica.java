package IniciacaoCientifica;

import java.util.ArrayList;
import java.util.List;

// Classe principal que representa o sistema de gestão acadêmica
public class SistemaGestaoAcademica {
    private List<Aluno> alunos;
    private List<Curso> cursos;
    private List<Bolsa> bolsas;

    public SistemaGestaoAcademica() {
        this.alunos = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.bolsas = new ArrayList<>();
    }

    // Métodos para gestão de alunos
    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public Aluno buscarAluno(String cpf) {
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }

    // Métodos para gestão de cursos
    public void cadastrarCurso(Curso curso) {
        cursos.add(curso);
    }

    public Curso buscarCurso(String nome) {
        for (Curso curso : cursos) {
            if (curso.getNome().equals(nome)) {
                return curso;
            }
        }
        return null;
    }

    // Métodos para gestão de bolsas
    public void solicitarBolsa(Bolsa bolsa) {
        bolsas.add(bolsa);
        // Lógica para análise e concessão de bolsas
    }

    // Outros métodos e funcionalidades podem ser adicionados conforme necessário
}
