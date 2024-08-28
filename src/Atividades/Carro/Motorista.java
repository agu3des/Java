package Atividades.Carro;

public class Motorista {
	private String cnh;
	
	public Motorista(String cnh) {
		this.cnh = cnh;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	@Override
	public String toString() {
		return "Motorista: [cnh=" + cnh + "]";
	}
}