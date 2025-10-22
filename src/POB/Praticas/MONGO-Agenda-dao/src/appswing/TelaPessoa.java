/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Pesist~encia de Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import modelo.Pessoa;
import modelo.Telefone;
import regras_negocio.Fachada;

public class TelaPessoa {
	private JDialog frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton button;
	private JButton button_4;
	private JLabel label;
	private JTextField textField;
	private JPanel panel_1;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField textField_1;
	private JLabel label_4;
	private JTextField textField_2;
	private JLabel label_5;
	private JButton button_5;

	private BufferedImage buffer; // armazena a foto temporariamente na mem�ria
	private Timer timer;

	private JButton button_6;
	private JTextField textField_3;
	private JButton button_1;
	private JButton button_7;
	private JLabel label_6;
	private JButton button_3;
	private JLabel label_7;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// TelaReuniao window = new TelaReuniao();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */
	public TelaPessoa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setModal(true);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				timer.stop();
			}
		});
		frame.setTitle("Listar pessoas");
		frame.setBounds(100, 100, 744, 428);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 63, 685, 155);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		// evento de selecao de uma linha da tabela
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (table.getSelectedRow() >= 0) {
						// pegar o nome, data nascimento e apelidos da pessoa selecionada
						String nome = (String) table.getValueAt(table.getSelectedRow(), 0);
						Pessoa p = Fachada.localizarPessoa(nome);
						textField_1.setText(nome);
						String data = p.getDtNascimento();
						textField_2.setText(data);
						textField_3.setText(String.join(",", p.getApelidos()));
						if (p.getFoto() != null) {
							// converte a imagem lida do banco do formato byte[] para BufferedImage
							InputStream in = new ByteArrayInputStream(p.getFoto());
							BufferedImage buffer = ImageIO.read(in);
							ImageIcon icon = new ImageIcon(buffer.getScaledInstance(buffer.getWidth(),
									buffer.getHeight(), Image.SCALE_DEFAULT));
							icon.setImage(
									icon.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), 1));
							label_1.setIcon(icon);
						} else {
							label_1.setText("sem foto"); // limpa a imagem
							label_1.setIcon(null);
						}

						label.setText("");
					}
				} catch (Exception erro) {
					label.setText(erro.getMessage());
				}

			}
		});

		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		button_4 = new JButton("Apagar");
		button_4.setToolTipText("apagar pessoa e seus dados");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textField_1.getText().isEmpty()) {
						label.setText("nome vazio");
						return;
					}
					// pegar o nome na linha selecionada
					String nome = textField_1.getText();
					Object[] options = { "Confirmar", "Cancelar" };
					int escolha = JOptionPane.showOptionDialog(null,
							"Esta opera��o apagar� os telefones e remover� as reunioes de " + nome, "Alerta",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
					if (escolha == 0) {
						Fachada.excluirPessoa(nome);
						label.setText("pessoa excluida");
						label_1.setIcon(null); // limpa a imagem
						listagem(); // listagem
					} else
						label.setText("exclus�o cancelada");

				} catch (Exception erro) {
					label.setText(erro.getMessage());
				}
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_4.setBounds(169, 340, 74, 23);
		frame.getContentPane().add(button_4);

		label = new JLabel("");
		label.setForeground(Color.RED);
		label.setBounds(21, 372, 607, 14);
		frame.getContentPane().add(label);

		button = new JButton("Buscar por nome");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listagem();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBounds(175, 27, 149, 23);
		frame.getContentPane().add(button);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(62, 28, 106, 20);
		frame.getContentPane().add(textField);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Foto",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(392, 229, 116, 117);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		label_1 = new JLabel("sem foto");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 18, 98, 88);
		panel_1.add(label_1);

		label_2 = new JLabel("selecione uma pessoa para editar");
		label_2.setBounds(21, 216, 394, 14);
		frame.getContentPane().add(label_2);

		label_3 = new JLabel("nome:");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(31, 239, 62, 14);
		frame.getContentPane().add(label_3);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(101, 235, 165, 20);
		frame.getContentPane().add(textField_1);

		label_4 = new JLabel("nascimento");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(31, 264, 62, 14);
		frame.getContentPane().add(label_4);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(101, 260, 86, 20);
		frame.getContentPane().add(textField_2);

		label_5 = new JLabel("apelidos");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setBounds(31, 289, 62, 14);
		frame.getContentPane().add(label_5);

		button_5 = new JButton("Carregar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = selecionarFoto();
				if (file == null)
					return; // nao foi selecionado
				try {
					buffer = ImageIO.read(file); // ler imagem do arquivo
					ImageIcon icon = new ImageIcon(
							buffer.getScaledInstance(buffer.getWidth(), buffer.getHeight(), Image.SCALE_DEFAULT));
					icon.setImage(icon.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), 1));
					label_1.setIcon(icon);
				} catch (IOException ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		button_5.setBounds(518, 235, 86, 23);
		frame.getContentPane().add(button_5);

		button_6 = new JButton("Remover");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buffer = null;
				label_1.setIcon(null);
				label_1.setText("sem foto");
			}
		});
		button_6.setBounds(518, 260, 86, 23);
		frame.getContentPane().add(button_6);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(101, 284, 264, 20);
		frame.getContentPane().add(textField_3);

		button_1 = new JButton("Criar");
		button_1.setToolTipText("cadastrar nova pessoa");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textField_1.getText().isEmpty()) {
						label.setText("nome vazio");
						return;
					}
					String nome = textField_1.getText().trim();
					String nascimento = textField_2.getText().trim();
					String[] apelidos = textField_3.getText().trim().split(",");

					byte[] bytesfoto = null;
					if (buffer != null) {
						try {
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							ImageIO.write(buffer, "jpg", baos); // converter formato
							bytesfoto = baos.toByteArray();
							baos.close();
						} catch (IOException ex) {
							label.setText("problema na convers�o da imagem em bytes");
						}
					}
					Fachada.criarPessoa(nome, nascimento, bytesfoto, apelidos);
					String numero = textField_4.getText();
					if (!numero.isEmpty())
						Fachada.criarTelefone(nome, numero);
					label.setText("pessoa criada");
					listagem();
				} catch (Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_1.setBounds(21, 340, 62, 23);
		frame.getContentPane().add(button_1);

		button_7 = new JButton("Atualizar");
		button_7.setToolTipText("atualizar pessoa ");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textField_1.getText().trim().isEmpty()) {
						label.setText("nome vazio");
						return;
					}
					String nome = textField_1.getText();
					String nascimento = textField_2.getText();
					String[] apelidos = textField_3.getText().trim().split(",");
					byte[] bytesfoto = null;
					if (buffer != null) {
						try {
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							ImageIO.write(buffer, "jpg", baos);
							bytesfoto = baos.toByteArray();
							baos.close();
						} catch (IOException ex1) {
							label.setText("problema na convers�o da imagem em bytes");
						}
					}
					Fachada.alterarPessoa(nome, nascimento, bytesfoto, apelidos);
					String numero = textField_4.getText();
					if (!numero.isEmpty())
						Fachada.criarTelefone(nome, numero);
					label.setText("pessoa atualizada");
					listagem();
				} catch (Exception ex2) {
					label.setText(ex2.getMessage());
				}
			}
		});
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_7.setBounds(82, 340, 87, 23);
		frame.getContentPane().add(button_7);

		label_6 = new JLabel("Texto:");
		label_6.setBounds(21, 32, 46, 14);
		frame.getContentPane().add(label_6);

		button_3 = new JButton("Limpar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		button_3.setBounds(276, 234, 89, 23);
		frame.getContentPane().add(button_3);

		label_7 = new JLabel("novo numero");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(21, 313, 74, 14);
		frame.getContentPane().add(label_7);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(101, 309, 86, 20);
		frame.getContentPane().add(textField_4);

		// ----------timer----------------
		timer = new Timer(0, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listagem();
			}
		});
		timer.setRepeats(true);
		timer.setDelay(3000); // 3segundos
		timer.start(); // inicia o temporizador

		frame.setVisible(true);
	}

	public void listagem() {
		try {
			List<Pessoa> lista = Fachada.consultarPessoas(textField.getText());

			// objeto model contem todas as linhas e colunas da tabela
			DefaultTableModel model = new DefaultTableModel();
			table.setModel(model);

			// criar as colunas (0,1,2) da tabela
			model.addColumn("Nome");
			model.addColumn("Nascimento");
			model.addColumn("Apelidos");
			model.addColumn("Telefones");

			// criar as linhas da tabela
			String texto1 = "", texto2 = "";
			String data;
			for (Pessoa p : lista) {
				texto1 = String.join(",", p.getApelidos()); // concatena strings
				data = p.getDtNascimento();
				if (p.getTelefones().size() == 0)
					texto2 = "sem telefone";
				else {
					texto2 = "";
					for (Telefone t : p.getTelefones())
						texto2 = texto2 + " " + t.getNumero();
				}

				model.addRow(new Object[] { p.getNome(), data, texto1, texto2 });

			}
			label_2.setText("resultados: " + lista.size() + " pessoas   - selecione uma linha para editar");

			// redimensionar a coluna 2
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // desabilita
			table.getColumnModel().getColumn(2).setMinWidth(200); // coluna dos apelidos
			table.getColumnModel().getColumn(3).setMinWidth(200); // coluna dos telefones
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); // desabilita
			
			// atualizar horario da listagem no titulo da janela
			frame.setTitle(
					"Pessoa   " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));

		} catch (Exception erro) {
			label.setText(erro.getMessage());
		}
	}

	public File selecionarFoto() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens", "jpg", "gif");
		chooser.setFileFilter(filter);
		try {
			// chooser.setCurrentDirectory(new File("c:\\"));
			chooser.setCurrentDirectory(new File((new File(".").getCanonicalPath() + "\\src\\fotos")));
		} catch (IOException e) {
		}
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.showOpenDialog(null);
		File file = chooser.getSelectedFile();
		return file;
	}
}
