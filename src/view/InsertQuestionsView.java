package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InsertQuestionsView extends JFrame {

	private JPanel contentPane;
	private JTextField searchModulo;
	private JTextField searchSubModulo;
	private JTextField campoPergunta;
	private JTextField campoExplicacao;
	private JTextField nRespostas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertQuestionsView frame = new InsertQuestionsView();
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
	public InsertQuestionsView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		searchModulo = new JTextField();
		searchModulo.setBounds(63, 10, 134, 28);
		contentPane.add(searchModulo);
		searchModulo.setColumns(10);
		
		JTextPane txtpnMdulo = new JTextPane();
		txtpnMdulo.setBackground(UIManager.getColor("Button.background"));
		txtpnMdulo.setText("Módulo: ");
		txtpnMdulo.setBounds(7, 15, 55, 16);
		contentPane.add(txtpnMdulo);
		
		JTextPane txtSubmodulo = new JTextPane();
		txtSubmodulo.setText("Sub-Modulo: ");
		txtSubmodulo.setBackground(UIManager.getColor("Button.background"));
		txtSubmodulo.setBounds(214, 15, 86, 16);
		contentPane.add(txtSubmodulo);
		
		searchSubModulo = new JTextField();
		searchSubModulo.setColumns(10);
		searchSubModulo.setBounds(300, 10, 134, 28);
		contentPane.add(searchSubModulo);
		
		JTextPane txtDificuldade = new JTextPane();
		txtDificuldade.setText("Dificuldade");
		txtDificuldade.setBackground(UIManager.getColor("Button.background"));
		txtDificuldade.setBounds(451, 15, 75, 16);
		contentPane.add(txtDificuldade);
		
		JComboBox cbxNivelDificuldade = new JComboBox();
		cbxNivelDificuldade.setModel(new DefaultComboBoxModel(new String[] {"Escolha o nivel"}));
		cbxNivelDificuldade.setToolTipText("Escolha o nivel");
		cbxNivelDificuldade.setBounds(533, 12, 157, 27);
		contentPane.add(cbxNivelDificuldade);
		
		JTextPane txtPergunta = new JTextPane();
		txtPergunta.setText("Pergunta:");
		txtPergunta.setEditable(false);
		txtPergunta.setBackground(UIManager.getColor("Button.background"));
		txtPergunta.setBounds(10, 60, 59, 16);
		contentPane.add(txtPergunta);
		
		JTextPane txtExplicacao = new JTextPane();
		txtExplicacao.setText("Explicação: ");
		txtExplicacao.setEditable(false);
		txtExplicacao.setBackground(UIManager.getColor("Button.background"));
		txtExplicacao.setBounds(10, 190, 68, 16);
		contentPane.add(txtExplicacao);
		
		JTextPane txtRespostas = new JTextPane();
		txtRespostas.setText("Respostas:");
		txtRespostas.setEditable(false);
		txtRespostas.setBackground(UIManager.getColor("Button.background"));
		txtRespostas.setBounds(10, 315, 68, 16);
		contentPane.add(txtRespostas);
		
		campoPergunta = new JTextField();
		campoPergunta.setBounds(82, 60, 467, 118);
		contentPane.add(campoPergunta);
		campoPergunta.setColumns(10);
		
		campoExplicacao = new JTextField();
		campoExplicacao.setBounds(82, 190, 467, 118);
		contentPane.add(campoExplicacao);
		campoExplicacao.setColumns(10);
		
		nRespostas = new JTextField();
		nRespostas.setBounds(82, 315, 47, 28);
		contentPane.add(nRespostas);
		nRespostas.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(561, 60, 219, 146);
		contentPane.add(textPane);
		
		JButton btUpload = new JButton("upload");
		btUpload.setBounds(556, 218, 87, 29);
		contentPane.add(btUpload);
		
		JTextPane txtUrlFicheiro = new JTextPane();
		txtUrlFicheiro.setBackground(UIManager.getColor("Button.background"));
		txtUrlFicheiro.setText("url ficheiro");
		txtUrlFicheiro.setBounds(640, 222, 69, 16);
		contentPane.add(txtUrlFicheiro);
		
		JButton btInserir = new JButton("Inserir");
		btInserir.setBounds(432, 315, 117, 29);
		contentPane.add(btInserir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(640, 316, 117, 29);
		contentPane.add(btnCancelar);
		

		
	
	}
}

