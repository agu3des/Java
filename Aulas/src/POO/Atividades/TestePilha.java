package POO.Atividades;
public class TestePilha {
    public static void main(String[] args) {
        Pilha<String> p1 = new Pilha<>();
        p1.empilhar("João");
        p1.empilhar("Maria");
        p1.empilhar("Pedro");
        p1.empilhar("Ana");

        //System.out.println(p1.topo());
        System.out.println(p1.estaVazia());
        try {
            p1.desempilhar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(p1.topo());
        p1.esvaziar();
        System.out.println(p1.estaVazia());

        p1.empilhar("João");
        p1.empilhar("Maria");
        p1.empilhar("Pedro");
        p1.empilhar("Ana");
        p1.tamanho();
        System.out.println(p1);

        // Pilha <Integer> p2 = new Pilha();
        // p2.empilhar(1);
        // p2.empilhar(6);
        // p2.tamanho();//demostrar que não funciona para números
    }
}