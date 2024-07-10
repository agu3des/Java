
package Triangulo;
public class TesteTriangulo {
    public static void main (String[] args){
        Triangulo t1 = new Triangulo(1, 3, 4, 4, 5);
        System.out.println("Area 1 = "+t1.calcularArea()); //12.0
        System.out.println("O lado da hipotenusa e = "+ t1.pitagoras());
        System.out.println(t1); //chamada implicita do toString
    }
}
