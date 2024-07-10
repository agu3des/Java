package Unique;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela1 window = new Janela1();
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
	public Janela1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Janela de Troca");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(10, 77, 86, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();		
		textField_1.setText("");
		textField_1.setColumns(10);
		textField_1.setBounds(338, 77, 86, 36);
		frame.getContentPane().add(textField_1);
		
		button = new JButton("-->");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String textoCampo1 = textField.getText();
                textField_1.setText(textoCampo1);
				textField.setText("");
				textField.requestFocus();
			}
		});
		button.setBounds(106, 84, 89, 23);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("<--");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String textoCampo2 = textField_1.getText();
                textField.setText(textoCampo2);
				textField_1.setText("");
				textField_1.requestFocus();
			}
		});
		button_1.setBounds(226, 84, 89, 23);
		frame.getContentPane().add(button_1);
	}
}
