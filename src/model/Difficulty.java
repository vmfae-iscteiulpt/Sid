package model;

import java.util.ArrayList;

import controller.DbConnection;

public class Difficulty {
	
	
	private String designacaoNivel;
	private int idNivel; //Não tem ID no relatorio.Talvez nao seja preciso
	private DbConnection conn=new DbConnection();
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
	
	public String[]populateNiveis(){ //O PROBLEMA ESTÁ AQUI
		ArrayList<Difficulty> dif= conn.getListDificuldade();
		String [] dificuldade= new String[dif.size()];
		
			for( int i=0;i < dificuldade.length;i++){
				dificuldade[i]=dif.get(i).getDesignacaoNivel();
				
			}
			return dificuldade;
	}
	
}
