package modelo;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

import java.util.ArrayList;
import java.util.List;

public class Livro  {
	private String titulo;
	private int exemplares;
	private int ano;
	private List<Autor> autores = new ArrayList<>();
	
	public Livro(String titulo, int quant, int ano) {
		this.titulo = titulo;
		this.exemplares = quant;
		this.ano = ano;
	}

	public void adicionar(Autor a){
		autores.add(a);
		a.adicionar(this);
	}
	public void remover(Autor a){
		autores.remove(a);
		a.remover(this);
	}

	public Autor localizar(String nome){
		for(Autor a : autores){
			if(a.getNome().equals(nome))
				return a;
		}
		return null;
	}

	public int getTotalAutores(){
		return autores.size();
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getExemplares() {
		return exemplares;
	}

	public void setExemplares(int quant) {
		this.exemplares = quant;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	@Override
	public String toString() {
		String texto = " titulo:" + String.format("%8s", titulo) + ", exemplares: " + exemplares + ", ano: " + ano + ", autores:";
		if (autores.isEmpty())
			texto += "Sem autores";
		else 	
			for(Autor a: autores) 
				texto += a.getNome() + ", " ; 


		return texto ;
	}

	
	
}