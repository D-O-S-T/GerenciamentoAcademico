package iniciacaoCientifica;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoBolsas {
    // Atributos
    private List<Bolsa> bolsas;
    private List<Aluno> alunos;
    private List<Projeto> projetos;

    // Construtor
    public GerenciamentoBolsas() {
        this.bolsas = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.projetos = new ArrayList<>();
    }

    // Métodos de Cadastro
    public void cadastrarBolsa(String modalidade, double valor, String[] requisitos) {
        Bolsa bolsa = new Bolsa(modalidade, valor, requisitos);
        bolsas.add(bolsa);
    }

    public void cadastrarAluno(String nome, String curso, int matricula, String[] documentos, String[] projetos, Double[] notas) {
        Aluno aluno = new Aluno(nome, curso, matricula, documentos, notas);
        alunos.add(aluno);
    }

    public void cadastrarProjeto(String tema, String orientador, Aluno bolsista) {
        Projeto projeto = new Projeto(tema, orientador, bolsista);
        projetos.add(projeto);
    }

    // Métodos de Inscrição
    public void inscreverAlunoBolsa(Aluno aluno, Bolsa bolsa) {
        aluno.inscreverBolsa(bolsa);
    }

    // Métodos de Seleção
    public void selecionarBolsista(Aluno aluno, Bolsa bolsa) {
        // Implementar critérios de seleção
        // ...
        if (aluno.isSelecionado()) {
            bolsa.setBolsista(aluno);
        }
    }

    // Métodos de Consulta
    public void consultarBolsa(Bolsa bolsa) {
        // Implementar consulta de bolsa
    }
    
    public void consultarProjetosAluno(Aluno aluno) {
        // Implementar consulta de projetos
    }

    // ...
}