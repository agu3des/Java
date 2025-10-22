import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

import daomongodb.DAOPessoa;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;

@Entity 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)	//Obrigatorio para mongodb (heran�a)
@EntityListeners(DAOPessoa.class)  		//trigger de objeto

@NoSql(dataFormat=DataFormatType.MAPPED)  //obrigatorio para mongodb
public class Pessoa {
	@Id		
	@GeneratedValue				//gera��o default do banco
	@Column(name="_id")			//obrigatorio no mongodb
	private String id;			//obrigatorio para mongodb
	private String nome;
	
	private String dtnascimento ;		//nao suporta LocalDate

	@Lob
	private byte[] foto;
	
	@ElementCollection
	private List<String> apelidos = new ArrayList<>();

	@OneToMany(	mappedBy="pessoa", 
			cascade= {CascadeType.PERSIST, CascadeType.MERGE}, 
			orphanRemoval=true,    //ignorado !!
			fetch=FetchType.LAZY)  //LAZY � obrigatorio no mongodb
	private List<Telefone> telefones = new ArrayList<>();

	@Version
	private long version;
	
	@Transient
	private int idade;
	
	public Pessoa (){} //construtor vazio
	public Pessoa(String nome) {
		this.nome = nome;
	}

	public String getDtNascimento() {
		return dtnascimento;
	}
	public void setDtNascimento(String dt) {
		this.dtnascimento = dt;
	}
	
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void adicionar(Telefone t){
		telefones.add(t);
		t.setPessoa(this);
	}
	public void remover(Telefone t){
		telefones.remove(t);
		t.setPessoa(null);
	}
	public Telefone localizar(String numero){
		for(Telefone t : telefones)
			if(t.getNumero().equals(numero)) 
				return t;

		return null;			
	}
	
	public void adicionar(String ap){
		this.apelidos.add(ap);
	}
	
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<String> getApelidos() {
		return apelidos;
	}
	public void setApelidos(String[] array){
		this.apelidos = new ArrayList<>(Arrays.asList(array));
	}

	public String toString() {
		String texto = "";
		texto += " id="+id + ", nome=" + nome + 
				", dtnascimento=" + dtnascimento +
				", idade calculada=" + idade;
		
		texto += ", apelidos: ";
		if (apelidos !=null)
			for(String a : apelidos)
				texto+= a + ",";
		
		texto += " telefones: ";
		for(Telefone t : telefones)
			texto+= t.getNumero() + ",";
		
		return texto;
	}
	


}
