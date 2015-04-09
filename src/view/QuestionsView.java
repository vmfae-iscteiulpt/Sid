package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

import model.Docente;
import model.Question;
import model.QuestionsTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import controller.ControllerQuestions;

public class QuestionsView extends JFrame {
	/**
*
*/
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Docente currentUser;
	private ControllerQuestions controllerQuestions;
	private boolean minhaQuestao;
	
	private JTable tableData = new JTable();
	private  QuestionsTableModel questionTableModel = new QuestionsTableModel();

	private JLabel lblMdulo = new JLabel("Modulo");
	private JComboBox<String> comboBox_modulo = new JComboBox<String>();
	private String moduloEscolhido = new String("");
	private String subModuloEscolhido = new String("");
	private String nivelDificuldade = new String("");
	private String pergunta = new String("");
	private JButton btnAdicionar;
	private JButton btnEditar;
	private JButton btnApagar;
	private JComboBox<String> comboBox_submodulo = new JComboBox<String>();
	private JComboBox<String> comboBox_dificuldade = new JComboBox<String>();
	private LinkedList<Question> listQuestions;
	private String[] vetorModulos;
	DefaultTableModel dtm;
	int contador=0;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public QuestionsView(final Docente currentUser) {
		this.currentUser = currentUser;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		controllerQuestions = new ControllerQuestions(currentUser);
		JLabel lblDocente = new JLabel("Docente: " + displayCurrentUser());// +
																			// displayCurrentUser());
		lblDocente.setBounds(12, 13, 156, 16);
		contentPane.add(lblDocente);
		JButton btnFechar = new JButton("Sair");
		btnFechar.setBounds(573, 315, 97, 25);
		contentPane.add(btnFechar);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});

		/************* Modulo *************/

		lblMdulo.setBounds(12, 45, 56, 16);
		contentPane.add(lblMdulo);
		// ComboBox Modulo
		comboBox_modulo.setEditable(true);
		comboBox_modulo.setBounds(84, 42, 120, 22);
		contentPane.add(comboBox_modulo);
		AutoCompleteDecorator.decorate(comboBox_modulo);
		comboBox_modulo.addItem(" ");
		vetorModulos = controllerQuestions.loadModulos();
		for (int i = 0; i < vetorModulos.length; i++) {
			comboBox_modulo.addItem(vetorModulos[i]);
		}

		comboBox_modulo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (comboBox_modulo.getSelectedItem().equals(" ")) {
					System.out.println("nenhum modulo esolhido!");
					comboBox_submodulo.removeAllItems();
					comboBox_submodulo.addItem(" ");
				} else {
					// System.out.println((comboBox_submodulo.getSelectedItem()));
					for (int i = 0; i < vetorModulos.length; i++) {
						if (comboBox_modulo.getSelectedItem().equals(
								vetorModulos[i])) {
							moduloEscolhido = vetorModulos[i];
							preencherSubModulo(comboBox_submodulo,
									moduloEscolhido);
						}
					}
				}

			}
		});
		// end

		// comboBox Submodulo
		comboBox_submodulo.setEditable(true);
		comboBox_submodulo.setBounds(325, 39, 113, 22);
		contentPane.add(comboBox_submodulo);
		AutoCompleteDecorator.decorate(comboBox_submodulo);
		comboBox_submodulo.addItem(" ");

		// end

		// COMBOBOX NIVEL DIFICULDADE
		comboBox_dificuldade.setEditable(true);
		comboBox_dificuldade.setBounds(547, 42, 113, 22);
		contentPane.add(comboBox_dificuldade);
		String[] populateNiveis = controllerQuestions.populateNiveis(); // Erro
																		// estava
																		// aqui!!!!
		AutoCompleteDecorator.decorate(comboBox_dificuldade);
		comboBox_dificuldade.addItem(" ");
		for (int i = 0; i < populateNiveis.length; i++) {
			comboBox_dificuldade.addItem(populateNiveis[i]);
		}
		// END

		JLabel lblSubmdulo = new JLabel("Sub-Modulo");
		lblSubmdulo.setBounds(235, 45, 84, 16);
		contentPane.add(lblSubmdulo);
		JLabel lblDificuldade = new JLabel("Dificuldade");
		lblDificuldade.setBounds(462, 45, 73, 16);
		contentPane.add(lblDificuldade);

		/* **InICIO BOTÕES*** */

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(12, 315, 97, 25);
		contentPane.add(btnAdicionar);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		// editar
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setBounds(135, 277, 97, 25);
		contentPane.add(btnEditar);

		// Apagar
		btnApagar = new JButton("Apagar");
		btnApagar.setEnabled(false);
		btnApagar.setBounds(244, 277, 97, 25);
		contentPane.add(btnApagar);
		
		
/****** Tabela ***/
//		carregarInterfazTabela();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 112, 633, 151);
		contentPane.add(scrollPane);
		tableData.setAutoscrolls(true);
		scrollPane.setViewportView(tableData);
//		tableData.setModel(getTableModel());
		tableData.setModel(questionTableModel);
		
//		tableData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//			
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				
//				if((tableData.getSelectedRow()==-1))
//						return;
//				else
//					System.out.println(tableData.getValueAt(tableData.getSelectedRow(), 1).toString());
//			}
//		});
		//END

		

		// Minhas Perguntas

		JButton btnMinhasPerguntas = new JButton("Minhas Perguntas");
		btnMinhasPerguntas.setBounds(12, 74, 156, 25);
		contentPane.add(btnMinhasPerguntas);
		btnMinhasPerguntas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// NOTA!! Temos depois de fazer verifiação caso nao tenha todos
				// os campos preenchidos se a string esta a passar null.
				minhaQuestao = true;
				btnEditar.setEnabled(minhaQuestao);
				btnApagar.setEnabled(minhaQuestao);
				subModuloEscolhido = (String) comboBox_submodulo
						.getSelectedItem();
				nivelDificuldade = (String) comboBox_dificuldade
						.getSelectedItem();
				System.out.println("Minhas perguntas? " + minhaQuestao + " "
						+ moduloEscolhido + " " + subModuloEscolhido + " "
						+ nivelDificuldade);
				
				listQuestions = controllerQuestions.aplicarFiltro(moduloEscolhido,
						subModuloEscolhido, nivelDificuldade, minhaQuestao,
						currentUser);
				questionTableModel.limpar();
				questionTableModel.addListaDeQuestion(listQuestions);
			}
		});
		// End

		/******* Outros Docentes ****/
		JButton btnPerguntasOutrosDocentes = new JButton("Outros Docentes");
		btnPerguntasOutrosDocentes.setBounds(202, 74, 139, 25);
		contentPane.add(btnPerguntasOutrosDocentes);
		btnPerguntasOutrosDocentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minhaQuestao = false;
				btnEditar.setEnabled(minhaQuestao);
				btnApagar.setEnabled(minhaQuestao);
				moduloEscolhido = (String) comboBox_modulo.getSelectedItem();
				subModuloEscolhido = (String) comboBox_submodulo.getSelectedItem();
				nivelDificuldade = (String) comboBox_dificuldade.getSelectedItem();

				System.out.println("Minhas Perguntas? " + minhaQuestao + " "
						+ moduloEscolhido + " " + subModuloEscolhido + " "
						+ nivelDificuldade);
				
				listQuestions = controllerQuestions.aplicarFiltro(moduloEscolhido,
						subModuloEscolhido, nivelDificuldade, minhaQuestao,
						currentUser);
				questionTableModel.limpar();
				questionTableModel.addListaDeQuestion(listQuestions);
				
				
			}
		});
		// end



	}



	// Métodos---Não está no diagrama sequencia.
	private String displayCurrentUser() {
		System.out.println(currentUser); // No relatorio está VOID
		// System.out.println(user.hashCode());
		return currentUser.getNome(); // fazer random para escolher um Docente
										// qualquer
	}
	
	public void preencherSubModulo(JComboBox<String> comboBox, String modulo) {
		comboBox.removeAllItems();
		comboBox.addItem(" ");
		String[] subModulosEscolhidos = controllerQuestions
				.loadSubModulos(modulo);
		for (int i = 0; i < subModulosEscolhidos.length; i++) {
			comboBox_submodulo.addItem(subModulosEscolhidos[i]);
		}
	}
	
	@SuppressWarnings("serial")
	public void carregarInterfazTabela(){
		String[][] x = {};
		String[] Colunas ={"Módulo" , "Sub-Modulo", "Nivel", "Pergunta"};
		dtm = new DefaultTableModel(x, Colunas)
	    {  
	        @Override  
	        public boolean isCellEditable(final int row, final int column) {  
	            return false;  
	        }  
	    };
		tableData.setModel(dtm);
	}
	
	public void carregarDados(Question q){
		dtm.insertRow(contador, new Object[]{});
		dtm.setValueAt(q.getModulo(), contador, 0);
		dtm.setValueAt(q.getSubModulo(), contador, 1);
		dtm.setValueAt(q.getNivel(), contador, 2);
		dtm.setValueAt(q.getPergunta(), contador, 3);
		contador++;
	}
	
	
}