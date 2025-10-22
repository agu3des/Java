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


public class Alterar {
	private ObjectContainer manager;

	public Alterar(){
		manager = Util.conectarBanco();
		alterarPotencia();
		Util.desconectar();

		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplicação");
	}

	public void alterarPotencia(){
		//alterar a potencia do motor do carro de placa ???? 
		Query q = manager.query();
		q.constrain(Carro.class);
		q.descend("placa").constrain("ABC1111");
		
		List<Carro> resultado = q.execute();
		if(resultado.size()>0) {
			Carro carro = resultado.get(0);
			carro.getMotor().setPotencia(1.4);
			manager.store(carro);
			manager.commit();
			System.out.println("potencia alterada");
		}
		else
			System.out.println("nao localizou a placa");
		
		
	}



	//=================================================
	public static void main(String[] args) {
		new Alterar();
	}
}

