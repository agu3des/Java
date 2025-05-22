package locadora;

public class Aluguel {
    private Alugavel itemAlugado;
    private int diasAlugada;

    public Aluguel(Alugavel itemAlugado, int diasAlugada) {
        this.itemAlugado = itemAlugado;
        this.diasAlugada = diasAlugada;
    }

    public Alugavel getItemAlugado() {
        return itemAlugado;
    }

    public int getDiasAlugada() {
        return diasAlugada;
    }

    public double valorDeUmAluguel() {
        return itemAlugado.getValorDoAluguel(diasAlugada);
    }

    public int getPontosDeAlugadorFrequente() {
        return itemAlugado.getPontosDeAlugadorFrequente(diasAlugada);
    }
}

