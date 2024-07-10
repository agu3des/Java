import java.util.Scanner;

class Condicao {
	public static void main(String[] args) {
		String n = "ana";
		String d = "ANA";
		if (n.equals(d))
			System.out.println("igual");
		else
			System.out.println("diferente"); //ok
		if (n.equalsIgnoreCase(d))
			System.out.println("igual"); //ok
		else
			System.out.println("diferente");
	}
}



class IMC {
    public static void main(String[] args) {
        double peso = 150;
        double altura = 1.70;
        double imc = peso / Math.pow(altura, 2);
        if (imc < 18.5)
            System.out.println("abaixo do normal");
        else 
            if (imc < 25)
                System.out.println("normal");
            else 
                if (imc < 30)
                    System.out.println("acima do normal");
                else 
                    if (imc < 35)
                        System.out.println("obesidade 1");
                    else 
                        if (imc < 40)
                            System.out.println("obesidade 2");
                        else
                            System.out.println("morbidade");
    }
}

class CalculadoraIMC {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double peso = 0;
        double altura = 0;
        try {
            // ler peso e altura como string e converter para double
            peso = Double.parseDouble(teclado.nextLine());
            altura = Double.parseDouble(teclado.nextLine());
        } catch (Exception e) {
            System.out.println("formato do numero incorreto");
            System.exit(0); // termina programa
        }
        double imc = peso / Math.pow(altura, 2);
    }
}
