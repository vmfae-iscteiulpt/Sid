package model;

import java.util.ArrayList;
import java.util.Map;

import controller.DbConnection;

public class ModuleToSubModuleMap {

	
	private ArrayList<String> modules;  //Relatorio esta com letra maiuscula
	private Map<String,ArrayList<String>> modulesSubModelsMap;
	private DbConnection conn;
	private ArrayList<String> currentUserModules;
	private Map<String,ArrayList<String>> currentUserModulesSubModelsMap;
	private Docente currentUser;
	
	
	
	public ModuleToSubModuleMap(Docente currentUser){
		this.currentUser=currentUser;
		
	}
	
	public String[] getSubModules(String module){
		return null;
	}
	public String[] getModule(){
		return null;}
	
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
	
	
	}
