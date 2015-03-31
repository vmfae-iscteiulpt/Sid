package controller;

import java.util.ArrayList;

import model.Docente;

public class ControllerQuestions {

	private Database database;
	
	public ControllerQuestions(){
		database = new Database();
	}
	
	/*
	public boolean inserirDocente(Docente docente) {
		return database.inserirDocente(docente);
		
	}
	*/
	public ArrayList<Docente> verDocentes(){
		return database.verDocentes();
	}
}
