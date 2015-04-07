package controller;

import java.util.LinkedList;
import model.Difficulty;
import model.Docente;
import model.ModuleToSubModuleMap;
import model.Question;

public class ControllerQuestions {
	// private DbConnection
	private boolean minhaQuestao; // minhasQuestao no relatorio
	private Question question = new Question();
	private LinkedList<Question> listaQuestoes;
	private Docente currentUser; // Relatorio diz USER
	private ModuleToSubModuleMap moduleToSubModuleObject = new ModuleToSubModuleMap(currentUser);
	private Difficulty nivel = new Difficulty(); // Não está diagrama no classes..E a classe chama-se Difficult
	
	
	public ControllerQuestions(Docente currentUser) { // Relatorio diz USER
		this.currentUser = currentUser;
	}

	public String[] loadModulos() {
		return moduleToSubModuleObject.getModules();
	}

	public String[] loadSubModulos(String selectedModule) {
		return moduleToSubModuleObject.getSubModules(selectedModule);
	}

	public String[] populateNiveis() { // Dificuldade
		return nivel.populateNiveis();
	}

	public LinkedList<Question> aplicarFiltro(String module,String subModule, String nivel, boolean minhaQuestao){ //Diagrama classe tem tbm int texto
		listaQuestoes = question.aplicarFiltro(module, subModule, nivel, minhaQuestao, currentUser);
		return listaQuestoes;
	}

	public void apagarResposta(Question question) { // ForceDelete está no diagrama de classes(MVC)...não vai ser necessario
	}

	public void verDetalhes(Question question) { // Vai ser necessário receber  como parametro uma pergunta
	}

	public Question getQuestion(String module, String subModule, String nivel,
			String texto, Docente user) {
		return null;
	}

	public boolean isUserQuestion(String module, String subModule,
			String nivel, String texto, Docente user) {
		return false;
	}

	public String openStringChanger() {
		return null;
	}

	public boolean submittChanges(Question question) {
		return false;
	}

	public boolean insertModule() {
		return false;
	}

	public boolean insertQuestion(String module, String subModule,
			String nivel, String userEmail, String texto, String explicacao,
			String link) {
		return false;
	}

	public Docente currentDocente() {
		currentUser = new Docente();
		return currentUser.currentDocente();
	}
}
