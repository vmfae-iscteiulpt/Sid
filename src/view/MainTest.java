package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import model.Docente;
import controller.Controller;

public class MainTest {
	private static Controller controller;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEditQuestion frame = new ViewEditQuestion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		controller = new Controller();
		Docente docente = new Docente("vipsa@iscte.pt", "Vanessa", "vdfbdf");
		System.out.println(controller.inserirDocente(docente));
		ArrayList<Docente> docentes = controller.verDocentes();
		for (Docente d : docentes){
			System.out.println(d);

		}
		
		
	}
		
//		controller = new Controller();
//		Docente docente = new Docente("vipsa@iscte.pt", "Vanessa", "vdfbdf");
//		System.out.println(controller.inserirDocente(docente));
//	
//		ArrayList<Docente> docentes = controller.verDocentes();
//		for (Docente d : docentes) {
//			System.out.println(d);
//		}

}
