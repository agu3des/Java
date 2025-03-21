/**
 * IFPB - TSI - PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Util {
	private static EntityManager manager;
	private static EntityManagerFactory factory;

	
	public static EntityManager conectarBanco(){
		if(manager == null) {
			factory = Persistence.createEntityManagerFactory("hibernate-postgresql");
			manager = factory.createEntityManager();
		}
		return manager;
	}

	public static void fecharBanco(){
		if(manager != null && manager.isOpen()) {
			manager.close();
			factory.close();
			manager=null;
		}
	}
}
