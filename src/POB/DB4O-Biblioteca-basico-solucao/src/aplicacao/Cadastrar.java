package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import com.db4o.ObjectContainer;

import modelo.Autor;
import modelo.Livro;


public class Cadastrar {
	private ObjectContainer manager;

	public Cadastrar(){
		manager = Util.conectarBanco();
		System.out.println("Cadastrando...");

		Autor joao,maria, paulo, antonio;
		Livro java, c, php;
		
		joao = new Autor("joao");
		maria = new Autor("maria");
		paulo = new Autor("paulo");
		antonio = new Autor("antonio");

		java = new Livro("java", 10, 2016);
		java.adicionar(joao);
		java.adicionar(maria);
		manager.store(java);;
		manager.commit();
		
		c = new Livro("c", 10, 2015);
		c.adicionar(joao);
		c.adicionar(paulo);
		manager.store(c);;
		manager.commit();
		
		php = new Livro("php", 10, 2016);
		php.adicionar(joao);
		php.adicionar(antonio);
		manager.store(php);;
		manager.commit();
		
		Util.desconectar();
		System.out.println("fim da aplicacao");
	}


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


