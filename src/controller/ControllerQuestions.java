package controller;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import view.DetailsView;
import view.EditQuestionView;
import model.Difficulty;
import model.Docente;
import model.ModuleToSubModuleMap;
import model.Question;

public class ControllerQuestions {
	// private DbConnection
	private boolean minhaQuestao; // minhasQuestao no relatorio
	private Question question = new Question();
	private LinkedList<Question> listaQuestoes;
	private Docente currentUser1; // Relatorio diz USER
	private ModuleToSubModuleMap moduleToSubModule;
	private Difficulty nivel = new Difficulty(); // Não está diagrama no classes..E a classe chama-se Difficult
	private String novoModulo=" ";
	private String moduloActual = " ";
	
	
	public ControllerQuestions(Docente currentUser) { // Relatorio diz USER
		this.currentUser1 = currentUser;
		moduleToSubModule = new ModuleToSubModuleMap(currentUser1);
	}

	public String[] loadModulos() {
		return moduleToSubModule.getModules();
	}

	public String[] loadSubModulos(String selectedModule) {
		return moduleToSubModule.getSubModules(selectedModule);
	}

	public String[] populateNiveis() { // Dificuldade
		return nivel.populateNiveis();
	}

	public LinkedList<Question> aplicarFiltro(String module,String subModule, String nivel, boolean minhaQuestao, Docente user){ //Diagrama classe tem tbm int texto
//		System.out.println(module+ subModule+ nivel+ minhaQuestao+ user);
		
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
	public void getQuestion(Question questionSelected, boolean editQuestion, Docente user, ControllerQuestions controlador) {//era um Question... o nom também nao faz sentido...
		if(editQuestion){
			EditQuestionView editView = new EditQuestionView(questionSelected , controlador, user);
			editView.setVisible(true);
		}else{
			DetailsView  detailView = new DetailsView(questionSelected, user);//
			detailView.setVisible(true);
		}

	}

	public boolean isUserQuestion(String module, String subModule,
			String nivel, String texto, Docente user) {
		return false;
	}

	public String openStringChanger(String ModuloActual) {  //Estava como String
		this.moduloActual=ModuloActual;
		novoModulo = JOptionPane.showInputDialog("Qual o novo módulo a inserir?");
		if(novoModulo == null){
			System.out.println("");
			return " ";
		}
			

		System.out.println("Novo modulo: "+ novoModulo);
		
		verificar(novoModulo);
		moduleToSubModule.insertModule(novoModulo);
//		moduleToSubModuleObject.updateModule(moduloActual, novoModulo);

			return novoModulo;

	}

	private void verificar(String novoModulo) {
		String[] vModulos = loadModulos();
		for (int i = 0; i < vModulos.length; i++) {
			if(vModulos[i].equals(novoModulo)){
				JOptionPane.showMessageDialog(null, 
					    "O modulo que inseriu já existe, por favor tente novamente!");
				openStringChanger(moduloActual);
			}
		}	
	}

	public boolean submittChanges(Question question) {
		
			question.editarQuestao(question);
			return true;
	
	}

	public boolean insertModule() {
		
		return false;
	}

	public boolean insertQuestion( String module, String subModule,
			String nivel, String userEmail, int resposta, String texto, String explicacao,
			String link) {
		
		Question n = new Question();
		System.out.println("jjjjj" +n.getNumberMaxQuestions());
		Question newQuestion = new Question(n.getNumberMaxQuestions(), module, subModule, nivel, texto, resposta, explicacao, link, userEmail);
		newQuestion.inserirQuestao();
		return true;
	}

	public Docente currentDocente() {
		currentUser1 = new Docente();
		return currentUser1.currentDocente();
	}
}
