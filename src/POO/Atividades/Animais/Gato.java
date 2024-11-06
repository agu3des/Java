package Atividades.Animais;

public class Gato extends Animal {
	private int salto;
	
	public Gato (String nome, double peso, int salto) {
		super(nome, peso);
		this.salto = salto;
	}
	@Override
	public String emitirSom() {
		return "miau miau";
	}
	public int getSalto() {
		return salto;
	}
	@Override
	public String toString() {
		return super.toString()+
				", saltos: "+getSalto();
	}
}
