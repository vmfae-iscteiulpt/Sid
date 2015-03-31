package view;

									//+//ALTERAR NOMES DE ACORDO COM O MODELO DE CLASSES
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JScrollPane;

import org.jdesktop.swingx.autocomplete.AutoCompleteComboBoxEditor;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ComboBoxCellEditor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuestionsView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionsView frame = new QuestionsView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuestionsView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFechar = new JButton("Sair");
	/*	btnFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnFechar.add(btnFechar);
			}
		});
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnFechar.remove(btnFechar);
			}
		});*/
		
		btnFechar.setBounds(573, 315, 97, 25);
		contentPane.add(btnFechar);
		
		//btnFechar.add
		
		
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(12, 315, 97, 25);
		contentPane.add(btnAdicionar);
		
		JButton btnVerDetalhes = new JButton("Ver Detalhes");
		btnVerDetalhes.setBounds(12, 277, 113, 25);
		contentPane.add(btnVerDetalhes);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setBounds(135, 277, 97, 25);
		contentPane.add(btnEditar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setEnabled(false);
		btnApagar.setBounds(244, 277, 97, 25);
		contentPane.add(btnApagar);
		
		JButton btnNewButton = new JButton("Minhas Perguntas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(12, 74, 156, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Outros Docentes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(202, 74, 139, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblMdulo = new JLabel("Modulo");
		lblMdulo.setBounds(12, 45, 56, 16);
		contentPane.add(lblMdulo);
		

		JComboBox comboBox_modulo = new JComboBox(new Object[] {null, "Matematica", "Portugues", //Teste com módulos
					        "Portunhol", "Informatica", "Ciencias" });
		AutoCompleteDecorator.decorate(comboBox_modulo);
		comboBox_modulo.setEditable(true);
		comboBox_modulo.setBounds(84, 42, 113, 22);
		contentPane.add(comboBox_modulo);
		
		JComboBox comboBox_submodulo = new JComboBox();
		AutoCompleteDecorator.decorate(comboBox_submodulo);
		comboBox_submodulo.setEditable(true);
		comboBox_submodulo.setBounds(325, 39, 113, 22);
		contentPane.add(comboBox_submodulo);
		
		JComboBox comboBox_dificuldade = new JComboBox(new Object[] {null, "Muito Fácil", "Fácil",   //Teste com dificuldades
		        "Médio", "Dificil", "Muito Dificil" });
		AutoCompleteDecorator.decorate(comboBox_dificuldade);
		comboBox_dificuldade.setEditable(true);
		comboBox_dificuldade.setBounds(547, 42, 113, 22);
		contentPane.add(comboBox_dificuldade);
		
		
		JLabel lblSubmdulo = new JLabel("Sub-Modulo");
		lblSubmdulo.setBounds(235, 45, 84, 16);
		contentPane.add(lblSubmdulo);
		
		JLabel lblDificuldade = new JLabel("Dificuldade");
		lblDificuldade.setBounds(462, 45, 73, 16);
		contentPane.add(lblDificuldade);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 112, 633, 151);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Modulo", "Sub-Modulo", "Nivel", "Pergunta"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblDocente = new JLabel("Docente:   Nome Docente");
		lblDocente.setBounds(12, 13, 156, 16);
		contentPane.add(lblDocente);
		
		
		
		
	
	}
}
