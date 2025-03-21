/**IFPB - Curso SI 
 * Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import java.lang.reflect.ParameterizedType;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public abstract class DAO<T> implements DAOInterface<T> {
	protected static EntityManager manager;

	public static void open(){
		manager = Util.conectarBanco();
	}	
	
	public static void close(){
		Util.fecharBanco();
	}

	public void create(T obj){
		manager.persist(obj);
	}

	public abstract T read(Object chave);

	public T update(T obj){
		return manager.merge(obj);
	}
	public void delete(T obj) {
		manager.remove(obj);
	}

	@SuppressWarnings("unchecked")
	public List<T> readAll(){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

		TypedQuery<T> query = manager.createQuery("select x from " + type.getSimpleName() + " x",type);
		return  query.getResultList();
	}


	//----------------------- TRANSA��O   ----------------------
	public static void begin(){
		if(!manager.getTransaction().isActive())
			manager.getTransaction().begin();
	}
	public static void commit(){
		if(manager.getTransaction().isActive()){
			manager.getTransaction().commit();
			manager.clear();		// ---- esvazia o cache de objetos, se habilitado----
		}
	}
	public static void rollback(){
		if(manager.getTransaction().isActive())
			manager.getTransaction().rollback();
	}


//	public void lock(T obj) {
//		//usado somente no controle de concorrencia persimista
//		manager.lock(obj,LockModeType.PESSIMISTIC_WRITE); 
//	}


}

