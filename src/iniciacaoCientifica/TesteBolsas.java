package iniciacaoCientifica;

public class TesteBolsas {
    public static void main(String[] args) {
        // Criar objetos
        Aluno aluno = new Aluno("Allex Silva", "Sistemas de Informação", 12345, new String[] {"RG", "CPF"}, new Double[] {5.0, 6.0, 2.0, 9.0});
        Bolsa bolsa = new Bolsa("Iniciação Científica", 1000.0, new String[] {"Coeficiente de Rendimento >= 8.0"});
        // (DEBUG) Checar coeficiente de rendimento
        double cr = aluno.getCoeficienteRendimento();
        System.out.println("CR: " + cr);
        // Projeto projeto = new Projeto("Desenvolvimento de um chatbot", "Prof. Dr. Carlos", "João Silva"); 
        // ------------ Lembrar de pegar o objeto bolsista e não apenas passar o nome como string --^

        // Inscrever o aluno na bolsa
        aluno.inscreverBolsa(bolsa);

        // Testar inscrição do aluno na bolsa
        if (aluno.getCoeficienteRendimento() < 8.0) {
            System.out.println("Inscrição não realizada. Coeficiente de Rendimento inferior ao mínimo.");
        } else {
            aluno.inscreverBolsa(bolsa);
            System.out.println("Inscrição realizada com sucesso!");
        }
        
        // Testar seleção do bolsista
        GerenciamentoBolsas gerenciamentoBolsas = new GerenciamentoBolsas();
        if (aluno.isSelecionado()) {
            gerenciamentoBolsas.selecionarBolsista(aluno, bolsa);
            System.out.println("Aluno selecionado como bolsista da bolsa " + bolsa.getModalidade());
        } else {
            System.out.println("Aluno não selecionado. Critérios de seleção não atendidos.");
        }
        
        // Testar consulta da bolsa
        System.out.println("\nInformações da bolsa:");
        System.out.println("Modalidade: " + bolsa.getModalidade());
        System.out.println("Valor: R$" + bolsa.getValor());
        System.out.println("Bolsista: " + (bolsa.getBolsista() != null ? bolsa.getBolsista().getNome() : "Ainda não selecionado"));

        // Testar projetos do aluno
        // ...
    }
}
