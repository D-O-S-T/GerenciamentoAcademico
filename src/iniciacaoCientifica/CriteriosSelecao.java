package iniciacaoCientifica;

public class CriteriosSelecao {

    private double coeficienteRendimentoMinimo;

    public CriteriosSelecao(double coeficienteRendimentoMinimo) {
        this.coeficienteRendimentoMinimo = coeficienteRendimentoMinimo;
    }

    public boolean isAlunoSelecionado(Aluno aluno) {
        return aluno.getCoeficienteRendimento() >= coeficienteRendimentoMinimo;
    }
}
