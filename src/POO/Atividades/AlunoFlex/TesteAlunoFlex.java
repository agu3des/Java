public class TesteAlunoFlex {
    public static void main(String[] args) {
        AlunoFlex a1 = new AlunoFlex("joao", 100, 70);
        System.out.println(a1);
        a1.getMedia();
        a1.getSituacao();
        a1.toString();

        AlunoFlex a2 = new AlunoFlex("maria", 50, 25,70,45,90,80);
        System.out.println(a2);
        System.out.println(a2);
        
        AlunoFlex a3 = new AlunoFlex("pedro");
    }
}