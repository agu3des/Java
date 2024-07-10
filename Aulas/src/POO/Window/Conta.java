package POO.Window;
public class Conta {
    private String numero;
    private String cpf;
    private double saldo;

    public Conta(String numero, String cpf) {
        this.numero = numero;
        this.cpf = cpf;
        this.saldo = 0; 
    }
    public void creditar(double valor) {
        saldo = saldo + valor; //altera o objeto, pois é void
    }
    public void creditar(double... lista) { //array
        for(double valor : lista)
            saldo = saldo + valor;
    }
    public void debitar(double valor) throws Exception{
        if(valor>saldo){
            //System.out.println("Quantia incorreta, voce nao possui saldo suficiente!"); /técnica de tratamento de erro utilizando o output
            throw new Exception("Quantia incorreta, voce nao possui saldo suficiente!");
        }
        saldo = saldo - valor;//apenas executa uma tarefa
    }
    public double getSaldo() {
    	return saldo;
    }
    public void transferir(double valor, Conta destino) throws Exception{
        this.debitar(valor);                   //recebe e desvia 
        destino.creditar(valor);
    }
	public String toString() {
		return 
		"Dados do Cliente: " + 
		" Numero = " + numero +
		" | CPF = " + cpf + 
		" | Saldo = " + saldo;
	}
    public Boolean vazia() {
        return (saldo <= 0);
    }
    public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
