package Curso;
public class Variaveis{
    public static void main(String[] args) {
        //convenção java
        int idade = 19;
        String nome = "Ananda";
        String nomeDaGata = "Lila";
        String ano2024 = "2024";
        //aceito, mas não utilizado
        int _idade;
        int $idade;
        //não é convenção java
        String nome_da_gata;
        String NomeDaGata;
        //mudou o valor da variável
        idade = 80;
        System.out.println("Idade = "+idade);
        System.out.println("Nome = "+nome);
        System.out.println("Nome da gata = "+nomeDaGata);
        System.out.println("Ano = "+ano2024);

        System.out.println("Inteiros");
        byte idade1 = 20;
        short idade2 = 21;
        int idade3 = 22;
        long idade4 = 23;
        System.out.println("byte = "+idade1 +"\n" +"short = "+idade2 +"\n" +"int = "+idade3 +"\n" + "long = "+idade4);

        System.out.println("Ponto Flutuante");
        double valorPassagem = 2.90;
        float valorTomate = 3.95f;
        System.out.println("double = "+valorPassagem +"\n" +"float = "+valorTomate);
        
        System.out.println("Char");
        char o = 'o';
        char i = 'i';
        char interrogacao = 0x00E1;
        System.out.println(o+i); //resulta na soma dos valores da tabela ascii
        System.out.println(""+o+i); 
        System.out.println(""+o+i+interrogacao); 
        
        System.out.println("Boolean");
        boolean verdade = true;
        boolean falsidade = false;
        System.out.println("O valor de verdade é = "+verdade +"\n" +"O valor de falso é = "+falsidade);
        
        
        System.out.println("Curiosidade");
        int var1 = 214783647;
        int var2 = 1;
        System.out.println("A soma passando do limite é = "+var1+var2);
        //não dá erro
        //No momento que eu somo e vai para o limite ele fica negativo
        //-214783648
    }
}
