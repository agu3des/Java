package Atividades.Heranca.copy;

import java.util.ArrayList;


//Considere a hierarquia Empregado-Vendedor-Gerente do diagrama, onde:
//• o método getSalario() calcula o salário em cada classe, da seguinte forma:
//		o O salário da classe Empregado é o próprio salario inicial.
//		o O salário da classe Vendedor é o salario de Empregado + comissao
//		o O salário da classe Gerente é o salario de Vendedor + gratificação
//• o método aumentarSalario(valor) adiciona valor ao salario inicial.
//Implemente as 3 classes do diagrama, incluindo construtores, getSalario(), aumentarSalario(),
//gets/sets e toString.
//Crie a aplicação Teste (main) para:
//1. Instanciar 3 objetos de cada classe (com dados de sua escolha)
//2. Criar a lista polimórfica denominada “empregados” e adicionar nesta lista os 9 objetos
//instanciados
//3. Aumentar em 100 reais (vale-transporte) o salário inicial de todos os objetos da lista, através
//da chamada aumentarSalario(100).
//4. Exibir todos os objetos da lista
//5. Exibir apenas os objetos Empregado
//6. Exibir apenas os objetos Gerente
//7. Obter o Marajá da lista (aquele empregado que possui o maior salario entre todos)
//8. Calcular a soma das gratificações

public class TesteEmpregados {
    public static void main(String[] args) {
        Empregado jose = new Empregado("111", 1400.90);
        Empregado maria = new Vendedor("222", 1380.90, 100);
        Empregado manoel = new Gerente("333", 1987.90, 100, 200);
        System.out.println(jose);
        System.out.println(maria);
        System.out.println(manoel);
        

        ArrayList<Empregado> empregados = new ArrayList<>();
		empregados.add( new Empregado("263", 1200.70) );
		empregados.add( new Empregado("548", 1500.50) );
		empregados.add( new Empregado("983", 1200.90) );
		empregados.add( new Vendedor("736", 1260.94, 100) );
		empregados.add( new Vendedor("312", 1160.93, 100) );
		empregados.add( new Vendedor("132", 1860.94, 100) );
		empregados.add( new Gerente("796", 1260.94, 100, 300) );
		empregados.add( new Gerente("475", 1980.90, 100, 300) );
		empregados.add( new Gerente("297", 1900.00, 100, 400) );
		System.out.println(empregados);
		
		for (Empregado e : empregados) {
			e.aumentarSalario(100); //aumentar o salario de e
		} System.out.println(empregados);
		
		for (Empregado e : empregados) {
			System.out.println(e);
		} 
		
		//mostrar os empregados
		for (Empregado e : empregados) {
			if(e.getClass().getSimpleName().equals("Empregado")) { 
				System.out.println("Empregados = "+ e);
			}
		}
	
		//mostrar os vendedores
		for (Empregado e : empregados) {
			if(e instanceof Vendedor) { 
				System.out.println("Vendedores = " + e);
			}
		}
		
		//mostrar os gerentes
		for (Empregado e : empregados) {
			if(e instanceof Gerente) { 
				System.out.println("Gerentes = "+ e);
			}
		}
		
		
		Empregado maraja = null;
		double salarioMax = 0;
		for (Empregado e : empregados) {
			if(e.getSalario() > salarioMax) {//casting implicito*
				salarioMax = e.getSalario();
				maraja = e;
			}
		} System.out.println("Marajá: "+ maraja);
		
		double soma = 0;
		for (Empregado e : empregados) {
			if (e instanceof Gerente g) {
				soma = soma + g.getGratificacao();
			}
		} System.out.println("Soma das gratificacoes: "+soma);

		
    }
}
