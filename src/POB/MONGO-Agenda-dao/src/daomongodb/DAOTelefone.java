/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */


import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Telefone;

public class DAOTelefone  extends DAO<Telefone>{
	public Telefone read (Object chave){
		try{
			String num = (String) chave;
			TypedQuery<Telefone> q = manager.createQuery("select t from Telefone t where t.numero= :x",Telefone.class);
			q.setParameter("x", num);
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	public List<Telefone> readAll(){
		TypedQuery<Telefone> q = manager.createQuery("select t from Telefone t order by t.id", Telefone.class);
		return  q.getResultList();
	}
	
	//--------------------------------------------
	//  consultas
	//--------------------------------------------

	public List<Telefone> readAll (String digitos){		
		TypedQuery<Telefone> q = manager.createQuery
				("select t from Telefone t where t.numero like '%"+ digitos +"%' order by t.numero",Telefone.class);
		return q.getResultList();
	}
}
