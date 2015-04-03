package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import controller.ControllerQuestions;
import controller.DbConnection;

public class Docente {
	private String email;
	private String nome;
	private String password;

	
	//DB 
	private DbConnection dbConnection= new DbConnection();
	private Connection conn = dbConnection.getConn();
	private ResultSet resultSet = null;
	
	
	//contrutores
	public Docente() {
	}
	
	public Docente(String email, String nome, String password){
		this.email=email;
		this.nome=nome;
		this.password=password;
	//	dbConnection = new DbConnection();
	}
	
	
	//fim dos construtores

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
		ArrayList<Docente> lista = new ArrayList<Docente>();
		resultSet=dbConnection.select("SELECT * FROM Docente");
		try {
			while(resultSet.next()) {
				String email = resultSet.getString("Email_Docente");
				String nome = resultSet.getString("Nome");
				String password = resultSet.getString("Senha");
				Docente docente = new Docente(email, nome, password);
				lista.add(docente);
				
			}
			System.out.println("DB DONCENTE close? NEW "+conn.isClosed());
			conn.close();
			System.out.println("DB DONCENTE close?  NEW "+conn.isClosed());
						
		} catch (SQLException e) {
			System.err.println("problemas na ligação a base de dados, por favor tente novemente!");
			e.printStackTrace();
		}
		Random gerador=new Random();
		int randomDoncente= gerador.nextInt(lista.size());
		return lista.get(randomDoncente);
	}
	
	public String toString() {
		return "Docente [email=" + email + ", nome=" + nome 
				+ "]";
	}
	
	
}