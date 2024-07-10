package POO.Atividades;

import POO.Window.AplicacaoGraficaConta;

public class TesteConta {
    public static void main (String[] args)  throws Exception{
        AplicacaoGraficaConta conta1 = new AplicacaoGraficaConta("101","123456");
        conta1.creditar(300.0);
        //conta1.debitar(100.0);
        conta1.creditar(200.0);
        System.out.println("Saldo conta 1 = "+conta1.getSaldo()); //400
        System.out.println("A conta 1 esta vazia? "+conta1.vazia()); //false
        System.out.println(conta1.toString());

        AplicacaoGraficaConta conta2 = new AplicacaoGraficaConta("168","789012");
        conta2.creditar(1000.0);
        System.out.println("Saldo conta 2 = "+conta2.getSaldo()); //1000
        System.out.println(conta2.toString());

        conta1.transferir(50,conta2);
        System.out.println("Transferencia feita, valores apos alteracao: ");
        System.out.println("Conta 1 = "+conta1.getSaldo()); //450
        System.out.println("Conta 2 = "+conta2.getSaldo()); //950
    try {
        conta1.debitar(1000);
        } catch (Exception e) {
        //System.out.println(e.getMessage());
        e.printStackTrace(); //retorna pilha com os erros
    }
    
    }
}
