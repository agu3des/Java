package Atividades.Animais;

public class Passaro extends Animal {
	private boolean voar;
	
	public Passaro (String nome, double peso, boolean voar) {
		super(nome, peso);
		this.voar = voar;
	}
	@Override
	public String emitirSom() {
		return "piu piu";
	}
	public boolean getVoar() {
		return voar;
	}
	@Override
	public String toString() {
		return super.toString()+
				", voa: "+getVoar();
	}
}
