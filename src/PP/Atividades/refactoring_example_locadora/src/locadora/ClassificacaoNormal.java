package locadora;

public class ClassificacaoNormal extends Classificacao {
    @Override
    int getCodigoDePreco() {
        return DVD.NORMAL;
    }

    @Override
    double getValorDoAluguel(int diasAlugada) {
        double valor = 2;
        if (diasAlugada > 2) {
            valor += (diasAlugada - 2) * 1.5;
        }
        return valor;
    }
}

