package Atividades.Heranca.copy;

public class Empregado {
    private String matricula;
    private double salarioInicial;

    public Empregado(String matricula, double salarioInicial) {
        this.matricula = matricula;
        this.salarioInicial = salarioInicial;
    }

    public double getSalario () {
        return salarioInicial;
    }

    public String getMatricula() {
        return matricula;
    }

    public void aumentarSalario(double aumento) {
        this.salarioInicial += aumento;
    }

    public String toString() {
		return "Categoria: " + getClass().getSimpleName() +" | Matricula: "+matricula+
				" | Salario: "+salarioInicial;
	}
}
