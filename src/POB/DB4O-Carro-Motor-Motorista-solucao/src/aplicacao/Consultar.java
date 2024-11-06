package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Carro;


public class Consultar {
	private ObjectContainer manager;

	public Consultar(){
		manager = Util.conectarBanco();
		consultar();
		Util.desconectar();
		
		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplicação");
	}

	public void consultar(){
		System.out.println("\n2---listar carros com motor de potencia >= 2.0 ordenados por potencia");
		Query q = manager.query();
		q.constrain(Carro.class);  
		q.descend("motor").descend("potencia").constrain(2.0).smaller().not();
		q.descend("motor").descend("potencia").orderDescending();
		List<Carro> resultados2 = q.execute();
		for(Carro c: resultados2)
			System.out.println(c);
		
	}
	
	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}

