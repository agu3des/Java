/**
bb * IFPB - TSI/POO
 * Prof. Fausto Ayres
 * 
 * Jogo de advinhacao - regras do jogo
 * 
 * apenas 6 tentativas para acertar o numero sorteado
 * 
 */

import java.util.Random;

public class JogoAdvinhacao {
	private int tentativa;
	private int numeroSorteado; //numero a ser sorteado
	private int numeroJogado; //ultimo numero adivinhado
	private final int MAXIMO; //não pode ser alterada por isso o nome final

	public JogoAdvinhacao(int max) throws Exception {
		if (max < 1 || max > 99)
			throw new Exception("limite maximo entre 1 e 99");
		MAXIMO = max;
	}

	public void iniciar() {
		tentativa = 0;
		Random random = new Random();
		numeroSorteado = random.nextInt(MAXIMO + 1); //entre 0 e 99
	}
	public boolean adivinhou(int palpite) throws Exception {
		if (palpite < 0 || palpite > MAXIMO)
			throw new Exception("o numero esta fora da faixa permitida= 0 e " + MAXIMO);

		tentativa++;
		numeroJogado = palpite; //palpite do usuário
		if (palpite == numeroSorteado)
			return true;
		else
			return false;
	}

	public String getDica() {
		String dica = "";
		if (tentativa == 0 || terminou())
			dica = "nao ha dica";
		else {
			if (numeroJogado < numeroSorteado)
				dica += "tente um numero MAIOR";
			else
				dica += "tente um numero MENOR";
					//absoluto converte em odulo
			if (Math.abs(numeroJogado - numeroSorteado) <= 5)
			//saber se está próximo do número a ser sorteado
				dica += ", esta QUENTE";
			else
				dica += ", esta FRIO";
		} //junta as dicas
		return dica;
	}

	public boolean terminou() {
		if (numeroJogado == numeroSorteado)
			return true;
		else if (tentativa == 6)
			return true;
		else
			return false;
	}

	public String resultado() {
		if (!terminou())
			return "jogo em andamento";
		else
			if (numeroJogado == numeroSorteado)
				return "ganhou com " + tentativa + " tentativa(s)";
			else
				return "perdeu, terminaram as 6 tentativas !!";

	}

	public int getTentativas() {
		return tentativa;
	}

	public int getLimiteMaximo() {
		return MAXIMO;
	}

}
