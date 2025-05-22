package locadora;

public class DVD implements Alugavel {
    public static final int NORMAL = 0;
    public static final int LANCAMENTO = 1;
    public static final int INFANTIL = 2;

    private String titulo;
    private Classificacao classificacao;

    public DVD(String titulo, int codigoDePreco) {
        this.titulo = titulo;
        setCodigoDePreco(codigoDePreco);
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCodigoDePreco() {
        return classificacao.getCodigoDePreco();
    }

    public void setCodigoDePreco(int codigoDePreco) {
        switch (codigoDePreco) {
            case NORMAL:
                classificacao = new ClassificacaoNormal();
                break;
            case LANCAMENTO:
                classificacao = new ClassificacaoLancamento();
                break;
            case INFANTIL:
                classificacao = new ClassificacaoInfantil();
                break;
            default:
                throw new IllegalArgumentException("Código de preço inválido");
        }
    }

    @Override
    public double getValorDoAluguel(int diasAlugada) {
        return classificacao.getValorDoAluguel(diasAlugada);
    }

    @Override
    public int getPontosDeAlugadorFrequente(int diasAlugada) {
        return classificacao.getPontosDeAlugadorFrequente(diasAlugada);
    }
}
