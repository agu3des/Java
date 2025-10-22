import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import DAO;
import DAOPessoa;
import DAOTelefone;
import jakarta.persistence.OptimisticLockException;
import modelo.Pessoa;
import modelo.Telefone;

public class Fachada {
	private static DAOPessoa daopessoa = new DAOPessoa();
	private static DAOTelefone daotelefone = new DAOTelefone();

	private static DateTimeFormatter formatadorDT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void inicializar() {
		DAO.open();
	}

	public static void finalizar() {
		DAO.close();
	}

	public static Pessoa localizarPessoa(String nome) throws Exception {
		Pessoa p = daopessoa.read(nome);
		if (p == null) {
			throw new Exception("nome inexistente:" + nome);
		}
		return p;
	}

	public static void  criarPessoa(String nome, String data, byte[] bytesfoto, String[] apelidos) throws Exception {
		DAO.begin();
		try {
			LocalDate.parse(data, formatadorDT);
		} catch (DateTimeParseException e) {
			DAO.rollback();
			throw new Exception("formato data invalido:" + data);
		}

		Pessoa p = daopessoa.read(nome);
		if (p != null) {
			DAO.rollback();
			throw new Exception("criar pessoa - nome ja existe:" + nome);
		}

		p = new Pessoa(nome);
		if (bytesfoto != null)
			p.setFoto(bytesfoto);
		if (apelidos != null)
			p.setApelidos(apelidos);
		p.setDtNascimento(data);
		daopessoa.create(p);
		DAO.commit();
	}

	public static void alterarPessoa(String nome, String data, byte[] bytesfoto, String[] apelidos) throws Exception {
		// permite alterar data, foto e apelidos
		DAO.begin();
		Pessoa p = daopessoa.read(nome);
		if (p == null) {
			DAO.rollback();
			throw new Exception("alterar pessoa - pessoa inexistente:" + nome);
		}

		p.setFoto(bytesfoto);
		p.setApelidos(apelidos);
		if (data != null) {
			try {
				LocalDate.parse(data, formatadorDT);
				p.setDtNascimento(data);
			} catch (DateTimeParseException e) {
				DAO.rollback();
				throw new Exception("alterar pessoa - formato data invalido:" + data);
			}
		}

		daopessoa.update(p);

		DAO.commit();
	}

	public static void excluirPessoa(String nome) throws Exception {
		DAO.begin();
		Pessoa p = daopessoa.read(nome);
		if (p == null) {
			DAO.rollback();
			throw new Exception("excluir pessoa - nome inexistente:" + nome);
		}

		// desligar a pessoa de seus telefones (orfaos) e apaga-los do banco
		for (Telefone t : p.getTelefones()) {
			t.setPessoa(null);
			daotelefone.update(t);
			daotelefone.delete(t); // deletar o telefone orfao
		}

		daopessoa.delete(p); // apagar a pessoa
		DAO.commit();
	}

	public static void alterarNome(String nome, String novonome) throws Exception {
		DAO.begin();
		Pessoa p = daopessoa.read(nome); // usando chave primaria
		if (p == null) {
			DAO.rollback();
			throw new Exception("alterar nome - nome inexistente:" + nome);
		}
		p.setNome(novonome);
		p = daopessoa.update(p);
		DAO.commit();
	}

	public static void criarTelefone(String nome, String numero) throws Exception {
		DAO.begin();
		Pessoa p = daopessoa.read(nome);
		if (p == null) {
			DAO.rollback();
			throw new Exception("criar telefone - nome inexistente" + nome + numero);
		}
		Telefone t = daotelefone.read(numero);
		if (t != null) {
			DAO.rollback();
			throw new Exception("criar telefone - numero ja cadastrado:" + numero);
		}
		if (numero.isEmpty()) {
			DAO.rollback();
			throw new Exception("criar telefone - numero vazio:" + numero);
		}

		t = new Telefone(numero);
		p.adicionar(t);
		daopessoa.update(p);

		Thread.sleep(2000);

		try {
			DAO.commit();
		} 
		catch (Exception e) {
			if (e.getCause() instanceof OptimisticLockException)
				throw new Exception("transa��o cancelada  - tente outra vez ");
			else
				throw e;
		}

	}

	public static void excluirTelefone(String numero) throws Exception {
		DAO.begin();
		Telefone t = daotelefone.read(numero);
		if (t == null) {
			DAO.rollback();
			throw new Exception("excluir telefone - numero inexistente:" + numero);
		}
		daotelefone.delete(t);
		DAO.commit();
	}

	public static Telefone alterarTelefone(String numero, String novonumero) throws Exception {
		DAO.begin();
		Telefone t1 = daotelefone.read(numero);
		if (t1 == null) {
			DAO.rollback();
			throw new Exception("alterar telefone - numero inexistente:" + numero);
		}
		Telefone t2 = daotelefone.read(novonumero);
		if (t2 != null) {
			DAO.rollback();
			throw new Exception("alterar telefone - novo numero ja existe:" + novonumero);
		}
		if (novonumero.isEmpty()) {
			DAO.rollback();
			throw new Exception("alterar telefone - novo numero vazio:");
		}

		t1.setNumero(novonumero); // substituir
		t1 = daotelefone.update(t1);
		DAO.commit();
		return t1;
	}

	public static List<Pessoa> listarPessoas() {
		DAO.begin();
		List<Pessoa> result = daopessoa.readAll();
		DAO.commit();
		return result;
	}

	public static List<Telefone> listarTelefones() {
		DAO.begin();
		List<Telefone> result = daotelefone.readAll();
		DAO.commit();
		return result;
	}

	/**********************************************************
	 * 
	 * CONSULTAS IMPLEMENTADAS NOS DAO
	 * 
	 **********************************************************/

	public static List<Pessoa> consultarPessoas(String caracteres) {
		List<Pessoa> result;
		DAO.begin();
		if (caracteres.isEmpty())
			result = daopessoa.readAll();
		else
			result = daopessoa.readAll(caracteres);
		DAO.commit();
		return result;
	}

	public static List<Telefone> consultarTelefones(String digitos) {
		List<Telefone> result;
		DAO.begin();
		if (digitos.isEmpty())
			result = daotelefone.readAll();
		else
			result = daotelefone.readAll(digitos);
		DAO.commit();
		return result;
	}

	public static List<Pessoa> consultarPessoasNTelefones(int n) {
		List<Pessoa> result;
		DAO.begin();
		result = daopessoa.readByNTelefones(n);
		DAO.commit();
		return result;
	}

	public static boolean temTelefoneFixo(String nome) {
		return daopessoa.temTelefoneFixo(nome);
	}

	public static boolean temTelefoneCelular(String nome) {
		return daopessoa.temTelefoneCelular(nome);
	}

	// public static List<Pessoa> consultarMesNascimento(String mes) {
	// List<Pessoa> result;
	// DAO.begin();
	// result = daopessoa.readByMes(mes);
	// DAO.commit();
	// return result;
	// }

}
