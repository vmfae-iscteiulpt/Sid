package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import model.Docente;
import controller.ControllerQuestions;

public class MainTest {
		private static ControllerQuestions controller = new ControllerQuestions();
		private static Docente user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user = new Docente(controller.verDocentes().get(i).getEmail(),controller.verDocentes().get(i).getNome(),controller.verDocentes().get(i).getPassword());
					QuestionsView frame = new QuestionsView(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		public static int getRandomNumber(){
			Random gerador=new Random();
			return gerador.nextInt(controller.verDocentes().size());
				}
		static int i=getRandomNumber();
		
	//	controller = new Controller();
	//	Docente docente = new Docente("vipsa@iscte.pt", "Vanessa", "vdfbdf");
	//	ArrayList<Docente> docentes = controller.verDocentes();
		//for (Docente d : docentes){
		//	System.out.println(d);

		//}
		
		
	
		
//		controller = new Controller();
//		Docente docente = new Docente("vipsa@iscte.pt", "Vanessa", "vdfbdf");
//		System.out.println(controller.inserirDocente(docente));
//	
//		ArrayList<Docente> docentes = controller.verDocentes();
//		for (Docente d : docentes) {
//			System.out.println(d);
//		}

}
