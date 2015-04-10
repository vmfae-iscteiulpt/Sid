package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JTextPane;

import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.SpringLayout;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import model.Docente;
import model.Question;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import controller.ControllerQuestions;
import sun.applet.Main;

public class InsertQuestionsView extends JFrame {

	private JPanel contentPane;
	private JTextField searchModulo;
	private JTextField searchSubModulo;
	private JTextField campoPergunta;
	private JTextField campoExplicacao;
	private JTextField nRespostas;
	private Docente currentUser;
	private ControllerQuestions controller;
	List<String> listModulos = new ArrayList<String>();
	private String[] loadModulo;
	private String[] SubloadModulo;
	private String moduloEscolhido = new String(" ");
	private boolean temSubmodulo = false;
	private int count =0;
	private List<String> listSubModulo =  new ArrayList<String>();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public InsertQuestionsView(Docente user, ControllerQuestions controllerQuestion) {
		this.currentUser=user;
		this.controller = controllerQuestion;
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
//Sub-Modulo
		JLabel txtSubmodulo = new JLabel("Sub-Modulo:");
		txtSubmodulo.setBounds(214, 15, 86, 16);
		contentPane.add(txtSubmodulo);

		searchSubModulo = new JTextField();
		searchSubModulo.setBounds(300, 10, 134, 28);
		contentPane.add(searchSubModulo);
//End

//Modulo
		JLabel txtpnMdulo = new JLabel("Módulo:");;
		txtpnMdulo.setBounds(7, 15, 55, 16);
		contentPane.add(txtpnMdulo);
		loadModulo = controller.loadModulos();
		for (int i = 0; i < loadModulo.length; i++) {
			listModulos.add(loadModulo[i]);
		}		
		searchModulo = new JTextField();
		searchModulo.setBounds(63, 10, 134, 28);
		contentPane.add(searchModulo);
		AutoCompleteDecorator.decorate(searchModulo, listModulos, false);
		
		searchModulo.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) { //Este metodo ao fazer uma 2 pesquisa no modulo torna a app lenta... corregir!!!
				moduloEscolhido =  searchModulo.getText();
				if(count < 1){
					for (int i = 0; i < listModulos.size(); i++) {
						if(listModulos.get(i).equals(moduloEscolhido)){
							SubloadModulo = controller.loadSubModulos(moduloEscolhido);
							temSubmodulo=true;
							sugestaoSubmodulo(temSubmodulo, SubloadModulo);
						}
					}
				}


			}


		});
//End
		

		
//Nivel Dificuldade
		JLabel txtDificuldade = new JLabel("Dificuldade:");
		txtDificuldade.setBounds(451, 15, 75, 16);
		contentPane.add(txtDificuldade);

		JComboBox<String> cbxNivelDificuldade = new JComboBox<String>();
		cbxNivelDificuldade.setBounds(533, 12, 100, 27);
		contentPane.add(cbxNivelDificuldade);
		AutoCompleteDecorator.decorate(cbxNivelDificuldade);
		String[] nivelDificuldade = controller.populateNiveis();
		cbxNivelDificuldade.addItem(" ");
		for (int i = 0; i < nivelDificuldade.length; i++) {
			cbxNivelDificuldade.addItem(nivelDificuldade[i]);
		}
		
//End
		
//Pergunta
		JLabel txtPergunta = new JLabel("Pergunta:");
		txtPergunta.setBounds(10, 60, 59, 16);
		contentPane.add(txtPergunta);
			
		campoPergunta = new JTextField();
		campoPergunta.setBounds(82, 60, 400, 118);
		contentPane.add(campoPergunta);
		campoPergunta.setColumns(10);
//end
		
//Explicação
		JLabel txtExplicacao = new JLabel("Explicação:");
		txtExplicacao.setBounds(10, 190, 68, 16);
		contentPane.add(txtExplicacao);
		
		campoExplicacao = new JTextField();
		campoExplicacao.setBounds(82, 190, 400, 118);
		contentPane.add(campoExplicacao);
//END

//Respostas
		JLabel txtRespostas = new JLabel("Respostas:");
		txtRespostas.setBounds(10, 315, 68, 16);
		contentPane.add(txtRespostas);
		
		nRespostas = new JTextField();
		nRespostas.setBounds(82, 315, 47, 28);
		contentPane.add(nRespostas);
//End
		



//Link
		JLabel textLink = new JLabel("url da imagem");
		textLink.setBounds(500, 60, 100, 10);
		contentPane.add(textLink);
		
		JButton btUpload = new JButton("upload");
		btUpload.setBounds(500, 200, 80, 20);
		contentPane.add(btUpload);

		JTextField txtUrlFicheiro = new JTextField();
		txtUrlFicheiro.setBounds(500, 80, 170, 100);
		contentPane.add(txtUrlFicheiro);

		
/*********************** **Botões** ***************************/
		JButton btInserir = new JButton("Inserir");
		btInserir.setBounds(380, 315, 100, 29);
		contentPane.add(btInserir);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(550, 315, 100, 29);
		contentPane.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				dispose();
			}
		});

	}
	
	
	private void sugestaoSubmodulo(boolean temSubm,
			String[] subloadModulo) {
			searchSubModulo.setText(" ");
			for (int i = 0; i < SubloadModulo.length; i++) {
				listSubModulo.add(SubloadModulo[i]);
			}
			AutoCompleteDecorator.decorate(searchSubModulo, listSubModulo, false);
			temSubmodulo=false;
		
	}
	public static void main(String[] args) {
		InsertQuestionsView i = new InsertQuestionsView(new Docente(), new ControllerQuestions(new Docente()));
		i.setVisible(true);
	}
}

