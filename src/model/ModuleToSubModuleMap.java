package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import controller.DbConnection;

public class ModuleToSubModuleMap {


	private ArrayList<String> modules = new ArrayList<String>();  //Relatorio esta com letra maiuscula
	private Map<String,ArrayList<String>> modulesSubModelsMap;
	private ArrayList<String> currentUserModules;
	private Map<String,ArrayList<String>> currentUserModulesSubModelsMap;
	private Docente currentUser;
	//DB 
	private DbConnection dbConnection;
	private Connection conn ;
	private ResultSet resultSet = null;


	public ModuleToSubModuleMap(Docente currentUser){
		this.currentUser=currentUser;

	}

	public String[] getModules(){
		dbConnection = new DbConnection();
		conn = dbConnection.getConn();
		String[] listaModulos;
		try {
			//INICIO RECOLHA MODULOS GENERICOS
			resultSet =dbConnection.select("SELECT Designacao_Modulo FROM Modulo");
			while(resultSet.next()) {
				String modulo  = resultSet.getString("Designacao_Modulo");
				String m = new String(modulo);
				modules.add(m);
				System.out.println(m);
			}	
			System.out.println("Modulos "+conn.isClosed());

			dbConnection.closeStatement();
			conn.close();
			System.out.println("Modulos "+conn.isClosed());
		} catch (SQLException e) {
			System.err.println("problemas na ligação a base de dados, por favor tente novemente!");
			e.printStackTrace();
			//FIM  RECOLHA MODULOS GENERICOS
		}

		Collections.sort(modules);  //ORDENAR lISTA
		listaModulos = new String[modules.size()];
		for(int i=0;i<listaModulos.length;i++){
			listaModulos[i]=modules.get(i);
		}

		return listaModulos;
	}

	public String[] getSubModules(String module){
		ArrayList<String> arraySubModulos;
		String[] vectorModulos=getModules();
		modulesSubModelsMap= new HashMap<String,ArrayList<String>>();
		String[] subModulos;
		dbConnection= new DbConnection();
		conn=dbConnection.getConn();		
		try {
			for(int i=0;i<vectorModulos.length;i++){
				resultSet =dbConnection.select("SELECT Designacao_SubModulo FROM Sub_Modulo WHERE Designacao_Modulo =" + "'"+ vectorModulos[i]+ "'");
				arraySubModulos= new ArrayList<String>();
				while(resultSet.next()) {
					String submodulo  = resultSet.getString("Designacao_SubModulo");
					//System.out.println(submodulo);
					arraySubModulos.add(submodulo);
				}
				modulesSubModelsMap.put(vectorModulos[i], arraySubModulos);
			}
			resultSet.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		subModulos=new String[modulesSubModelsMap.get(module).size()];  
		System.out.println(subModulos.length);
		for(int j=0;j<subModulos.length;j++){
			//  System.out.println(modulesSubModelsMap.get(module).get(j));
			subModulos[j]=modulesSubModelsMap.get(module).get(j);

		}
		//  System.out.println(modulesSubModelsMap.get(module).size());
		return subModulos;
	}

	public boolean isCurrenteUserModule(String module){
		return false;
	}
	public boolean isCurrentUserSubModule(String subModule){
		return false;
	}
	public void updateModule(String oldString,String newString){

	}
	public void updateModulesLists(){

	}
	public void updateSubModulesLists(){

	}
	public void insertModule(String module){   //Relatorio nao recebe parametros

	}
	public void insertSubModule(String module,String subModule){

	}
	public static void main(String[] args) {
		Docente d= new Docente("victor@iscte.pt","Victor","Victor");
		ModuleToSubModuleMap m= new ModuleToSubModuleMap(d);
		m.getSubModules("");
	}

}
