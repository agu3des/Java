package locadora;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Aluguel> dvdsAlugados = new ArrayList<Aluguel>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionaAluguel(Aluguel aluguel) {
        dvdsAlugados.add(aluguel);
    }

    public String extrato() {
        final String fimDeLinha = System.getProperty("line.separator");
        String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;

        for (Aluguel aluguel : dvdsAlugados) {
            resultado += "\t" + aluguel.getDVD().getTitulo() + "\t R$ " + aluguel.calcularValorDeAluguel() + fimDeLinha;
        }

        resultado += "Valor total pago: R$ " + getValorTotal() + fimDeLinha;
        resultado += "Voce acumulou " + getPontosTotaisDeAlugadorFrequente() + " pontos de alugador frequente";

        return resultado;
    }

    public double getValorTotal() {
        double total = 0.0;
        for (Aluguel aluguel : dvdsAlugados) {
            total += aluguel.calcularValorDeAluguel();
        }
        return total;
    }

    public int getPontosTotaisDeAlugadorFrequente() {
        int total = 0;
        for (Aluguel aluguel : dvdsAlugados) {
            total += aluguel.calcularPontosDeAlugadorFrequente();
        }
        return total;
    }
}
