package POO.Window;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Sorteio {

	private JFrame frame;
	private JButton button;
	private JLabel label;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sorteio window = new Sorteio();
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
	public Sorteio() {
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
		
		button = new JButton("Sortear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random sorteio = new Random();
				int numero = sorteio.nextInt(100);
				String texto = numero+"";
				label.setText(texto);
				textArea.append(texto + "\n");
			}
		});
		button.setBounds(72, 48, 89, 28);
		frame.getContentPane().add(button);
		
		label = new JLabel("New label");
		label.setBounds(222, 41, 89, 42);
		frame.getContentPane().add(label);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 106, 113, 103);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
