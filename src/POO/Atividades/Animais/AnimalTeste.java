package Atividades.Animais;

import java.util.ArrayList;

public class AnimalTeste {
	public static void main(String[] args) {
		
		/*
		//instanciar os objetos
		Gato fifi = new Gato("fifi", 5, 3);
		Cachorro rex = new Cachorro("rex", 15);
		Passaro lolo = new Passaro("lolo", 2, true);
		//exibir nome, peso e som dos objetos com toString()
		System.out.println(rex); //”rex 15 au au”
		System.out.println(fifi); //”fifi 5 miau”
		System.out.println(lolo); //”lolo 2 piu piu true”
		
		
		Animal a; //variavel polimorfica
		a = new Gato("fofo", 6, 2); //ok
		System.out.println(a.emitirSom()); //”miau”
		a = new Cachorro("rio", 19); //ok
		System.out.println(a.emitirSom()); //”au au”
		a = new Passaro("vei", 4, false); //ok
		System.out.println(a.emitirSom()); //”piu piu”
		
		Veterinario bob = new Veterinario("Bob");
		System.out.println( bob.aplicarInjecao(fifi) ) ;
		System.out.println( bob.aplicarInjecao(rex) ) ;
		System.out.println( bob.aplicarInjecao(lolo) ) ;
		*/
		
		ArrayList<Animal> animais = new ArrayList<>();
		
		animais.add( new Cachorro("rex", 7) );
		animais.add( new Gato("fifi",3, 5) );
		animais.add( new Passaro("lolo", 2, true) );
		animais.add( new Cachorro("lessy", 4) );
		animais.add( new Gato("nino", 6, 2) );
		animais.add( new Passaro("vei", 4, false) );
		
		for (Animal a : animais){
			System.out.println( a );
		}
		
		double maxpeso = 0;
		Animal maispesado = null;
		
		for (Animal a : animais)
			if(a.getPeso() >= maxpeso){
				maxpeso = a.getPeso();
				maispesado = a;
			}
		System.out.println( "Mais pesado: " + maispesado );

	
	
		double minpeso = 3;
		Animal maisleve = null;
		
		for (Animal a : animais)
			if(a.getPeso() <= minpeso){
				minpeso = a.getPeso();
				maisleve = a;
			}
		System.out.println( "Mais leve: " + maisleve );
	
		System.out.println( "Lista de Animais: " + animais ); 
		
		int cont = 0;
		for (Animal a : animais) {
			if(a instanceof Gato) { //instanceof = a.getClass().getName().equals("Gato")
				cont++;
			}
		}
		System.out.println( "Quantidade de gatos: " + cont ); //2
	
		int count = 0; 
		for (Animal a : animais) {
			if(a instanceof Cachorro) { //instanceof = a.getClass().getName().equals("Gato")
				count++;
			}
		}
		System.out.println( "Quantidade de cachorros: " + count ); //2
	
		
		//Animal a2 = new Cachorro("lis",6);
		//Gato g2 = (Gato) a2; //dá erro
		
		/* casting implicito
		ArrayList<Gato> gatos = new ArrayList<>();
		for (Animal a : animais){
			if(a instanceof Gato g) //casting implicito*
				gatos.add(g);
		}
		System.out.println( "Lista de Gatos: " + gatos ); // [fifi,nino]
	
		ArrayList<Gato> saltadores = new ArrayList<>();
		for (Animal a : animais){
			if(a instanceof Gato g && g.getSalto()>= 5)
				saltadores.add(g);
		}
		System.out.println( saltadores ); // [fifi]
		*/
		
		ArrayList<Gato> saltadores = new ArrayList<>();
		for (Animal a : animais){
			if(a instanceof Gato && ((Gato)a).getSalto()>= 5) //o ponto tem mais prioridade que o parenteses então tem que adicionar mais um parenteses
				saltadores.add((Gato)(a));
		}
		System.out.println( saltadores ); // [fifi]
	
		
		ArrayList<Cachorro> cachorros = new ArrayList<>();
		for (Animal a : animais){
			if(a instanceof Cachorro c) //casting implicito*
				cachorros.add(c);
		}
		System.out.println( "Lista de Cachorros: " + cachorros ); // [fifi,nino]
	
		Gato primeiroGato = null;
		for (Animal a : animais) {
			if(a instanceof Gato g) {//casting implicito*
				primeiroGato = g;
				break;
			}
		}
		System.out.println( "Primeiro Gato: " + primeiroGato ); // [fifi,nino]
	
	
	}
}

