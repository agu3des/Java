package locadora;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Aluguel> alugueis = new ArrayList<>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionaAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public String extrato() {
        final String fimDeLinha = System.getProperty("line.separator");
        StringBuilder resultado = new StringBuilder("Registro de Aluguéis de " + getNome() + fimDeLinha);

        for (Aluguel aluguel : alugueis) {
            resultado.append("\t")
                    .append(aluguel.getItemAlugado().getTitulo())
                    .append("\t R$ ")
                    .append(aluguel.valorDeUmAluguel())
                    .append(fimDeLinha);
        }

        resultado.append("Valor total pago: R$ ")
                .append(getValorTotal())
                .append(fimDeLinha);
        resultado.append("Você acumulou ")
                .append(getPontosTotaisDeAlugadorFrequente())
                .append(" pontos de alugador frequente");

        return resultado.toString();
    }

    public String extratoHTML() {
        final String fimDeLinha = System.getProperty("line.separator");
        StringBuilder resultado = new StringBuilder("<H1>Registro de Aluguéis de <EM>")
                .append(getNome())
                .append("</EM></H1><P>")
                .append(fimDeLinha);

        for (Aluguel aluguel : alugueis) {
            resultado.append(aluguel.getItemAlugado().getTitulo())
                    .append(": R$ ")
                    .append(aluguel.valorDeUmAluguel())
                    .append("<BR>")
                    .append(fimDeLinha);
        }

        resultado.append("<P>Valor total pago: <EM>R$ ")
                .append(getValorTotal())
                .append("</EM>")
                .append(fimDeLinha);
        resultado.append("<P>Você acumulou <EM>")
                .append(getPontosTotaisDeAlugadorFrequente())
                .append(" pontos</EM> de alugador frequente");

        return resultado.toString();
    }

    public double getValorTotal() {
        double total = 0.0;
        for (Aluguel aluguel : alugueis) {
            total += aluguel.valorDeUmAluguel();
        }
        return total;
    }

    public int getPontosTotaisDeAlugadorFrequente() {
        int total = 0;
        for (Aluguel aluguel : alugueis) {
            total += aluguel.getPontosDeAlugadorFrequente();
        }
        return total;
    }
}
