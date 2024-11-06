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
import modelo.Motor;


public class Deletar {
	private ObjectContainer manager;

	public Deletar(){
		manager = Util.conectarBanco();
		apagar();
		Util.desconectar();
		
		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplicação");
	}

	public void apagar(){
		//apagar o carro placa ??? mas não apagar motor e motorista
		Query q = manager.query();
		q.constrain(Carro.class);
		q.descend("placa").constrain("XYZ2222");
		
		List<Carro> resultado = q.execute();
		if(resultado.size()>0) {
			Carro carro = resultado.get(0);
			manager.delete(carro);		//classe Utili => oncascadeDelete(false)
			manager.commit();
			System.out.println("apagou carro");
		}
		else
			System.out.println("nao localizou a placa");

	}



	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

