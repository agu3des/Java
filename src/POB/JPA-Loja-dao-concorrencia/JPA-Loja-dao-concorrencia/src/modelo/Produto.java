/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private double preco;
	private int estoque;

	@OneToMany(mappedBy="produto", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	List<Venda> vendas = new ArrayList<>();

	// **********************************************************
	@Version				//ativar controle de vers�o  do objeto
	private long versao;
	// **********************************************************


	public Produto() {}
	public Produto(String nome,  double preco, int estoque) {
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
	}

	public void adicionarVenda(Venda v) {
		vendas.add(v);
	}
	public void removerVenda(Venda v) {
		vendas.remove(v);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void baixarEstoque() {
		estoque = estoque - 1;
	}

	public String getNome() {
		return nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public int getEstoque() {
		return estoque;
	}

	public long getVersao() {
		return versao;
	}
	@Override
	public String toString() {
		return "id="+id+", nome=" + nome + ", estoque=" + estoque + " (versao=" + versao+")";
	}

}
