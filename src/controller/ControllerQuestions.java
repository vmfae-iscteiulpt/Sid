package controller;

import java.util.ArrayList;
import java.util.LinkedList;

import model.Difficulty;
import model.Docente;
import model.ModuleToSubModuleMap;
import model.Question;

public class ControllerQuestions {

	
	private boolean minhaQuestao;  // minhasQuestao no relatorio
	private Question questaoSelecionada;
	private LinkedList<Question> listaQuestoes; 
	private ModuleToSubModuleMap moduleToSubModuleObject; 
	//private DbConnection dbConnection;  //Adicionada por nós
	private Docente currentUser;  //Relatorio diz USER
	private Difficulty nivel;  //Não está diagrama no classes..E a classe chama-se Difficult
	
	public ControllerQuestions(Docente currentUser){  //Relatorio diz USER
		this.currentUser=currentUser;
		//dbConnection = new DbConnection();
	}
	public String[] loadSubModulos(String selectedModule){
		return null;
	}
	public String[] populateNiveis(){
		return null;
	}
	public LinkedList<Question> aplicarFiltro(String module,String subModule,String nivel,boolean minhaQuestao){ //Diagrama classe tem tbm int texto
		return null;
	}
	public void apagarResposta(Question question){ //  ForceDelete está no diagrama de classes(MVC)...não vai ser necessario
	}
	public void verDetalhes(Question question){  //Vai ser necessário receber como parametro uma pergunta
		
	}
	public Question getQuestion(String module, String subModule,String nivel,String texto,Docente user ){
		return null;
	}
	public boolean isUserQuestion(String module,String subModule,String nivel,String texto,Docente user){
		return false;
	}
	public String openStringChanger(){
		return null;
	}
	public String[] loadModulos(){ 
		return null;
	}
	public boolean submittChanges(Question question){
		return false;
	}
	public boolean insertModule(){
		return false;
	}
	public boolean insertQuestion(String module,String subModule,String nivel,String userEmail,String texto,String explicacao,String link){
		return false;
	}
	
	
	/*
	public boolean inserirDocente(Docente currentUser) {
		return database.inserirDocente(currentUser);
		
	}
*/	
	public ArrayList<Docente> verDocentes(){
		System.out.println(currentUser);
		return currentUser.verDocentes();
	}
}
