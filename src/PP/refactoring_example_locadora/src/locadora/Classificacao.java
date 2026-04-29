package locadora;

public abstract class Classificacao {
    abstract int getCodigoDePreco();
    abstract double getValorDoAluguel(int diasAlugada);
    
    int getPontosDeAlugadorFrequente(int diasAlugada) {
        return 1;
    }
}

