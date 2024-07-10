package Unique;
import javax.swing.JFrame;

public class Janela {
    public static void main(String[] agrs) {
        JFrame janela = new JFrame();
        janela.setTitle("Exemplo de janela");
        janela.setSize(500,300);
        janela.setResizable(false); //redimensionar 
        janela.setVisible(true);
        int x = janela.getX();
        int y = janela.getY();
    }
}
