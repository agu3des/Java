package Atividades.Animais;

public abstract class Animal {
	private String nome;
	private double peso;
	
	public Animal(String nome, double peso) {
		super();
		this.nome = nome;
		this.peso = peso;
	}
	public String getNome() {
		return nome;
	}
	public double getPeso() {
		return peso;
	}
	public abstract String emitirSom(); //{
		//return "nenhum som";
	//}
	public String toString() {
		return "Nome: "+nome+
				"  peso: "+peso+
				"  som: "+emitirSom();
	}
}
