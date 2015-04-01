package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import model.Docente;
import controller.ControllerQuestions;

public class MainTest {
	private static Docente user;	
	private static ControllerQuestions controller = new ControllerQuestions(user);
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user = new Docente(controller.verDocentes().get(1).getEmail(),controller.verDocentes().get(1).getNome(),controller.verDocentes().get(1).getPassword());
				//	System.out.println(user.hashCode());
					QuestionsView frame = new QuestionsView(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*	public static int getRandomNumber(){
			Random gerador=new Random();
			return gerador.nextInt(user.verDocentes().size());
				}
		static int i=getRandomNumber();
		*/
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
