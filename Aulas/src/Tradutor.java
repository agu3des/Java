

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

//construtor - le as palavras do arquivo palavras.txt e as coloca nas respectivas listas de palavras
//public ArrayList<String> toPortugues(palavra)  - traduzir a palavra ingles para  varias palavras em portugues
//public ArrayList<String> toIngles(palavra)  - traduzir a palavra portugues para varias palavras em ingles
public class Tradutor {
	
	private ArrayList<String> palavrasPortugues = new ArrayList<>();
	private ArrayList<String> palavrasIngles = new ArrayList<>();	

	
	public Tradutor() throws Exception {
		// abrir arquivo palavras.txt da pasta interna "/dados" para leitura
		InputStream stream = this.getClass().getResourceAsStream("/dados/palavras.txt");
		if (stream == null)
			throw new Exception("Arquivo de palavras inexistente");
		Scanner arquivo = new Scanner(stream);
		// leitura das linhas do arquivo para as respectivas listas
		String linha;
		while (arquivo.hasNext()) {
			linha = arquivo.nextLine().toUpperCase();
			//System.out.println(linha);
			this.palavrasIngles.add(linha.split(";")[0]);
			this.palavrasPortugues.add(linha.split(";")[1]);
		}
		arquivo.close();
		
		System.out.println(palavrasIngles);
		System.out.println(palavrasPortugues);
	}
	public ArrayList<String> toPortugues(String palavraIngles) throws Exception {
		ArrayList<String> resultado = new ArrayList<>();
		palavraIngles = palavraIngles.toUpperCase();
		if (palavraIngles.isEmpty())
			throw new Exception ("Palavra Vazia");
		for (int i =0; i < palavrasIngles.size();i++){
			if (palavrasIngles.get(i).equals(palavraIngles))
				resultado.add(palavrasPortugues.get(i));
		}
		return resultado;
	}
	public ArrayList<String> toIngles(String palavraPortugues) throws Exception {
		ArrayList<String> resultado = new ArrayList<>();
		palavraPortugues = palavraPortugues.toUpperCase();
		if (palavraPortugues.isEmpty())
			throw new Exception ("Palavra Vazia");
		for (int i =0; i < palavrasPortugues.size();i++){
			if (palavrasPortugues.get(i).equals(palavraPortugues))
				resultado.add(palavrasIngles.get(i));
		}
		return resultado;
	}
}
