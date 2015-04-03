package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Difficulty;
import model.Docente;

public class DbConnection {
	

	
	private Connection conn = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	
	public DbConnection(){
		
		String dbUrl = "jdbc:sqlanywhere:Tds:localhost:2638?eng=dbGroup9";
		try {
			conn = DriverManager.getConnection(dbUrl, "sid9", "sql9");
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("erro ao conectar a base de dados...");
			e.printStackTrace();
		}
	}
	
	
	public Connection getConn() {
		return conn;
	}

	public ResultSet select (String query){
		try {
			statement = conn.prepareStatement(query);
			resultSet = statement.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
		
	}
	
	
//LIXO
	public ArrayList<Difficulty> getListDificuldade() {
		ArrayList<Difficulty> listaDificuldade = new ArrayList<Difficulty>();
		
		try {
			statement = conn.prepareStatement("SELECT * FROM Nivel_Dificuldade");
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				String designacaoNivel = resultSet.getString("Designacao_Nivel");
		//		Difficulty dificuldade = new Difficulty();
				Difficulty d = new Difficulty(designacaoNivel);
				listaDificuldade.add(d);
//				System.out.println(d.getDesignacaoNivel());

			}	

			System.out.println("DB DIFI close?  "+conn.isClosed());
			conn.close();
			System.out.println("DB DIFI close? "+conn.isClosed());
		} catch (SQLException e) {
				System.err.println("problemas na ligação a base de dados, por favor tente novemente!");
				e.printStackTrace();
			}
	
			return listaDificuldade;
			
		}
	public void closeStatement(){
		try {
			statement.close();
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Recolha de dados dos modulos para o construtor do ModuleToSubModuleMap
	
	
	//public Map<String,ArrayList<String>> 

}
