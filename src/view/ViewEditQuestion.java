package view;

//+//ALTERAR NOMES DE ACORDO COM O MODELO DE CLASSES
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEditQuestion extends JFrame {
	/**
*
*/
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ViewEditQuestion() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblMdulo = new JLabel("Modulo");
		lblMdulo.setBounds(12, 13, 44, 16);
		contentPane.add(lblMdulo);
		JLabel lblSubmdulo = new JLabel("Sub-M\u00F3dulo");
		lblSubmdulo.setBounds(235, 13, 73, 16);
		contentPane.add(lblSubmdulo);
		JLabel lblDificuldade = new JLabel("Dificuldade");
		lblDificuldade.setBounds(462, 13, 63, 16);
		contentPane.add(lblDificuldade);
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(563, 315, 97, 25);
		contentPane.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
		JComboBox comboBox_modulo = new JComboBox(new Object[] { null,
				"Matematica", "Portugues", // Teste com módulos
				"Portunhol", "Informatica", "Ciencias" });
		AutoCompleteDecorator.decorate(comboBox_modulo);
		comboBox_modulo.setEditable(true);
		comboBox_modulo.setBounds(82, 10, 113, 22);
		contentPane.add(comboBox_modulo);
		JComboBox comboBox_submodulo = new JComboBox();
		AutoCompleteDecorator.decorate(comboBox_submodulo);
		comboBox_submodulo.setEditable(true);
		comboBox_submodulo.setBounds(334, 10, 113, 22);
		contentPane.add(comboBox_submodulo, BorderLayout.NORTH);
		JComboBox comboBox_dificuldade = new JComboBox(new Object[] { null,
				"Muito Fácil", "Fácil", // Teste com dificuldades
				"Médio", "Dificil", "Muito Dificil" });
		AutoCompleteDecorator.decorate(comboBox_dificuldade);
		comboBox_dificuldade.setEditable(true);
		comboBox_dificuldade.setBounds(547, 13, 113, 22);
		contentPane.add(comboBox_dificuldade);
		JCheckBox chckbxEditar = new JCheckBox("Editar");
		chckbxEditar.setBounds(84, 35, 63, 25);
		contentPane.add(chckbxEditar);
		JCheckBox chckbxEditar_1 = new JCheckBox("Editar");
		chckbxEditar_1.setBounds(334, 35, 63, 25);
		contentPane.add(chckbxEditar_1);
		JButton btnGuardarAlteraes = new JButton("Guardar Alterações");
		btnGuardarAlteraes.setBounds(135, 315, 152, 25);
		contentPane.add(btnGuardarAlteraes);
		JLabel lblNewLabel = new JLabel("Pergunta");
		lblNewLabel.setBounds(12, 70, 56, 16);
		contentPane.add(lblNewLabel);
		JLabel lblExplicao = new JLabel("Explicação");
		lblExplicao.setBounds(12, 175, 73, 16);
		contentPane.add(lblExplicao);
		JLabel lblResposta = new JLabel("Resposta");
		lblResposta.setBounds(12, 262, 73, 16);
		contentPane.add(lblResposta);
		textField = new JTextField();
		textField.setBounds(81, 259, 25, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(99, 65, 339, 95);
		contentPane.add(textArea);
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(99, 172, 339, 80);
		contentPane.add(textArea_1);
		JButton btnUpload = new JButton("Upload"); // Deve criar um JoptionPane
		btnUpload.setBounds(456, 51, 97, 25);
		contentPane.add(btnUpload);
		JLabel lblUrl = new JLabel("url ficheiro");
		lblUrl.setBounds(565, 55, 65, 16);
		contentPane.add(lblUrl);
		JPanel panel = new JPanel(); // Container
		panel.setBackground(Color.WHITE);
		panel.setBounds(466, 82, 304, 225);
		contentPane.add(panel);
	}
}