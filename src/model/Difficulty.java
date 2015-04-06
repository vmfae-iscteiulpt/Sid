package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import controller.DbConnection;

public class Difficulty {
	private String designacaoNivel;
	private int idNivel; // Não tem ID no relatorio.Talvez nao seja preciso
	private DbConnection dbConnection = new DbConnection();
	private Connection conn = dbConnection.getConn();
	private ResultSet resultSet = null;

	public Difficulty(String designacaoNivel) {
		this.designacaoNivel = designacaoNivel;
	}

	public Difficulty() {
		// this.conn=conn;
	}

	public String getDesignacaoNivel() {
		return designacaoNivel;
	}

	public int getIdNivel() {
		return idNivel;
	}

	public String[] populateNiveis() { // O PROBLEMA ESTÁ AQUI
		ArrayList<Difficulty> listaDificuldade = new ArrayList<Difficulty>();
		try {
			resultSet = dbConnection.select("SELECT * FROM Nivel_Dificuldade");
			while (resultSet.next()) {
				String designacaoNivel = resultSet
						.getString("Designacao_Nivel");
				Difficulty d = new Difficulty(designacaoNivel);
				listaDificuldade.add(d);
			}
			System.out.println("DB DIFI close? " + conn.isClosed());
			conn.close();
			System.out.println("DB DIFI close? " + conn.isClosed());
		} catch (SQLException e) {
			System.err
					.println("problemas na ligação a base de dados, por favor tente novemente!");
			e.printStackTrace();
		}
		String[] dificuldade = new String[listaDificuldade.size()];
		for (int i = 0; i < dificuldade.length; i++) {
			dificuldade[i] = listaDificuldade.get(i).getDesignacaoNivel();
		}
		return dificuldade;
	}
}