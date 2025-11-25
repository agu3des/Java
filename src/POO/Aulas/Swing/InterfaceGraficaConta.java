package POO.Window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;

public class InterfaceGraficaConta {

	private JFrame frame;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;

	private Conta conta;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGraficaConta window = new InterfaceGraficaConta();
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
	public InterfaceGraficaConta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Conta");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("Numero");
		label.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		label.setBounds(37, 55, 46, 14);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("CPF");
		label_1.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		label_1.setBounds(37, 87, 46, 14);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("Valor");
		label_2.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		label_2.setBounds(37, 172, 46, 14);
		frame.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(118, 55, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(118, 87, 86, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(118, 169, 86, 20);
		frame.getContentPane().add(textField_2);
		
		button = new JButton("Criar Conta");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText();
				String cpf = textField_1.getText();
				conta = new Conta(num, cpf);
				label_3.setText("Conta Criada");
				
			}
		});
		button.setBounds(296, 54, 106, 23);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("Exibir Dados");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(conta==null)
					label_3.setText("Conta Inexistente");
				else
					label_3.setText(conta.toString());
			}
		});
		button_1.setBounds(296, 83, 106, 23);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("Creditar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valor = Double.parseDouble(textField_2.getText());
				conta.creditar(valor);
				label_3.setText("Credito efetuado com sucesso.");
			}
		});
		button_2.setBounds(214, 168, 89, 23);
		frame.getContentPane().add(button_2);
		
		button_3 = new JButton("Debitar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valor = Double.parseDouble(textField_2.getText());
				try {
					conta.debitar(valor);
					label_3.setText("Debito efetuado com sucesso.");
				}
				catch (Exception el) {
					label_3.setText(el.getMessage());
				}
			}
		});
		button_3.setBounds(313, 168, 89, 23);
		frame.getContentPane().add(button_3);
		
		label_3 = new JLabel("New label");
		label_3.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		label_3.setBounds(10, 214, 414, 36);
		frame.getContentPane().add(label_3);
	}
}
