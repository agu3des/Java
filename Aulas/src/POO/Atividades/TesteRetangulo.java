package POO.Atividades;
public class TesteRetangulo {
	public static void main(String[] args) {
        Retangulo r = new Retangulo();
        r.id = 1;
        r.largura = 3;
        r.comprimento = 4;
        System.out.println(r.calcularArea()); //12.0
        r.largura = 1;
        r.comprimento = 7;
        System.out.println(r.calcularArea()); //7.0

        //construtor
		Retangulo r1 = new Retangulo(1, 3, 4);
		System.out.println("Area 1="+r1.calcularArea()); //12.0
		Retangulo r2 = new Retangulo();
		System.out.println("Area 2="+r2.calcularArea()); //0.0
		System.out.println("E quadrado?"+r1.ehQuadrado()); //
		System.out.println("Perimetro="+r1.calcularPerimetro()); //
		System.out.println("Diagonal="+r1.calcularDiagonal()); //
		System.out.println("Enquadrar="+r1.enquadrar()); // 
		System.out.println("E quadrado?"+r1.ehQuadrado()); //
        
	}
}