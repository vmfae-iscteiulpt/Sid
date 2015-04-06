package view;

import java.awt.EventQueue;
import model.Docente;
import controller.ControllerQuestions;

public class MainTest {
	private static Docente user;
	private static ControllerQuestions controller = new ControllerQuestions(
			user);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user = controller.currentDocente();
					QuestionsView frame = new QuestionsView(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}