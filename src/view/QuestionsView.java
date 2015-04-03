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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JScrollPane;

import model.Docente;

import org.jdesktop.swingx.autocomplete.AutoCompleteComboBoxEditor;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ComboBoxCellEditor;

import controller.ControllerQuestions;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuestionsView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Docente user;
	private ControllerQuestions controllerQuestions;
	private String moduloEscolhido= new String("");
	JComboBox<String> comboBox_submodulo = new JComboBox<String>();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public QuestionsView(Docente user) {
		this.user=user;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		controllerQuestions = new ControllerQuestions(user);

		JLabel lblDocente = new JLabel("Docente:  " + displayCurrentUser());// + displayCurrentUser());
		lblDocente.setBounds(12, 13, 156, 16);
		contentPane.add(lblDocente);

		JButton btnFechar = new JButton("Sair");
		btnFechar.setBounds(573, 315, 97, 25);
		contentPane.add(btnFechar);

		btnFechar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				dispose();

			}
		});


		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(12, 315, 97, 25);
		contentPane.add(btnAdicionar);

		btnAdicionar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				InsertQuestionsView teste = new InsertQuestionsView();
				teste.setVisible(true);										
			}
		});

		JButton btnVerDetalhes = new JButton("Ver Detalhes");
		btnVerDetalhes.setBounds(12, 277, 113, 25);
		contentPane.add(btnVerDetalhes);
		btnVerDetalhes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetailsView details = new DetailsView();
				details.setVisible(true);
			}
		});

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


		//JComboBox comboBox_dificuldade = new JComboBox(new Object[] {null, "Muito Fácil", "Fácil",   //Teste com dificuldades
		//      "Médio", "Dificil", "Muito Dificil" });
		//




		//	JComboBox comboBox_modulo = new JComboBox(new Object[] {null, "Matematica", "Portugues", //Teste com módulos
		//			        									"Portunhol", "Informatica", "Ciencias" });
		//
		final JComboBox<String> comboBox_modulo= new JComboBox<String>();
		comboBox_modulo.setEditable(true);
		comboBox_modulo.setBounds(84, 42, 113, 22);
		contentPane.add(comboBox_modulo);
		AutoCompleteDecorator.decorate(comboBox_modulo);
		comboBox_modulo.addItem("");
		final String[] populateNiveisModulo = controllerQuestions.loadModulos();

		for(int i=0;i <populateNiveisModulo.length;i++){
			comboBox_modulo.addItem(populateNiveisModulo[i]);
		}
		comboBox_modulo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				for(int i=0;i < populateNiveisModulo.length;i++){
					if(comboBox_modulo.getSelectedItem().equals(populateNiveisModulo[i])){
						//System.out.println(e.getItem() );
						moduloEscolhido= populateNiveisModulo[i];
						preencherSubModulo();

					}
				}}
		});
		
		
		comboBox_submodulo.setEditable(true);
		comboBox_submodulo.setBounds(325, 39, 113, 22);
		contentPane.add(comboBox_submodulo);
		AutoCompleteDecorator.decorate(comboBox_submodulo);
		comboBox_submodulo.addItem("");
		System.out.println(moduloEscolhido + "modulo");
		if(moduloEscolhido.equals("")){
			//subModulos=new String[0];  
			System.out.println("Isto é uma bela merda");
		}
		
			
			


		

		//COMBOBOX NIVEL DIFICULDADE
		JComboBox<String> comboBox_dificuldade= new JComboBox<String>();
		comboBox_dificuldade.setEditable(true);
		comboBox_dificuldade.setBounds(547, 42, 113, 22);
		contentPane.add(comboBox_dificuldade);
		String[] populateNiveis = controllerQuestions.populateNiveis(); //Erro estava aqui!!!!
		AutoCompleteDecorator.decorate(comboBox_dificuldade);
		comboBox_dificuldade.addItem("");
		for(int i = 0; i < populateNiveis.length;i++){
			comboBox_dificuldade.addItem(populateNiveis[i]);

		}
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








	}


	//Métodos---Não está no diagrama sequencia.
	private String displayCurrentUser(){  
		System.out.println(user); //No relatorio está VOID
		//	System.out.println(user.hashCode());
		return	user.getNome(); // 				fazer random para escolher um Docente qualquer

	}
		public void preencherSubModulo(){
			String[] subModulosEscolhidos = controllerQuestions.loadSubModulos(moduloEscolhido);
			for(int i=0;i<subModulosEscolhidos.length;i++){
				comboBox_submodulo.addItem(subModulosEscolhidos[i]);
		}

	}
}