package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCalculator {

	private JFrame frame;
	private JTextField textField;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JLabel label;

	private calculator calculadora;

	
	private double n1;
	private double n2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCalculator window = new TelaCalculator();
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
	public TelaCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 347, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(30, 48, 74, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double n1 = Double.parseDouble(textField.getText());
				label.setText(""+n1+"+");
				double n2 = Double.parseDouble(textField.getText());
				label.setText(""+n2);
				
			}
		});
		button.setBounds(30, 108, 53, 23);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("-");
		button_1.setBounds(30, 142, 53, 23);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("*");
		button_2.setBounds(30, 176, 53, 23);
		frame.getContentPane().add(button_2);
		
		button_3 = new JButton("/");
		button_3.setBounds(30, 210, 53, 23);
		frame.getContentPane().add(button_3);
		
		button_4 = new JButton("=");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.soma(n1, n2);
			}
		});
		button_4.setBounds(220, 210, 89, 23);
		frame.getContentPane().add(button_4);
		
		button_5 = new JButton("tan");
		button_5.setBounds(93, 210, 53, 23);
		frame.getContentPane().add(button_5);
		
		button_6 = new JButton("cos");
		button_6.setBounds(93, 176, 53, 23);
		frame.getContentPane().add(button_6);
		
		button_7 = new JButton("sen");
		button_7.setBounds(93, 142, 53, 23);
		frame.getContentPane().add(button_7);
		
		button_8 = new JButton("∛");
		button_8.setBounds(156, 210, 53, 23);
		frame.getContentPane().add(button_8);
		
		button_9 = new JButton("√");
		button_9.setBounds(156, 176, 53, 23);
		frame.getContentPane().add(button_9);
		
		label = new JLabel("");
		label.setBounds(135, 48, 140, 43);
		frame.getContentPane().add(label);
	}
}