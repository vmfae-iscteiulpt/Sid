package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
	private Connection conn = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	public DbConnection() {
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

	public ResultSet select(String query) {
		try {
			statement = conn.prepareStatement(query);
			resultSet = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	public void closeStatement() {
		try {
			statement.close();
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}