package controller;

import java.util.LinkedList;

import view.DetailsView;
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

	public LinkedList<Question> aplicarFiltro(String module,String subModule, String nivel, boolean minhaQuestao, Docente user){ //Diagrama classe tem tbm int texto
		System.out.println(module+ subModule+ nivel+ minhaQuestao+ user);
		
		listaQuestoes = question.aplicarFiltro(module, subModule, nivel, minhaQuestao, user);
		return listaQuestoes;
	}

	public void apagarResposta(Question question) { // ForceDelete está no diagrama de classes(MVC)...não vai ser necessario
	}

	public void verDetalhes() { // Vai ser necessário receber  como parametro uma pergunta
	}

	/*en vez de criar uma NOVA instancia da pergunta com todos os parametros (String module, String subModule, String nivel,
	String texto, String explicacao, int respostas, String link, Docente user), 
	podemos manter a instancia da mesma pergunta passada no paramentro, e provalvemente deveria ser um procedimento...
	*/
	public Question getQuestion(Question questionSelected, Docente user) {
		DetailsView  detailView = new DetailsView(questionSelected, user);//
		detailView.setVisible(true);
		return questionSelected;
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
