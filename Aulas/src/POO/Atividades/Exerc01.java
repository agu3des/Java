/*Exercício de String
Uma prova objetiva tem 10 questões cujas respostas podem ser “a”, “b”, “c”, “d” ou “e”. Faça um programa para ler as respostas do
gabarito e as respostas da prova e calcular o número de acertos
Ex
Digite o gabarito com 10 caracteres:
aaeecbdbcd
Digite a resposta com 10 caracteres
aaeecccaad

Número de acertos: 6*/
package POO;

import java.util.Scanner;

public class Exerc01 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o gabarito:"); //para ficar mais entendível para o usuário
        String Gabarito = teclado.nextLine(); //passa para a próxima linha a leitura
        System.out.println("Digite a resposta do aluno:");
        String Resposta = teclado.nextLine();
        teclado.close(); //fecha o scanner
        int nota = 0; // Inicializar a variável nota
        String[] respGabarito = Gabarito.split(""); // define como um array de caractares
        String[] respAluno = Resposta.split("");
        int comprimentoMinimo = Math.min(respGabarito.length, respAluno.length); // Determinar o menor comprimento entre os arrays
        for (int i = 0; i < comprimentoMinimo; i++) { // Corrigir a condição do loop
            if (respGabarito[i].equals(respAluno[i])) // Comparar strings usando equals()
                nota++; //incrementa a nota caso esteja correta
        }
        System.out.println("A nota do aluno é: " + nota);
    }
}

//charAt manipulação letra a letra, converte para o char  -- a comparação é na forma de char