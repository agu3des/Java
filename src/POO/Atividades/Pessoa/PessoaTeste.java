package Atividades.Pessoa;

public class PessoaTeste {

	public static void main(String[] args) {
		Pessoa maria = new Pessoa("maria");
		Pessoa joao = new Pessoa("joao");
		
		System.out.println(maria);
		
		maria.setConjugue(joao);
		joao.setConjugue(maria);
		
		System.out.println(maria);
		System.out.println(joao);

		Pessoa jose = new Pessoa("jose");
		maria.setConjugue(jose);
		
		System.out.println("Após alterações:");
		System.out.println(maria);
		System.out.println(joao);
		
		Pessoa ana = new Pessoa("ana");
		Pessoa benedita = new Pessoa("benedita");
		Pessoa marcos = new Pessoa("marcos");
		
		maria.adicionar(benedita);
		maria.adicionar(ana);
		joao.adicionar(marcos);
		
		System.out.println(maria);
		System.out.println(joao);
	}

}
