package modelo;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */
public class Telefone {
	private String numero; 
	private Pessoa pessoa;
	
	public Telefone(String n){
		this.numero = n;
	}

	public void setPessoa(Pessoa p){
		this.pessoa = p;
	}

	
	public String getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "numero=" + numero + 
				", pessoa=" + (pessoa != null ? pessoa.getNome() : "") ;	
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
	
}
