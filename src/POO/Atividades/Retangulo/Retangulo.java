import String;

package Retangulo;
public class Retangulo {
	public int id; // identificar qual o objeto
	public double largura; // atributo
	public double comprimento; //outra classe pode acessar esses dados
				//ao finalizar o uso os parâmetros que estão aqui somem
	public Retangulo(int id, double largura, double comprimento) { //meu construtor
		this.id = id;
		this.largura = largura;
		this.comprimento = comprimento; //pode ter vários construtores todos com o mesmo nome da casse
	}

	public Retangulo() {  //construtor vazio, só cria o objeto
		// id = 1;    valor que eu posso definir como default caso não receba nenhuma atribuição
		// largura = 1;
		// comprimento = 1;
	}

	public Retangulo(double lado) { //construtor com apenas um argumento
		this.largura = lado;
		this.comprimento = lado; 
	}

	public double calcularArea() { // método
		return largura * comprimento;
	}

	public double calcularPerimetro() {
		return largura * 2 + comprimento * 2;
	}

	public double calcularDiagonal() {
		double comprimentoQ = Math.pow(comprimento, 2);
		double larguraQ = Math.pow(largura, 2);
		return Math.sqrt(comprimentoQ + larguraQ);
	}

	public void enquadrar() {
		double media = (comprimento + largura)/2; //para deixa de forma igual e não trazer ao usuário o questionamento
		comprimento = media;
		largura = media;
	}

    public void redimensionar(double fatorDeRed) { //void pq não retorna nada
        this.largura *= fatorDeRed;
        this.comprimento*=fatorDeRed; 
    }

	public void redimensionar(Retangulo objeto) { //posso ter um objeto como parametro
		largura = objeto.largura; //sobrecarga
		comprimento = objeto.comprimento;
	}

    public boolean ehQuadrado() {
        return (largura == comprimento);
    }

	public boolean ehEquivalente(Retangulo outro) {
		return (this.calcularArea() == outro.calcularArea());
	}//tem que colocar os dois pq se não ele entende como o mesmo

	public String toString() {
		return 
		"id = " + id +
		" | largura = " + largura + 
		" | comprimento = " + comprimento;
	}
}

