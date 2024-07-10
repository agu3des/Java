package Unique;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Placar {

    private JFrame frame;
    private JButton button;
    private JButton button_1;
    private JButton button_2;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;
    private int placarBrasil;
    private int placarArgentina;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Placar window = new Placar();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Placar() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Placar");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        label = new JLabel("Brasil");
        label.setBounds(87, 65, 46, 14);
        frame.getContentPane().add(label);

        label_1 = new JLabel("Argentina");
        label_1.setBounds(87, 134, 77, 14);
        frame.getContentPane().add(label_1);

        label_2 = new JLabel("0");
        label_2.setBounds(378, 65, 46, 14);
        frame.getContentPane().add(label_2);

        label_3 = new JLabel("0");
        label_3.setBounds(378, 134, 46, 14);
        frame.getContentPane().add(label_3);

        label_4 = new JLabel("\r\n");
        label_4.setBounds(23, 51, 54, 42);
        frame.getContentPane().add(label_4);

        label_5 = new JLabel("");
        label_5.setBounds(23, 122, 54, 42);
        frame.getContentPane().add(label_5);

        button = new JButton("Gol");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	            placarBrasil++;
	            label_2.setText(placarBrasil+"");
                if (placarBrasil >= 5 || placarArgentina >= 5) {
                    String vencedor = placarBrasil > placarArgentina ? "Brasil" : "Argentina";
                    JOptionPane.showMessageDialog(frame, "O vencedor é: " + vencedor);
                    button.setEnabled(false);
                    button_1.setEnabled(false);
                }
            }
        });
        button.setBounds(269, 61, 89, 23);
        frame.getContentPane().add(button);

        button_1 = new JButton("Gol");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	placarArgentina++;
                label_3.setText(placarArgentina+"");
                if (placarBrasil >= 5 || placarArgentina >= 5) {
                    String vencedor = placarBrasil > placarArgentina ? "Brasil" : "Argentina";
                    JOptionPane.showMessageDialog(frame, "O vencedor é: " + vencedor);
                    button.setEnabled(false);//impede o funcionamento do botão
                    button_1.setEnabled(false);
                }
                
            }
        });
        button_1.setBounds(269, 130, 89, 23);
        frame.getContentPane().add(button_1);

        button_2 = new JButton("Reiniciar");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                placarBrasil = 0;
                placarArgentina = 0;
                label_2.setText("0");
                label_3.setText("0");
                button.setEnabled(true);//ativa o funcionamento do botão
                button_1.setEnabled(true);
            }
        });
        button_2.setBounds(164, 194, 89, 23);
        frame.getContentPane().add(button_2);

        ImageIcon iconBrasil = new ImageIcon(Placar.class.getResource("/imagens/brasil-flag.png"));
        iconBrasil.setImage(iconBrasil.getImage().getScaledInstance(
                label_4.getWidth(),
                label_4.getHeight(),
                Image.SCALE_DEFAULT
        ));
        label_4.setIcon(iconBrasil);

        ImageIcon iconArgentina = new ImageIcon(Placar.class.getResource("/imagens/Flag_of_Argentina.svg.png"));
        iconArgentina.setImage(iconArgentina.getImage().getScaledInstance(
                label_5.getWidth(),
                label_5.getHeight(),
                Image.SCALE_DEFAULT
        ));
        label_5.setIcon(iconArgentina);

        frame.setVisible(true);
    }
}
