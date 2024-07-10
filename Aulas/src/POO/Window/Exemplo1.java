package POO.Window;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Exemplo1 {

	private JFrame frame;
	private JButton button;
	private JLabel label;
	private JTextField textField;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exemplo1 window = new Exemplo1();
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
	public Exemplo1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Primeira Janela");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel();
		label.setText("Digite uma palavra");
		label.setBounds(56, 131, 55, 14);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(147, 128, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		button = new JButton();
		button.setText("Ok");
		button.setBounds(296, 99, 101, 20);
		button.addActionListener(
			new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menssage = "Você escreveu: "+ textField.getText();
				JOptionPane.showMessageDialog(null, menssage); }});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("Limpar");
		button_1.setBounds(296, 162, 101, 23);
		frame.getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textField.setText("");
			textField.requestFocus();}});

	}
}
