/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

package aplicacao;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

import modelo.Aluno;
import modelo.Pessoa;
import modelo.Telefone;

public class Util {
	private static ObjectContainer manager;

	public static ObjectContainer conectarBanco(){
		if (manager != null)
			return manager;		//ja tem uma conexao

		//---------------------------------------------------------------
		//configurar, criar e abrir banco local (pasta do projeto)
		//---------------------------------------------------------------
		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
		config.common().messageLevel(0);  // mensagens na tela 0(desliga),1,2,3...
		
		// habilitar cascata para alterar, apagar e recuperar objetos
		config.common().objectClass(Pessoa.class).cascadeOnDelete(true);;
		config.common().objectClass(Pessoa.class).cascadeOnUpdate(true);;
		config.common().objectClass(Pessoa.class).cascadeOnActivate(true);
		config.common().objectClass(Aluno.class).cascadeOnDelete(true);;
		config.common().objectClass(Aluno.class).cascadeOnUpdate(true);;
		config.common().objectClass(Aluno.class).cascadeOnActivate(true);
		config.common().objectClass(Telefone.class).cascadeOnDelete(true);;
		config.common().objectClass(Telefone.class).cascadeOnUpdate(true);;
		config.common().objectClass(Telefone.class).cascadeOnActivate(true);		
		
		//conexao local
		manager = Db4oEmbedded.openFile(config, "banco.db4o");
		return manager;
	}
	
	public static void desconectar() {
		if(manager!=null) {
			manager.close();
			manager=null;
		}
	}
}
