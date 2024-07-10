class Exercise {
	public static void main (String[] args){
		System.out.println("Hello World " + args[0]);
	}
}
/*
   Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
	at Atividades.Argument.main(Argument.java:5)
 */

class HelloWorld {
	public static void main (String[] args){
		System.out.println("Hello World");
	}
}

class SayHi {
    public static void main (String[] args){
        System.out.println("Say hi");
    }
}


class Error {
	public static void main (String[] args){
		System.out.println("Hello World");
	}
}

// retire a aspa e o ponto e vírgula = erro de sintaxe
//se o nome da classe esativer diferente do arquivo = erro de execução
//pois ao gerar o class, este vai ser com o nome da função
// public static void Main (String[] args){ = é uma método de uma classe, mas não é o ponto de entrada de java
//     var int cont; = erro de semântica, o java não reconhece o var
//     System.out.println("Você digitou: " + cont); = erro de semântica, pois a variável não foi acessada
// }
// System.out.println("Você digitou: " + 1/0); = erro de execução