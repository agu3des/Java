public class Aluno {
    private String nomeAluno;
    private int nota1;
    private int nota2;

    public Aluno(String nomeAluno, int nota1, int nota2){
        this.nomeAluno = nomeAluno;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public int getMedia(){
        //return (nota1+nota2)/2;
        double med = (nota1+nota2)/2;
        return (int) Math.round(med); //caso tenha nota quebrada
        
    }

    public String getSituacao(){
        if (getMedia() >= 7) return "aprovado";
        else if (getMedia() >= 4 && getMedia() < 7) return "final";
        else return "reprovado";
    }

	public String toString() {
		return 
		"Nome = " + nomeAluno +
		" | Nota 1 = " + nota1 + 
		" | Nota 2 = " + nota2 +
        " | Media = " + getMedia() +
        " | Situacao = " + getSituacao();
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public int getNota1() {
		return nota1;
	}

	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	public int getNota2() {
		return nota2;
	}

	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}

    
}
