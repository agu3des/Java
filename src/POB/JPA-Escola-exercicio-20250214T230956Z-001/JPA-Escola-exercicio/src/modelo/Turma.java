import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Turma{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;		//chave primaria autoincrementado
	private String periodo;		
	
	//mapear relacionamento com mappedBy,  cascade PERSIST e MERGE e orphanremoval=true
	@OneToMany(mappedBy = "turma", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	private List<Aluno> alunos = new ArrayList <>();  

	
	public Turma()  {}
	public Turma(String periodo) {
		super();
		this.periodo = periodo;
	}

	
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String toString(){
		String s= "turma="+id + "," + periodo; 
				
    	if (!alunos.isEmpty()){
    		s=s+",  alunos:" ;
    		for(Aluno a : alunos) 
    			s=s+" " + a.getNome();
    	}
    	return s;
	}
	
	public int getId() {
		return id;
	}
	//------------------------------------------------------------------------
	//  LISTA DE ALUNOS
	//------------------------------------------------------------------------
	public void adicionar(Aluno alu)    {
		alunos.add(alu);
		alu.setTurma(this);
	}
	public void remover (Aluno alu) {
		alu.setTurma(null);
		alunos.remove(alu);
	} 
	
	public Aluno localizarAluno(String nome) {
		for(Aluno a: alunos)
			if(a.getNome().equals(nome)) return a; 
		return null;	
	}

	public List<Aluno> getAlunos()    {
		return alunos;
	}
	public int getTotalAlunos()    {
		return alunos.size();
	}

}
