
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Aluno{
	@Id
	private String matricula;		//chave primaria
    private String nome;
    private double media;
    private LocalDate dtcadastro = LocalDate.now();
    //mapear relacionamento com cascade PERSIST e MERGE
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Turma turma;		
        
    public Aluno()    {}
   
	public Aluno(String matricula, String nome, double media) {
		this.matricula = matricula;
		this.nome = nome;
		this.media = media;
	}

	public String getNome()    {
        return nome;
    }
    public double getMedia()    {
    	return media;
    }
    
	public String getMatricula() {
		return matricula;
	}

	public void setMedia(double media) {
		this.media = media;
	}
	
	public String toString(){
    	String s = "aluno="+ matricula + ", nome="+ getNome() + ", media=" + getMedia() +", dtcadastro="+dtcadastro;
    	if(turma != null)
    		s=s+", turma=" + getTurma().getPeriodo(); 
    	else
    		s=s+", ainda sem turma"; 
    	return s;
    }
	
    //---------- RELACIONAMENTO COM TURMA --------------------
    public Turma getTurma()    {
    	return turma;
    }
    public void setTurma(Turma t) {
    	turma = t;
    }   
  

}
