import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Venda;
import regras_negocio.Fachada;

public class TelaVenda {

	private JDialog frame;
	private JTable table;
	private JScrollPane scrollPane;
	private Timer timer;
	private JLabel label;

	/**
	 * Launch the application.
	 */
//		public static void main(String[] args) {
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						TelaVenda window = new TelaVenda();
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
	public TelaVenda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setModal(false);

		frame.setTitle("Venda");
		frame.setBounds(100, 100, 505, 357);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				timer.stop();
			}
		});

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 11, 459, 271);
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
			model.addColumn("vendedor");
			model.addColumn("nome do produto");
			model.addColumn("datahora");

			List<Venda> lista = Fachada.listarVendas();
			for(Venda v : lista) {
				model.addRow(new Object[]{ v.getId(),v.getVendedor(), v.getProduto().getNome(), v.getDatahoraStr() });
			}
			table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getColumnModel().getColumn(2).setMinWidth(120);
			table.getColumnModel().getColumn(3).setMinWidth(180);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

			//atualizar horario da listagem no titulo da janela
			frame.setTitle("Venda  -- "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));

		}
		catch(Exception erro){
			JOptionPane.showMessageDialog(frame,erro.getMessage());
		}

	}
}
