package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DbConnection;

public class Difficulty {

	private DbConnection dbConnection;
	private Connection conn;
	private String designacaoNivel;
	private int idNivel; //Não tem ID no relatorio.Talvez nao seja preciso

	//	private String

	public Difficulty(String designacaoNivel){
		this.designacaoNivel=designacaoNivel;
	}
	public Difficulty(){
		//this.conn=conn;
	}

	public String getDesignacaoNivel() {
		return designacaoNivel;
	}

	public int getIdNivel() {
		return idNivel;
	}

	public String[]populateNiveis(){ 
		dbConnection=new DbConnection();
		conn = dbConnection.getConn();
		ArrayList<Difficulty> listaDificuldade = new ArrayList<Difficulty>();
		
		try {
			ResultSet resultSet = dbConnection.select("SELECT * FROM Nivel_Dificuldade");
			while(resultSet.next()) {
				String designacaoNivel = resultSet.getString("Designacao_Nivel");
				Difficulty d = new Difficulty(designacaoNivel);
				listaDificuldade.add(d);
			}	

			System.out.println("DB DIFI close?  "+conn.isClosed());
			dbConnection.closeStatement();
			System.out.println("DB DIFI close? "+conn.isClosed());
		} catch (SQLException e) {
				System.err.println("problemas na ligação a base de dados, por favor tente novemente!");
				e.printStackTrace();
		}
		System.out.println(listaDificuldade.size());
		String [] dificuldade= new String[listaDificuldade.size()];

		for( int i=0;i < dificuldade.length;i++){
			dificuldade[i]=listaDificuldade.get(i).getDesignacaoNivel();

		}
		return dificuldade;
	}

}
