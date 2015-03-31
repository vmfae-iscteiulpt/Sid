package controller;

import java.util.ArrayList;

import model.Docente;

public class Controller {

	private Database database;
	
	public Controller(){
		database = new Database();
	}
	
	
	public boolean inserirDocente(Docente docente) {
		return database.inserirDocente(docente);
		
	}
	
	public ArrayList<Docente> verDocentes(){
		return database.verDocentes();
	}
}
