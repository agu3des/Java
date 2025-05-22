package locadora;

public class ClassificacaoLancamento extends Classificacao {
    @Override
    int getCodigoDePreco() {
        return DVD.LANCAMENTO;
    }

    @Override
    double getValorDoAluguel(int diasAlugada) {
        return diasAlugada * 3;
    }

    @Override
    int getPontosDeAlugadorFrequente(int diasAlugada) {
        return (diasAlugada > 1) ? 2 : 1;
    }
}
