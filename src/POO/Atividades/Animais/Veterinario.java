package Atividades.Animais;

public class Veterinario {
	private String nome;
	
	public Veterinario (String nome) {
		this.nome = nome;
	}
	
	public String aplicarInjecao(Animal a) {
		return
			"Dr." + nome+
			" aplicou injeção em " + a.getNome()+
			"que fez " + a.emitirSom() ;
	
	}
}
