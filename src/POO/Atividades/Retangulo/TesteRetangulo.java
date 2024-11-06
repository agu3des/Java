package Retangulo;
public class TesteRetangulo {
	public static void main(String[] args) {
        Retangulo r = new Retangulo();
        r.id = 1;
        r.largura = 3;
        r.comprimento = 4;
        System.out.println(r.calcularArea()); //12.0
        System.out.println(r); 
        r.largura = 1;
        r.comprimento = 7;
        System.out.println(r.calcularArea()); //7.0

        //construtor
		Retangulo r1 = new Retangulo(1, 3, 4);
		System.out.println("Area 1 = "+r1.calcularArea()); //12.0

		Retangulo r2 = new Retangulo();
		System.out.println("Area 2 = "+r2.calcularArea()); //0.0

		Retangulo r3 = new Retangulo(5);
		System.out.println("Area 3 = "+r3.calcularArea()); //25.0

		System.out.println("E quadrado? "+r1.ehQuadrado()); //
		System.out.println("Perimetro = "+r1.calcularPerimetro()); //
		System.out.println("Equivalente? "+r1.ehEquivalente(r2)); //
		System.out.println("Diagonal = "+r1.calcularDiagonal()); //

		r1.redimensionar(2); //
		System.out.println("Area 1 apos redimensionar = "+r1.calcularArea());

		r2.redimensionar(r1);
		System.out.println("Area 2 apos redimensionar = "+r2.calcularArea());

		r1.enquadrar(); //
		System.out.println("Area 1 apos enquadrar = "+r1.calcularArea()); //12.25
		
		System.out.println("Quadrado? "+r1.ehQuadrado()); // true
		System.out.println(r1); //chamada implicita do toString
	}
}