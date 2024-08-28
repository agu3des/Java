package Atividades.Pai;

public class Teste {

	public static void main(String[] args) {
		Pai pai = new Pai("Donald");
		pai.adicionar(new Filho("Zezinho", 6));
		pai.adicionar(new Filho("Huguinho", 7));
		pai.adicionar(new Filho("Luisinho", 5));
		System.out.println(pai);
		
		Filho zezinho;
		zezinho = pai.localizar("Zezinho");
		if(zezinho != null) {
			pai.remover(zezinho); } //remover relacionamento

		zezinho = pai.localizar("Zezinho");
		if(zezinho == null) {
			System.out.println("Zezinho foi removido"); }

	}

}
