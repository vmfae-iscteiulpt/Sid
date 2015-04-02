package model;

import java.util.ArrayList;
import java.util.Random;

import controller.ControllerQuestions;
import controller.DbConnection;

public class Docente {
	private String email;
	private String nome;
	private String password;
	//private ControllerQuestions controller=new ControllerQuestions();
	private DbConnection dbConnection= new DbConnection();
	
	
	public Docente() {
	}
	
	public Docente(String email, String nome, String password){
		this.email=email;
		this.nome=nome;
		this.password=password;
	//	dbConnection = new DbConnection();
	}
	
	public String toString() {
		return "Docente [email=" + email + ", nome=" + nome 
				+ "]";
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Docente currentDocente(){ //recebe um docente da base de dados
		ArrayList<Docente> listDocente = dbConnection.getListDocentes();
		
		Random gerador=new Random();
		int randomDoncente= gerador.nextInt(listDocente.size());
		return listDocente.get(randomDoncente);
		
	}
	

	
	
	
}
