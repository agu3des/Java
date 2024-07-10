package POO.Atividades;

import POO.Window.Aluno;

public class TesteAluno {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("joao", 100, 70);
        System.out.println(a1);
        a1.getMedia();
        a1.getSituacao();
        a1.toString();

        Aluno a2 = new Aluno("maria", 50, 25);
        System.out.println(a2);
        a2.setNota2(100);
        System.out.println(a2);
    }
}
