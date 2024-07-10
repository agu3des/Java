package Matricula;

public class TesteMatricula {
    public static void main(String[] args) {
        Matricula matricula = new Matricula("20231370020");
        String ano = matricula.getAno();
        String periodo = matricula.getPeriodo();
        String codigoCurso = matricula.getCodigoCurso();
        String sequencia = matricula.getSequencia();
    
        System.out.println(ano);
        System.out.println(periodo);
        System.out.println(codigoCurso);
        System.out.println(sequencia);
    }
}
