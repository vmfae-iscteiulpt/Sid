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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.JTextArea;

public class DetailsView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DetailsView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane txtDocente = new JTextPane();
		txtDocente.setEditable(false);
		txtDocente.setBackground(UIManager.getColor("Button.background"));
		txtDocente.setText("Docente:");
		txtDocente.setBounds(10, 10, 63, 16);
		contentPane.add(txtDocente);

		JTextPane nomeDocence = new JTextPane();
		nomeDocence.setEnabled(false);
		nomeDocence.setEditable(false);
		nomeDocence.setBackground(UIManager.getColor("Button.background"));
		nomeDocence.setText("Anibal das Couves");
		nomeDocence.setBounds(75, 10, 152, 16);
		contentPane.add(nomeDocence);

		JTextPane txtModulo = new JTextPane();
		txtModulo.setText("Modulo:");
		txtModulo.setEditable(false);
		txtModulo.setBackground(UIManager.getColor("Button.background"));
		txtModulo.setBounds(10, 38, 51, 16);
		contentPane.add(txtModulo);

		JTextPane nomeModulo = new JTextPane();
		nomeModulo.setBackground(UIManager.getColor("Button.background"));
		nomeModulo.setEnabled(false);
		nomeModulo.setEditable(false);
		nomeModulo.setText("<<nome do modulo>>");
		nomeModulo.setBounds(72, 38, 147, 16);
		contentPane.add(nomeModulo);

		JTextPane txtSubModulo = new JTextPane();
		txtSubModulo.setText("Sub-Modulo:");
		txtSubModulo.setEditable(false);
		txtSubModulo.setBackground(UIManager.getColor("Button.background"));
		txtSubModulo.setBounds(243, 38, 82, 16);
		contentPane.add(txtSubModulo);

		JTextPane nomeSubModulo = new JTextPane();
		nomeSubModulo.setBackground(UIManager.getColor("Button.background"));
		nomeSubModulo.setText("<<nome do sub-modulo>>");
		nomeSubModulo.setEnabled(false);
		nomeSubModulo.setEditable(false);
		nomeSubModulo.setBounds(337, 38, 178, 16);
		contentPane.add(nomeSubModulo);

		JTextPane txtpnDificuldade = new JTextPane();
		txtpnDificuldade.setText("Dificuldade");
		txtpnDificuldade.setEditable(false);
		txtpnDificuldade.setBackground(UIManager.getColor("Button.background"));
		txtpnDificuldade.setBounds(538, 38, 72, 16);
		contentPane.add(txtpnDificuldade);

		JTextPane grauDificuldade = new JTextPane();
		grauDificuldade.setBackground(UIManager.getColor("Button.background"));
		grauDificuldade.setText("<<grau de dificuldade>>");
		grauDificuldade.setEnabled(false);
		grauDificuldade.setEditable(false);
		grauDificuldade.setBounds(622, 38, 161, 16);
		contentPane.add(grauDificuldade);

		JTextPane txtPergunta = new JTextPane();
		txtPergunta.setText("Pergunta:");
		txtPergunta.setEditable(false);
		txtPergunta.setBackground(UIManager.getColor("Button.background"));
		txtPergunta.setBounds(10, 78, 59, 16);
		contentPane.add(txtPergunta);

		JTextPane campoPergunta = new JTextPane();
		campoPergunta.setBounds(85, 78, 443, 117);
		contentPane.add(campoPergunta);

		JTextPane campoExplicacao = new JTextPane();
		campoExplicacao.setBounds(85, 207, 443, 117);
		contentPane.add(campoExplicacao);

		JTextPane txtExplicao = new JTextPane();
		txtExplicao.setText("Explicacao: ");
		txtExplicao.setEditable(false);
		txtExplicao.setBackground(UIManager.getColor("Button.background"));
		txtExplicao.setBounds(10, 207, 75, 16);
		contentPane.add(txtExplicao);

		JTextPane imagem = new JTextPane();
		imagem.setBounds(538, 78, 242, 246);
		contentPane.add(imagem);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(622, 336, 117, 29);
		contentPane.add(btnFechar);

		btnFechar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				dispose();
			}
		});






		JTextPane txtpnResposta = new JTextPane();
		txtpnResposta.setText("Respostas:");
		txtpnResposta.setEditable(false);
		txtpnResposta.setBackground(UIManager.getColor("Button.background"));
		txtpnResposta.setBounds(10, 336, 68, 16);
		contentPane.add(txtpnResposta);

		JTextPane textPane = new JTextPane();
		textPane.setText("0");
		textPane.setEnabled(false);
		textPane.setEditable(false);
		textPane.setBackground(SystemColor.window);
		textPane.setBounds(80, 336, 23, 24);
		contentPane.add(textPane);








	}
}
