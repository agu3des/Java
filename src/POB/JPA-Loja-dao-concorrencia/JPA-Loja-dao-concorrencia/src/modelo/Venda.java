/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Venda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String vendedor;
	private LocalDateTime datahora = LocalDateTime.now();

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch=FetchType.LAZY)
	private Produto produto;


	public Venda() {}
	public Venda(String vendedor, Produto produto) {
		this.vendedor = vendedor;
		this.produto = produto;
		produto.baixarEstoque();
		produto.adicionarVenda(this);
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getDatahora() {
		return datahora;
	}
	public String getDatahoraStr() {
		return datahora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}
	@Override
	public String toString() {
		return "Venda [id=" + id + ", vendedor=" + vendedor + ", produto=" + produto.getNome() + "]";
	}


}
