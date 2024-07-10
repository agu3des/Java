package Triangulo;
//Exerc02

public class Triangulo {
	public int id;
	public double altura;
	public double base; 
	public double ladoA;
	public double ladoB;
	public double ladoC;

	public Triangulo(int id, double altura, double base, double ladoB, double ladoC) {
		this.id = id;
		this.altura = altura;
		this.base = base;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}

	public Triangulo() { 
		// id = 1;    valor que eu posso definir como default caso não receba nenhuma atribuição
		// altura = 1;
		// base = 1;
	}

	public double calcularArea() { 
		return altura * base/2;
	}

	public double pitagoras() {
		double b = Math.pow(ladoB,2);
		double c = Math.pow(ladoC,2);
		return ladoA = Math.sqrt(b+c);
	}

    public void redimensionar(double fatorDeRed) { 
        this.altura *= fatorDeRed;
        this.base*=fatorDeRed; 
    }

	public String toString() {
		return 
		"id = " + id +
		" | altura = " + altura + 
		" | base = " + base +
		" | lado A = " + ladoA +
		" | lado B = " + ladoB +
		" | lado B = " + ladoB;
	}
}

