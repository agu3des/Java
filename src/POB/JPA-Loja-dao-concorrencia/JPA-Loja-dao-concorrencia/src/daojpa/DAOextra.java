
/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/


import java.lang.reflect.ParameterizedType;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


public abstract class DAOextra<T> implements DAOInterface<T> {
	protected static EntityManager manager;

	public DAOextra(){}

	public static void open(){
		manager = Util.conectarBanco();
	}

	public static void close(){
		Util.fecharBanco();
		manager=null;
	}

	@Override
	public void create(T obj){
		manager.persist(obj);
	}
	@Override
	public abstract T read(Object chave);		 //depende de cada dao

	@Override
	public T update(T obj){
		return manager.merge(obj);
	}
	@Override
	public void delete(T obj) {
		manager.remove(obj);
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<T> readAll(){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

		TypedQuery<T> query = manager.createQuery("select x from " + type.getSimpleName() + " x",type);
		return  query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> readAllPagination(int firstResult, int maxResults) {
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

		return manager.createQuery("select x from " + type.getSimpleName() + " x",type)
				.setFirstResult(firstResult - 1)
				.setMaxResults(maxResults)
				.getResultList();
	}


	//----------------------- TRANSA��O   ----------------------
	public static void begin(){
		if(!manager.getTransaction().isActive()) {
			manager.getTransaction().begin();
		}
	}
	public static void commit(){
		if(manager.getTransaction().isActive()){
			manager.getTransaction().commit();
		}
	}
	public static void rollback(){
		if(manager.getTransaction().isActive()) {
			manager.getTransaction().rollback();
		}
	}



	//------------EXTRAS-------------
	//	public void lockpessimista(T obj) {
	//		//usado somente no controle de concorrencia persimista
	//		manager.lock(obj, LockModeType.PESSIMISTIC_WRITE);
	//	}
	//	public void lockotimista(T obj) {
	//		//usado somente no controle de concorrencia otimista
	//		manager.lock(obj, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
	//	}
	//
	//  acesso direto a conex�o jdbc (nao usado)
	//	public static Connection getConnectionJdbc() {
	//		try {
	//			EntityManagerFactory factory = manager.getEntityManagerFactory();
	//			String driver = (String) factory.getProperties().get("jakarta.persistence.jdbc.driver");
	//			String url = (String)	factory.getProperties().get("jakarta.persistence.jdbc.url");
	//			String user = (String)	factory.getProperties().get("jakarta.persistence.jdbc.user");
	//			String pass = (String)	factory.getProperties().get("jakarta.persistence.jdbc.password");
	//			Class.forName(driver);
	//			return DriverManager.getConnection(url, user, pass);
	//		}
	//		catch (Exception ex) {
	//			return null;
	//		}
	//	}

}

