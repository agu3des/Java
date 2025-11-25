package POO.Window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceGraficaAluno {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JTextField textField_3;

	private Aluno Aluno;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGraficaAluno window = new InterfaceGraficaAluno();
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
	public InterfaceGraficaAluno() {
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
		
		textField = new JTextField();
		textField.setBounds(108, 11, 130, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(76, 57, 86, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(76, 102, 86, 20);
		frame.getContentPane().add(textField_2);
		
		label = new JLabel("Nome do Aluno:");
		label.setBounds(20, 14, 78, 14);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("Nota 1:");
		label_1.setBounds(20, 60, 46, 14);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("Nota 2:");
		label_2.setBounds(20, 105, 46, 14);
		frame.getContentPane().add(label_2);
		
		button = new JButton("Gerar Média");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(34, 150, 96, 23);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("Gerar Situação");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(20, 184, 126, 23);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("Informações do Aluno");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(252, 101, 137, 23);
		frame.getContentPane().add(button_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(252, 129, 137, 65);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
	}
}
