package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import model.Docente;
import model.ModuleToSubModuleMap;
import model.Question;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import controller.ControllerQuestions;

public class InsertQuestionsView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField modulo_cb;
	private JTextField submodule_cb;
	private JTextArea pergunta;
	private JTextArea explicacao;
	private JTextField resposta;
	private JComboBox<String> nivel_cb;
	private String linkFicheiro;
	private Docente currentUser;
	private ControllerQuestions controller;
	private String[] allModules;
	private ModuleToSubModuleMap mapModuleToSubModule;



	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public InsertQuestionsView(Docente user, ControllerQuestions controllerQuestion) {
		mapModuleToSubModule = new ModuleToSubModuleMap(currentUser);
		this.currentUser = user;
		this.controller = controllerQuestion;
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Preenche o módulo
		modulo_cb = new JTextField();
		modulo_cb.setBounds(63, 10, 134, 28);
		contentPane.add(modulo_cb);
		modulo_cb.setColumns(10);
		allModules = controller.loadModulos();
		ArrayList<String> allModulesList = new ArrayList<String>();
		Collections.addAll(allModulesList, allModules);
		AutoCompleteDecorator.decorate(modulo_cb, allModulesList, false);

		modulo_cb.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				String currText = "";
				try {

					Document doc = (Document) e.getDocument();
					currText = doc.getText(0, doc.getLength());
					boolean found = false;
					for (int i = 0; i < allModules.length; i++) {


						if(currText.equals(allModules[i])) {
							found = true;
						}

					}
					if (found) preencherSubModulo(submodule_cb, currText);

				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}

			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
			}

		});




		JLabel labelModule = new JLabel("Módulo");
		labelModule.setBounds(7, 15, 55, 16);
		contentPane.add(labelModule);

		JLabel labelSubModule = new JLabel("Sub-Módulo");
		labelSubModule.setBounds(214, 15, 86, 16);
		contentPane.add(labelSubModule);

		submodule_cb = new JTextField();
		submodule_cb.setColumns(10);
		submodule_cb.setBounds(300, 10, 134, 28);
		contentPane.add(submodule_cb);

		JLabel labelDificuldade = new JLabel("Dificuldade");
		labelDificuldade.setBounds(451, 15, 75, 16);
		contentPane.add(labelDificuldade);

		nivel_cb = new JComboBox<String>();
		nivel_cb.setEditable(true);
		nivel_cb.setBounds(533, 12, 157, 27);
		contentPane.add(nivel_cb);
		String[] niveis = controller.populateNiveis();

		// Prenche a combobox do grau de dificuldade
		AutoCompleteDecorator.decorate(nivel_cb);
		nivel_cb.addItem(" ");

		for (int i = 0; i < niveis.length; i++) {
			nivel_cb.addItem(niveis[i]);

		}


		JLabel labelPergunta = new JLabel("Pergunta");
		labelPergunta.setBounds(10, 60, 59, 16);
		contentPane.add(labelPergunta);

		JLabel labelExplicacao = new JLabel("Explicação");
		labelExplicacao.setBounds(10, 190, 68, 16);
		contentPane.add(labelExplicacao);

		JLabel labelResposta = new JLabel("Resposta");
		labelResposta.setBounds(10, 315, 68, 16);
		contentPane.add(labelResposta);

		pergunta = new JTextArea();
		pergunta.setBounds(82, 60, 467, 118);
		contentPane.add(pergunta);
		pergunta.setColumns(10);

		explicacao = new JTextArea();
		explicacao.setBounds(82, 190, 467, 118);
		contentPane.add(explicacao);
		explicacao.setColumns(10);

		resposta = new JTextField();
		resposta.setBounds(82, 315, 47, 28);
		contentPane.add(resposta);
		resposta.setColumns(10);

		// Sítio para a imagem
		final JTextPane imageSpace = new JTextPane();
		imageSpace.setBounds(561, 60, 219, 146);
		contentPane.add(imageSpace);
		imageSpace.setEditable(false);


		JButton btUpload = new JButton("upload");
		btUpload.setBounds(556, 218, 80, 29);
		contentPane.add(btUpload);
		final InsertQuestionsView self = this;

		btUpload.addActionListener(new ActionListener() {

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
						// Insere a imagem
						String filePath = file.getAbsolutePath();
						Icon imagem = new ImageIcon(filePath);
						imageSpace.setText("");
						imageSpace.insertIcon(imagem);
					}
					else
						// Erro se não for imagem
						JOptionPane.showMessageDialog(self,"O ficheiro tem de ser uma imagem.","Not Image",JOptionPane.ERROR_MESSAGE);
				}


			}


		});



		JLabel labelURL = new JLabel("URL do ficheiro");
		labelURL.setBounds(640, 222, 91, 25);
		contentPane.add(labelURL);

		JButton btInserir = new JButton("Inserir");
		btInserir.setBounds(432, 315, 117, 29);
		contentPane.add(btInserir);



		btInserir.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Verificação do preenchimento de todos os campos
				if(pergunta.getText().isEmpty() || resposta.getText().isEmpty() || explicacao.getText().isEmpty()
						|| modulo_cb.getText().isEmpty() || submodule_cb.getText().isEmpty() || imageSpace.getText().isEmpty()
						|| nivel_cb.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(null,
							"Existem campos por preencher!", "Error Message",
							JOptionPane.ERROR_MESSAGE);
				} else {
					boolean encontrado = false;
					for (int i = 0; i < allModules.length; i++) {
						if(modulo_cb.getText().equals(allModules[i])) {
							encontrado = true;
							break;
						}

					}
					// Insere módulo na base de dados se este não lá existir
					if(!encontrado) {
						self.mapModuleToSubModule.insertModule(modulo_cb.getText());

					}
					encontrado = false;

					String[] subModules = mapModuleToSubModule.getSubModules(modulo_cb.getText());
					for (int j = 0; j < subModules.length; j++) {
						if(submodule_cb.getText().equals(subModules[j])){
							encontrado = true;
							break;

						}

					}
					// Insere sub-módulo na base de dados se este não lá existir
					if(!encontrado) {
						self.mapModuleToSubModule.insertSubModule(modulo_cb.getText(), submodule_cb.getText());
					}

					//Question question = new Question(modulo_cb.getText(), submodule_cb.getText(), nivel_cb.getSelectedItem().toString(), pergunta.getText(), Integer.parseInt(resposta.getText()), explicacao.getText(), linkFicheiro, currentUser.getEmail());
					controller.insertQuestion( modulo_cb.getText(), submodule_cb.getText(), nivel_cb.getSelectedItem().toString(), currentUser.getEmail(),Integer.parseInt(resposta.getText()), pergunta.getText(), explicacao.getText(), linkFicheiro);
					
					JOptionPane.showMessageDialog(null,
							"Questão inserida na base de dados.", "Confirmation Message",
							JOptionPane.INFORMATION_MESSAGE);

					modulo_cb.setText("");
					submodule_cb.setText("");
					pergunta.setText("");
					explicacao.setText("");
					resposta.setText("");
					nivel_cb.setSelectedItem(null);
					imageSpace.setText("");
					
					

				}



			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(640, 316, 117, 29);
		contentPane.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				dispose();
			}
		});





	}




	public void preencherSubModulo(JTextField textfield, String modulo) {
		textfield.setText("");
		String[] subModulos = controller.loadSubModulos(modulo);
		ArrayList<String> allSubModulesList = new ArrayList<String>();
		Collections.addAll(allSubModulesList, subModulos);
		AutoCompleteDecorator.decorate(textfield, allSubModulesList, false);
	}


	private boolean isImage(File file)
	{
		String name=file.getName();
		return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg") || name.endsWith(".gif");
	}
	
	
}
