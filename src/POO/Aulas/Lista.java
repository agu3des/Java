import java.util.ArrayList;
import java.util.Collections;
//import java.util.LinkedList;
import java.util.List;

public class Lista{
	public static void main(String args[]){
		//ArrayList<Integer> lista = new ArrayList<>();
		ArrayList<Integer> lista = new ArrayList<>(List.of(4,3,6));
		//LinkedList<Integer> lista = new LinkedList<>(List.of(4,3,6));
		lista.add(8);
		lista.add(2);
		lista.add(9);
		lista.add(2);
		System.out.println(lista.size());
		System.out.println(lista.get(0));
		System.out.println(lista.get(3));
		System.out.println(lista);
		lista.remove(0);
		lista.set(1, 999);
		System.out.println(lista);
		
		
		for(int i=0; i < lista.size(); i++)
			System.out.println(lista.get(i));
		for(int n : lista)
			System.out.println(n);
		lista.forEach(System.out::println);//print em todos
		
		
		ArrayList<String> pais = new ArrayList<>();
		pais.add("joao");
		pais.add("maria");
		ArrayList<String> filhos = new ArrayList<>(); //não armazena o objeto e sim a referência para o objeto
		filhos.add("pedro");
		filhos.add("paulo");
		ArrayList<String> familia = new ArrayList<>();
		familia.addAll(pais) ; //copia as referências --> não são cópias, tem "dois ponteiros" para a mesma coisa
		familia.addAll(filhos) ; //copia as referências
		System.out.println(familia); //ao se unir listas o mesmo elemento pode estar em índices diferentes
        //demonstração de que ao se unir, o mesmo objeto está em duas posições diferentes
        String indice1 = filhos.get(0);
		String indice2 = familia.get(2);
		System.out.println(indice1 + indice2); 
        pais.clear();
        filhos.clear(); //aapaga apenas o "ponteiro"
        System.out.println(pais);
        System.out.println(filhos);
        //a lista família continua intacta, pois as ref dela continuam intactas
        System.out.println(familia);
        familia.removeIf(e -> e.contains("jo")); //onde tiver jo ele remove, contains é de string
        //ou seja, ele percorre tudo, quando der true ele remove
        Collections.shuffle(familia); //embaralha
        System.out.println(familia);
        Collections.sort(familia); //ordena por quickSort
        System.out.println(familia);
        System.out.println(familia.get(5)); //aborta
        familia.remove(5); //aborta
    }
}