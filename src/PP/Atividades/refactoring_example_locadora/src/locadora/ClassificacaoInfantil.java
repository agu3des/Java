package locadora;

public class ClassificacaoInfantil extends Classificacao {
    @Override
    int getCodigoDePreco() {
        return DVD.INFANTIL;
    }

    @Override
    double getValorDoAluguel(int diasAlugada) {
        double valor = 1.5;
        if (diasAlugada > 3) {
            valor += (diasAlugada - 3) * 1.5;
        }
        return valor;
    }
}

