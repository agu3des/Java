import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Produto;
import Venda;
import regras_negocio.Fachada;

public class TelaProduto {

	private JDialog frame;
	private JTable table;
	private JScrollPane scrollPane;
	private Timer timer;
	private JLabel label_2;
	private JLabel label_1;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	private JLabel label;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	//		public static void main(String[] args) {
	//			EventQueue.invokeLater(new Runnable() {
	//				public void run() {
	//					try {
	//						TelaProduto window = new TelaProduto();
	//						window.frame.setVisible(true);
	//					} catch (Exception e) {
	//						e.printStackTrace();
	//					}
	//				}
	//			});
	//		}

	/**
	 * Create the application.
	 */
	public TelaProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setModal(false);
		frame.setTitle("Produto");
		frame.setBounds(100, 100, 505, 357);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				listagem();
			}
			@Override
			public void windowClosing(WindowEvent e) {
				timer.stop();
			}
		});

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 11, 459, 193);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(Color.WHITE);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		label_1 = new JLabel("nome produto");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 237, 108, 14);
		frame.getContentPane().add(label_1);

		label_2 = new JLabel("vendedor");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(47, 265, 71, 14);
		frame.getContentPane().add(label_2);

		textField = new JTextField();
		textField.setText("tv");
		textField.setColumns(10);
		textField.setBounds(136, 235, 86, 20);
		frame.getContentPane().add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(136, 263, 86, 20);
		frame.getContentPane().add(textField_1);

		button = new JButton("Criar Venda - otimista");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField.getText().isEmpty() || textField_1.getText().isEmpty()) {
						label.setText("campo vazio");
						return;
					}
					String nomeprod = textField.getText();
					String vendedor = textField_1.getText();

					Venda v = Fachada.criarVendaOtimista(vendedor, nomeprod);
					label.setText("venda realizada: " + v.getProduto());
					listagem();
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBounds(254, 233, 195, 23);
		frame.getContentPane().add(button);

		button_1 = new JButton("Criar Venda - pessimista");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField.getText().isEmpty() || textField_1.getText().isEmpty()) {
						label.setText("campo vazio");
						return;
					}
					String nomeprod = textField.getText();
					String vendedor = textField_1.getText();

					Venda v = Fachada.criarVendaPessimista(vendedor, nomeprod);
					label.setText("venda realizada: " + v.getProduto());
					listagem();
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});

		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBounds(254, 262, 195, 23);
		frame.getContentPane().add(button_1);

		label = new JLabel("");
		label.setBounds(20, 293, 459, 14);
		frame.getContentPane().add(label);

		frame.setVisible(true);

		timer = new Timer(0, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listagem();
			}
		});
		timer.setRepeats(true);
		timer.setDelay(2000);
		timer.start();

	}


	public void listagem() {
		try{
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("id");
			model.addColumn("nome");
			model.addColumn("estoque");
			model.addColumn("versao");

			List<Produto> lista = Fachada.listarProdutos();
			for(Produto p : lista) {
				model.addRow(new Object[]{ p.getId(),p.getNome(), p.getEstoque(), p.getVersao() });
			}
			table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getColumnModel().getColumn(2).setMinWidth(150);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

			//atualizar horario da listagem no titulo da janela
			frame.setTitle("Produto  -- "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));

		}
		catch(Exception erro){
			JOptionPane.showMessageDialog(frame,erro.getMessage());
		}

	}
}
