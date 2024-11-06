package Atividades.Heranca.copy;

public class Vendedor extends Empregado {
    private double comissao;

    public Vendedor (String matricula, double salarioInicial, double comissao) {
        super(matricula, salarioInicial);
        this.comissao = comissao;
    }

    @Override
    public double getSalario () {
        return super.getSalario()+comissao;
    }

    public String toString() {
		return super.toString()+ " | Comissao: " + comissao;
	}
}
