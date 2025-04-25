package locadora;

public class Aluguel {
    private DVD dvd;
    private int diasAlugado;

    public Aluguel(DVD dvd, int diasAlugado) {
        this.dvd = dvd;
        this.diasAlugado = diasAlugado;
    }

    public DVD getDVD() {
        return dvd;
    }

    public int getDiasAlugado() {
        return diasAlugado;
    }

    public double calcularValorDeAluguel() {
        double valorTotal = 0.0;

        switch (dvd.getCodigoDePreco()) {
            case DVD.NORMAL:
                valorTotal += 2.0;
                if (diasAlugado > 2) {
                    valorTotal += (diasAlugado - 2) * 1.5;
                }
                break;
            case DVD.LANÇAMENTO:
                valorTotal += diasAlugado * 3.00;
                break;
            case DVD.INFANTIL:
                valorTotal += 1.5;
                if (diasAlugado > 3) {
                    valorTotal += (diasAlugado - 3) * 1.5;
                }
                break;
        }

        return valorTotal;
    }

    public int calcularPontosDeAlugadorFrequente() {
        int pontos = 1;
        if (dvd.getCodigoDePreco() == DVD.LANÇAMENTO && diasAlugado > 1) {
            pontos++;
        }
        return pontos;
    }
}
