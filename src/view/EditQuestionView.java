package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Docente;
import model.Question;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;












import controller.ControllerQuestions;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

public class EditQuestionView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControllerQuestions controladorQuestion;
	private JComboBox<String> module_cb;
	private JComboBox<String> submodule_cb;
	private JComboBox<String> nivel;
	private String linkFicheiro;
	private JTextArea pergunta; //Estava como Field
	private JTextArea explicacao; //Estava como Field
	private JTextField resposta;  
	private Question questionSelected;
	private Docente currentUser;
	private String moduloEscolhido = new String("");
	private String SubModuloEscolhido= new String("");
	private String[] vetorModulos;
	private JCheckBox checkbxEditarModulo = new JCheckBox("Editar");
	private JTextPane link = new JTextPane();
	private Question newQuestion;
	private int n =0;
	
	/**
	 * Launch the application.
	 */




//	public ViewEditQuestion(Question question, Docente user) {
	public EditQuestionView(Question question, ControllerQuestions controlador, Docente user) {
		this.controladorQuestion = controlador;
		this.currentUser = user;
		this.questionSelected = question;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//LABELS

		JLabel lblMdulo = new JLabel("Modulo");
		lblMdulo.setBounds(12, 13, 44, 16);
		contentPane.add(lblMdulo);

		JLabel lblSubmdulo = new JLabel("Sub-Modulo");
		lblSubmdulo.setBounds(235, 13, 73, 16);
		contentPane.add(lblSubmdulo);

		JLabel lblDificuldade = new JLabel("Dificuldade");
		lblDificuldade.setBounds(462, 13, 63, 16);
		contentPane.add(lblDificuldade);

		JLabel lblNewLabel = new JLabel("Pergunta");
		lblNewLabel.setBounds(12, 70, 56, 16);
		contentPane.add(lblNewLabel);

		JLabel lblExplicao = new JLabel("Explicação");
		lblExplicao.setBounds(12, 175, 73, 16);
		contentPane.add(lblExplicao);

		JLabel lblResposta = new JLabel("Resposta");
		lblResposta.setBounds(12, 262, 73, 16);
		contentPane.add(lblResposta);

		JLabel lblUrl = new JLabel("url ficheiro");
		lblUrl.setBounds(565, 55, 65, 16);
		contentPane.add(lblUrl);

		//END LABELS

		  
		link.setBackground(Color.WHITE);
		link.setBounds(466, 82, 304, 225);
		contentPane.add(link);
		//BUTTONS

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(563, 315, 97, 25);
		contentPane.add(btnSair);

		btnSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				dispose();
			}
		});


		JButton btnGuardarAlteracoes = new JButton("Guardar Alterações");
		btnGuardarAlteracoes.setBounds(135, 315, 152, 25);
		contentPane.add(btnGuardarAlteracoes);
		btnGuardarAlteracoes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String newPergunta = pergunta.getText();
				String newExplicacao = explicacao.getText();
				int newResposta = Integer.parseInt(resposta.getText());
				String newLink = link.getText() ;
				String newModulo = (String) module_cb.getSelectedItem();
				String newSubModulo = (String) submodule_cb.getSelectedItem();
				String newNivel= (String) nivel.getSelectedItem();
				
				if(!questionSelected.getModulo().equals(newModulo) || questionSelected.equals(newPergunta)){
					System.out.println("o Texto é unique ou o modulo é igual...r");//apaga-se a pergunta e insere-se una nova!
					
				}else{//update aos campos todos!!
//					System.out.println("resposta.." + newResposta); Colocar uma exepçao se tiver  receber letras...
					newQuestion= new Question(questionSelected.getIdQuestion(), questionSelected.getModulo(), newSubModulo, newNivel, 
							newPergunta, newResposta, newExplicacao, newLink, currentUser.getEmail());
					controladorQuestion.submittChanges(newQuestion);
				}
						
			}
		});

		
		JButton btnUpload = new JButton("Upload"); //Deve criar um JoptionPane
		btnUpload.setBounds(456, 51, 97, 25);
		contentPane.add(btnUpload);

		final EditQuestionView self = this;

		btnUpload.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				linkFicheiro = "C:\\Users\\User\\Desktop";
				JFileChooser fileChooser = new JFileChooser(linkFicheiro);

				int option=fileChooser.showOpenDialog(self);

				if(option==JFileChooser.APPROVE_OPTION)
				{
					File file=fileChooser.getSelectedFile();
					if(isImage(file))
					{
						// Insert the icon
						String filePath = file.getAbsolutePath();
						Icon imagem = new ImageIcon(filePath);
						link.setText("");
						link.insertIcon(imagem);
					}
					else
						// Show an error message, if not an image
						JOptionPane.showMessageDialog(self,"The file is not an image.","Not Image",JOptionPane.ERROR_MESSAGE);
				}


			}


		});

		//END BUTTONS

		//COMBOBOX
		module_cb = new JComboBox<String>();
		module_cb.setBounds(82, 10, 113, 22);	
		module_cb.setEditable(true);
		AutoCompleteDecorator.decorate(module_cb);
		contentPane.add(module_cb);
		moduloEscolhido=question.getModulo();
		module_cb.addItem(question.getModulo());
		module_cb.addItem(" ");
		vetorModulos =controlador.loadModulos();
		for (int i = 0; i < vetorModulos.length; i++) {
			module_cb.addItem(vetorModulos[i]);
		}
		contentPane.add(module_cb);
		
	module_cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (module_cb.getSelectedItem() == null && n ==0 ) {
//					JOptionPane.showMessageDialog(null, "Não tem nenhum modulo selecionado, por favor selecione um modulo");
					submodule_cb.removeAllItems();
					n++;
					//submodule_cb.addItem(" ");
				} else {
					// System.out.println((comboBox_submodulo.getSelectedItem()));
					for (int i = 0; i < vetorModulos.length; i++) {
						if (module_cb.getSelectedItem().equals(
								vetorModulos[i])) {
							moduloEscolhido = vetorModulos[i];
							preencherSubModulo(submodule_cb,
									moduloEscolhido);
						}
					}
					n=0;
				}
			}
		});

		submodule_cb = new JComboBox<String>();
		submodule_cb.setBounds(334, 10, 113, 22);
		submodule_cb.setEditable(true);
		AutoCompleteDecorator.decorate(submodule_cb);
		SubModuloEscolhido=questionSelected.getSubModulo();
		
		submodule_cb.addItem(questionSelected.getSubModulo());
		submodule_cb.addItem(" ");
		contentPane.add(submodule_cb, BorderLayout.NORTH);
//		SubModuloEscolhido = (String) submodule_cb.getSelectedItem();
		
		nivel = new JComboBox<String>();
		nivel.setBounds(547, 13, 113, 22);
		nivel.setEditable(true);
		AutoCompleteDecorator.decorate(nivel);
		
		nivel.addItem(questionSelected.getNivel());
		nivel.addItem(" ");
		String[] populateNiveis = controladorQuestion.populateNiveis();
		for (int i = 0; i < populateNiveis.length; i++) {
			nivel.addItem(populateNiveis[i]);
		}
		contentPane.add(nivel);

		//END COMBOBOX

		//CHECKBOX

		checkbxEditarModulo.setBounds(84, 35, 63, 25);
		contentPane.add(checkbxEditarModulo);
			checkbxEditarModulo.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e) {
					if(checkbxEditarModulo.isSelected()){
						String novoModulo = controladorQuestion.openStringChanger(questionSelected.getModulo());
						if(novoModulo == null){
							return;
						}else{
							System.out.println("Estou a abrir uma nova janela cujo modulo antigo é: "+ questionSelected.getModulo() + 
									 " e foi introduzido um NOVO Mod "+novoModulo);
							moduloEscolhido=novoModulo;
							module_cb.removeAllItems();
							module_cb.addItem(novoModulo);
							String[] listaNovoModulos = controladorQuestion.loadModulos();
							for (int i = 0; i < listaNovoModulos.length; i++) {
								module_cb.addItem(listaNovoModulos[i]);
							}
//							module_cb.addItem(" ");
//							module_cb.addItem(novoModulo);
//							module_cb.addItem(" ");
						}
						

//						checkbxEditarModulo.setSelected(true);
						
					}
				}

			});

			
			
		JCheckBox checkbxEditarSubModulo = new JCheckBox("Editar");
		checkbxEditarSubModulo.setBounds(334, 35, 63, 25);
		contentPane.add(checkbxEditarSubModulo);

		//END CHECKBOX


		//TEXT FIELDS

		resposta = new JTextField();
		resposta.setBounds(81, 259, 25, 22);
		resposta.setText((String.valueOf(question.getResposta())));
		resposta.setColumns(10);
		contentPane.add(resposta);
		
		
		pergunta = new JTextArea();
		pergunta.setBounds(99, 65, 339, 95);
		pergunta.setText(question.getPergunta());
		contentPane.add(pergunta);
		

		explicacao = new JTextArea();
		explicacao.setBounds(99, 172, 339, 80);
		explicacao.setText(question.getExplicacao());
		contentPane.add(explicacao);

	//END TEXTFIELDS
	}
	//Métodos
	private boolean isImage(File file)
	{
		String name=file.getName();
		return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg") || name.endsWith(".gif");
	}
	private void preencherSubModulo(JComboBox<String> comboBox, String modulo) {
		comboBox.removeAllItems();
		comboBox.addItem(" ");
		String[] subModulosEscolhidos = controladorQuestion
				.loadSubModulos(modulo);
		for (int i = 0; i < subModulosEscolhidos.length; i++) {
			submodule_cb.addItem(subModulosEscolhidos[i]);
		}
	}

	
}


