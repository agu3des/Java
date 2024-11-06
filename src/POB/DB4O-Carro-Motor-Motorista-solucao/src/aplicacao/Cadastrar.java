package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import com.db4o.ObjectContainer;

import modelo.Carro;
import modelo.Motor;
import modelo.Motorista;


public class Cadastrar {
	private ObjectContainer manager;

	public Cadastrar(){
		manager = Util.conectarBanco();
		cadastrar();
		Util.desconectar();
		
		System.out.println("fim da aplicacao");
	}


	public void cadastrar(){
		System.out.println("cadastrando...");
		
		Motorista joao = new Motorista("1234", "joao");
		
		Carro carro1 = new Carro("ABC1111", new Motor("zetec",1.0), joao);
		Carro carro2 = new Carro("XYZ2222", new Motor("turbo",2.0), joao);

		manager.store(carro1);
		manager.commit();
		
		manager.store(carro2);
		manager.commit();
		
		System.out.println("cadastrou.");
	}	


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


