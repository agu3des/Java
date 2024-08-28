package Atividades.Heranca.copy;

public class Gerente extends Vendedor {
    private double gratificacao;

    public Gerente (String matricula, double salarioInicial, double comissao, double gratificacao) {
        super(matricula, salarioInicial, comissao);
        this.gratificacao = gratificacao;
    }

    @Override
    public double getSalario () {
        return super.getSalario()+gratificacao;
    }
    
    public double getGratificacao() {
    	return gratificacao;
    }

    public String toString() {
		return super.toString()+ " | Gratificação: " + gratificacao;
	}
}
