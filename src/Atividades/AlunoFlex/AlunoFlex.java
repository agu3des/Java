public class AlunoFlex {
	private String nome;
	private double[] notas; //[] para saber que é uma lista

	public AlunoFlex(String nome, double ... notas) {//recebe um array de notas
		this.nome = nome;
		this.notas = notas;
		if (notas.length == 0) {
			System.out.println("Não é permitido aluno sem nota.");
			System.exit(0);
			//throw new runTimeException("Não é permitido aluno sem nota.");
		}
	}

	public double getMedia() { //double por conta do valor e vazio pq eu vou passar dentro
		int qtdNotas = notas.length;
		double somaDasNotas = 0;
		for (int i = 0; i < qtdNotas; i++) {
			somaDasNotas += notas[i];
		}
		return Math.round(somaDasNotas/qtdNotas);
	}
	
	 public String getSituacao(){
	        if (getMedia() >= 7) return "aprovado";
	        else if (getMedia() >= 4 && getMedia() < 7) return "final";
	        else return "reprovado";
	 }

	public String toString() {
		return 
		"Nome = " + nome +
        " | Media = " + getMedia() +
        " | Situacao = " + getSituacao();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}


}


