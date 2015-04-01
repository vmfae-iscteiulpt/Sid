package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public ArrayList<Docente> getListDocentes() {
		ArrayList<Docente> lista = new ArrayList<Docente>();
		try {
			statement = conn.prepareStatement("SELECT * FROM Docente");
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				String email = resultSet.getString("EmailDocente");
				String nome = resultSet.getString("Nome");
				String password = resultSet.getString("Senha");
				Docente docente = new Docente(email, nome, password);
				lista.add(docente);
				
		//		System.out.println("existe "+lista.size() + "docentes na lista da base de dados!");
			}
			
		} catch (SQLException e) {
			System.err.println("problemas na ligação a base de dados, por favor tente novemente!");
			e.printStackTrace();
		}
		return lista;
	}
	

/*	public boolean inserirDocente(Docente docente) {
		try {
			statement = conn.prepareStatement("INSERT INTO Docente VALUES (?,?,?)");
			statement.setString(1, docente.getEmail());
			statement.setString(2, docente.getNome());
			statement.setString(3, docente.getPassword());
			int result = statement.executeUpdate();
			if(result == 1)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	
//	public int inserirZona(Zona zonaAInserir) {
//		try {
//			PreparedStatement sql = conn.prepareStatement("INSERT "
//					+ "INTO Zona VALUES (?, ?,?)");
//			
//			sql.setInt(1, zonaAInserir.getIdZona());
//			sql.setString(2, zonaAInserir.getCidade());
//			sql.setString(3, zonaAInserir.getDesignacao());
//			
//			return sql.executeUpdate();
//			
//		} catch (SQLException e) {
//			System.err.println("erro11!");
//			e.printStackTrace();
//		}
//		
//		
//		return 0;
//	}
	
	*/
}
