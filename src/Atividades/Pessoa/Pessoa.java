package Atividades.Pessoa;

import java.util.ArrayList;

import Atividades.Pai.Filho;

public class Pessoa {
	
	private String nome;
	private Pessoa conjugue;
	private ArrayList<Pessoa> amigos = new ArrayList<>();
	
	public Pessoa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Pessoa getConjugue() {
		return conjugue;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setConjugue(Pessoa conjugue) {
		this.conjugue = conjugue;
	}
	
	public void adicionar(Pessoa p) {
		amigos.add(p);
	}
	
	public void remover(Pessoa p) {
		amigos.remove(p);
	}
	
	public Pessoa localizar(String nome) {
		for(Pessoa p: amigos) {
			if(p.getNome().equals(nome))
				return p;
		} return null;
	}
	
	@Override
	public String toString() {
		String amizades = "";
		for (Pessoa a : amigos) {
			amizades += " " + a.getNome();
		}
		
		if (conjugue == null) {
			return "Pessoa [nome= " + nome +"]";
		} 
		return "Pessoa [nome= " + nome + ", conjugue= " + conjugue.getNome() + ", amigos=" + amizades +"]";
	}
}
