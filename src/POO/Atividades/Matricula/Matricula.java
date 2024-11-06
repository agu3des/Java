package Atividades.Matricula;

public class Matricula {
    private String matricula;

    public Matricula(String texto){
        matricula = texto;
    }
    public String getAno() {
        return matricula.substring(0,4);
    }
    public String getPeriodo() {
        return matricula.substring(4,5);
    }
    public String getCodigoCurso() {
        return matricula.substring(5,7);
    } 
    public String getSequencia() {
        return matricula.substring(7);
    }
}