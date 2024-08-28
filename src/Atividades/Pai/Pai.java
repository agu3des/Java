package Atividades.Pai;

import java.util.ArrayList;

public class Pai {
	private String nome;
	private ArrayList<Filho> filhos = new ArrayList<>();
	
	public Pai(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Filho> getFilhos() {
		return filhos;
	}
	
	public void setFilhos(ArrayList<Filho> filhos) {
		this.filhos = filhos;
	}
	
	@Override
	public String toString() {
		return "Pai [nome=" + nome + "]";
	}

	public void adicionar(Filho f){
		filhos.add(f);
	}
	public void remover(Filho f){
		filhos.remove(f);
	}
	
	public Filho localizar(String nome) {
		for(Filho f: filhos) {
			if(f.getNome().equals(nome))
				return f;

	} return null;
	}
	
}
	
