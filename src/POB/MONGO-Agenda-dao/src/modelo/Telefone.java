import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)  //obrigatorio para mongodb

public class Telefone {
	@Id		
	@GeneratedValue
	@Column(name="_id")		//nome obrigatorio no mongodb
	private String id;
	private String numero;	
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Pessoa pessoa;
	
	@Version
	private long version;
	
	public Telefone (){}
	public Telefone(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	//	--------------------RELACIONAMENTO--------------------------------
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	@Override
	public String toString() {
		return "Telefone [id=" + id + ", " + (numero != null ? "numero=" + numero + ", " : "")
				+ (pessoa != null ? "pessoa=" + pessoa.getNome() : "sem nome") + "]";
	}

	public boolean ehCelular() {
		return numero.startsWith("9");
	}
	public boolean ehFixo() {
		return numero.startsWith("3");
	}
	
}
