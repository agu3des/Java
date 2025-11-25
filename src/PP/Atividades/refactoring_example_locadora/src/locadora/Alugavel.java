package locadora;

public interface Alugavel {
    String getTitulo();
    double getValorDoAluguel(int diasAlugada);
    int getPontosDeAlugadorFrequente(int diasAlugada);
}
