package Atividades.Matricula;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMatricula {

	private JFrame frame;
	private JLabel label;
	private JTextField textField;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JButton button;

	
	private Matricula matricula;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMatricula window = new TelaMatricula();
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
	public TelaMatricula() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("Matrícula:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label.setBounds(26, 50, 85, 14);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 12));
		textField.setBounds(121, 47, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		label_1 = new JLabel("Ano:");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_1.setBounds(26, 90, 85, 14);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("Período:");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_2.setBounds(26, 132, 85, 14);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("Código do Curso:");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_3.setBounds(26, 170, 113, 14);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("Sequência:");
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_4.setBounds(26, 213, 113, 14);
		frame.getContentPane().add(label_4);
		
		label_5 = new JLabel("");
		label_5.setBounds(121, 90, 113, 14);
		frame.getContentPane().add(label_5);
		
		label_6 = new JLabel("");
		label_6.setBounds(121, 132, 113, 14);
		frame.getContentPane().add(label_6);
		
		label_7 = new JLabel("");
		label_7.setBounds(121, 170, 113, 14);
		frame.getContentPane().add(label_7);
		
		label_8 = new JLabel("");
		label_8.setBounds(121, 213, 113, 14);
		frame.getContentPane().add(label_8);
		
		button = new JButton("Gerar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String matriculaS = textField.getText();
				
				Matricula matricula = new Matricula(matriculaS);
				
				label_5.setText(matricula.getAno());
				label_6.setText(matricula.getPeriodo());
				label_7.setText(matricula.getCodigoCurso());
				label_8.setText(matricula.getSequencia());
			}
		});
		button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		button.setBounds(231, 46, 89, 23);
		frame.getContentPane().add(button);
	}
}
