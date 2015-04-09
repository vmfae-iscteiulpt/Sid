package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.JButton;
import javax.swing.JTextPane;

import com.sun.corba.se.spi.ior.MakeImmutable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Docente;
import model.Question;

public class DetailsView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Question questionSelected;
	private Docente currentUser;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DetailsView(Question questionSelected, Docente user) {
		this.currentUser=user;
		this.questionSelected=questionSelected;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//Docente
		JLabel txtDocente = new JLabel("Docente:");
		txtDocente.setBounds(10, 10, 63, 16);
		contentPane.add(txtDocente);

		JLabel nomeDocente = new JLabel(currentUser.getNome());
		nomeDocente.setBounds(68, 10, 200, 16);
		nomeDocente.setEnabled(true);
		contentPane.add(nomeDocente);
//end
		
//Modulo
		JLabel txtModulo = new JLabel("Modulo:");
		txtModulo.setBounds(10, 38, 50, 16);
		contentPane.add(txtModulo);

		JLabel nomeModulo = new JLabel(questionSelected.getModulo());
		nomeModulo.setBounds(70, 38, 150, 16);
		nomeModulo.setEnabled(false);
		contentPane.add(nomeModulo);
//end
		
//Sub-modulo
		JLabel txtSubModulo = new JLabel("Sub-Modulo:");
		txtSubModulo.setBounds(200, 40, 80, 16);
		contentPane.add(txtSubModulo);

		JLabel nomeSubModulo = new JLabel(questionSelected.getSubModulo());
		nomeSubModulo.setBounds(280, 40, 180, 16);
		nomeSubModulo.setEnabled(false);
		contentPane.add(nomeSubModulo);
//end
		
//Nivel Dificuldade
		JLabel txtpnDificuldade = new JLabel("Dificuldade:");
		txtpnDificuldade.setBounds(400, 38, 72, 16);
		contentPane.add(txtpnDificuldade);

		JLabel nivelDificuldade = new JLabel();
		nivelDificuldade.setText(questionSelected.getNivel());
		nivelDificuldade.setBounds(480, 38, 161, 16);
		nivelDificuldade.setEnabled(false);
		contentPane.add(nivelDificuldade);
//end
		
//Pergunta
		JLabel txtPergunta = new JLabel("Pergunta:");
		txtPergunta.setBounds(10, 78, 59, 16);
		contentPane.add(txtPergunta);

		JTextPane campoPergunta = new JTextPane();
		campoPergunta.setBounds(85, 78, 400, 100);
		campoPergunta.setEditable(false);
		campoPergunta.setText(questionSelected.getPergunta());
		contentPane.add(campoPergunta);
//end
		
//Explicação
		JLabel txtExplicao = new JLabel("Explicacao:");
		txtExplicao.setBounds(10, 207, 75, 16);
		contentPane.add(txtExplicao);
		JTextPane campoExplicacao = new JTextPane();
		campoExplicacao.setBounds(85, 207, 400, 100);
		campoExplicacao.setEditable(false);
		campoExplicacao.setText(questionSelected.getExplicacao());
		contentPane.add(campoExplicacao);
//end
		
		
//Explicação
		JLabel txtAutorPergunta = new JLabel("Criada por:");
		txtAutorPergunta.setBounds(85, 270, 400, 100);
		contentPane.add(txtAutorPergunta);
		JLabel campoCriadorPergunta = new JLabel(questionSelected.getEmailDocente());
		campoCriadorPergunta.setBounds(155, 270, 200, 100);
		campoCriadorPergunta.setEnabled(false);
		contentPane.add(campoCriadorPergunta);
//end
		
		
//Link
		
		JLabel txtpnLink = new JLabel("Link da Imagem:");
		txtpnLink.setBounds(500, 78, 100, 20);
		contentPane.add(txtpnLink);
		JTextPane link = new JTextPane();
		link.setText(questionSelected.getLink());
		link.setBounds(500, 100, 180, 205);
		link.setEditable(false);
//		link.setEnabled(false);
		contentPane.add(link);
//end
		
//Botão Fechar		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(400, 336, 117, 29);
		contentPane.add(btnFechar);

		btnFechar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				dispose();
			}
		});
//end

//Resposta
		JLabel txtpnResposta = new JLabel("Respostas:");
		txtpnResposta.setBounds(10, 336, 70, 16);
		contentPane.add(txtpnResposta);

		JLabel textPane = new JLabel(""+questionSelected.getResposta());
		textPane.setEnabled(false);
		textPane.setBounds(80, 333, 23, 24);
		contentPane.add(textPane);
	}
	
	
	public static void main(String[] args) {
		
		DetailsView d = new DetailsView(new Question("portugues", "Lusiadas", "Facil", "o que é essa Pergunta dos lusiadas?", 3, "responde o que quisseremeoewnfoienwofinewofnoewn oin ewonoweno eon oefwef ewf wef wefwefwefwefwef wefwefwefwefwef wefwefwefwef wefewfwefwef wefwefwef wefwefwe fwefwef wef wef wefwefwef wefwefewf wefwef", "elelelelele", "victor@iscte.pt"), 
				new Docente("victor@iscte.pt", "Victor Andrade", "ekekkeke"));
		
		d.setVisible(true);
	}
}
