package Atividades.Dieta;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class TelaDieta {

	private JFrame frame;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton button;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	
	private Dieta dieta;
	private JLabel label_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDieta window = new TelaDieta();
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
	public TelaDieta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 406, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("CPF");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(30, 43, 46, 14);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("Peso Atual:");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1.setBounds(30, 75, 68, 14);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("Meta:");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_2.setBounds(30, 108, 46, 14);
		frame.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.setBounds(108, 40, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(108, 72, 86, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(108, 105, 86, 20);
		frame.getContentPane().add(textField_2);
		
		button = new JButton("Criar Dieta");
		button.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textField.getText();
				double peso = Double.parseDouble(textField_1.getText());
				double meta = Double.parseDouble(textField_2.getText());
				
				try {
					dieta = new Dieta(cpf, peso, meta);
					
					label_3.setText("Meses: "+ dieta.getMeses());
					label_4.setText("Pesos Perdidos: "+ dieta.getListaPesosPerdidos());
					label_5.setText("Perda Total: "+ dieta.getPerdaTotal());
				} catch (Exception erro) {
					label_6.setText(erro.getMessage());
				} 
			}
		});
		button.setBounds(49, 147, 89, 23);
		frame.getContentPane().add(button);
		
		label_3 = new JLabel("Meses:");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_3.setBounds(30, 193, 394, 14);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("Pesos Perdidos:");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_4.setBounds(30, 215, 394, 14);
		frame.getContentPane().add(label_4);
		
		label_5 = new JLabel("Perda Total:");
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_5.setBounds(30, 236, 394, 14);
		frame.getContentPane().add(label_5);
		
		label_6 = new JLabel("");
		label_6.setForeground(new Color(255, 0, 0));
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_6.setBounds(192, 151, 188, 14);
		frame.getContentPane().add(label_6);
	}
}
