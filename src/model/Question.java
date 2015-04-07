package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import controller.DbConnection;

public class Question {

	private String modulo;
	private String subModulo;
	private String nivel; // Estava como String
	private String pergunta;
	private int resposta; // resposta
	private String link;
	private String emailDocente;
	private int id;
	private DbConnection dbconn;
	private Connection conn;
	private LinkedList<Question> listaQuestions = new LinkedList<Question>();


	public Question(String modulo, String subModulo, String nivel, String pergunta,
			int resposta, String link, String emailDocente) {
		this.modulo = modulo;
		this.subModulo = subModulo;
		this.nivel = nivel;
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.link = link;
		this.emailDocente = emailDocente;
	}

	public Question() {

	}
	

	public LinkedList<Question> aplicarFiltro(String modulo, String subModulo, String nivelQuestion, boolean minhaQuestao, Docente currentUser) {
		dbconn = new DbConnection();
		conn = dbconn.getConn();

		try {
			ResultSet resultSetNivel = dbconn.select("SELECT ID_Nivel FROM Nivel_Dificuldade WHERE Designacao_Nivel="+"'"+nivelQuestion+"'");
			System.out.println("SELECT * FROM Nivel_Dificuldade WHERE Designacao_Nivel="+"'"+nivelQuestion+"'");
			int idNivel=0;;
			while (resultSetNivel.next()) {
				idNivel= resultSetNivel.getInt("ID_Nivel");	
			}
			System.out.println("currentUser: "+currentUser.getEmail()+" modulo: "+"'"+ modulo + "'"+" subModulo: " + "'"+ subModulo +"'" +" id_Nivel: " + idNivel);

						
			ResultSet resultSet = dbconn.select("SELECT * FROM Questao");
			while (resultSet.next()) {
				if (minhaQuestao == false && !currentUser.getEmail().equals(resultSet.getString("Email_Docente"))){ // pesquisa de "Outros Docentes"
					
					if(modulo.equals(" ") && nivelQuestion.equals(" ")){
						listaQuestions.removeAll(listaQuestions);//remove todos os elementos da lista!
						
					}else if(modulo.equals(" ") && idNivel==resultSet.getInt("ID_Nivel")){//filtra pelo niveis.!
						System.out.println("aplicar filtro só pelo nivel ");
						addListaQuestions(resultSet,  listaQuestions);
					
					}else if(modulo.equals(resultSet.getString("Designacao_Modulo")) && (subModulo.equals(" ")) && (idNivel==0)){
						System.out.println("aplicar filtro só pelo Modulo");
						addListaQuestions(resultSet,   listaQuestions);
						
					}else if((modulo.equals(resultSet.getString("Designacao_Modulo")) && (subModulo.equals(resultSet.getString("Designacao_SubModulo"))) && (idNivel==0) )){//Filtramos pelo modulo e submodulo
						System.out.println("aplicar filtro pelo Modulo e subModulo");
						addListaQuestions(resultSet,   listaQuestions);
						
					}else if((modulo.equals(resultSet.getString("Designacao_Modulo")) && (subModulo.equals(" "))&& (idNivel==resultSet.getInt("ID_Nivel")))){
						System.out.println("aplicar filtro pelo modulo e nivel");
						addListaQuestions(resultSet,   listaQuestions);
					}else if((modulo.equals(resultSet.getString("Designacao_Modulo")) && (subModulo.equals(resultSet.getString("Designacao_SubModulo")))&& (idNivel==resultSet.getInt("ID_Nivel")))){
						System.out.println("aplicar filtro pelo modulo, submodulo e nivel");
						addListaQuestions(resultSet,   listaQuestions);
					}
				} 
				else { // pesquisa de "Minhas perguntas"
					if (minhaQuestao == true && currentUser.getEmail().equals(resultSet.getString("Email_Docente"))){ // pesquisa de "Outros Docentes"
						
						if(modulo.equals(" ") && nivelQuestion.equals(" ")){
							listaQuestions.removeAll(listaQuestions);//remove todos os elementos da lista!
							
						}else if(modulo.equals(" ") && idNivel==resultSet.getInt("ID_Nivel")){//filtra pelo niveis.!
							System.out.println("aplicar filtro só pelo nivel ");
							addListaQuestions(resultSet,  listaQuestions);
						
						}else if(modulo.equals(resultSet.getString("Designacao_Modulo")) && (subModulo.equals(" ")) && (idNivel==0)){
							System.out.println("aplicar filtro só pelo Modulo");
							addListaQuestions(resultSet,   listaQuestions);
							
						}else if((modulo.equals(resultSet.getString("Designacao_Modulo")) && (subModulo.equals(resultSet.getString("Designacao_SubModulo"))) && (idNivel==0) )){//Filtramos pelo modulo e submodulo
							System.out.println("aplicar filtro pelo Modulo e subModulo");
							addListaQuestions(resultSet,   listaQuestions);
							
						}else if((modulo.equals(resultSet.getString("Designacao_Modulo")) && (subModulo.equals(" "))&& (idNivel==resultSet.getInt("ID_Nivel")))){
							System.out.println("aplicar filtro pelo modulo e nivel");
							addListaQuestions(resultSet,   listaQuestions);
						}else if((modulo.equals(resultSet.getString("Designacao_Modulo")) && (subModulo.equals(resultSet.getString("Designacao_SubModulo")))&& (idNivel==resultSet.getInt("ID_Nivel")))){
							System.out.println("aplicar filtro pelo modulo, submodulo e nivel");
							addListaQuestions(resultSet,   listaQuestions);
						}
					}
				}
			}
			System.out.println("Questao " + conn.isClosed());
			dbconn.closeStatement();
			conn.close();
			System.out.println("Questao " + conn.isClosed());
		
		} catch (SQLException e) {
			System.err
					.println("problemas na ligacao a base de dados, por favor tente novemente!");
			e.printStackTrace();
			// FIM RECOLHA GENERICOS
		}
		return listaQuestions;

	}

	private void addListaQuestions(ResultSet resultSet, LinkedList<Question> lista) {
		try {
			
			String moduloQuestao = resultSet.getString("Designacao_Modulo");
			String subModuloQuestao = resultSet.getString("Designacao_SubModulo");
			String textoQuestao = resultSet.getString("Texto");
			int respostaQuestao = resultSet.getInt("Resposta");
			String linkQuestao = resultSet.getString("Link_Ficheiro");
			int nivelQuestao = resultSet.getInt("ID_Nivel");
			String emailUserQuestao = resultSet.getString("Email_Docente");
			
			String designacaoNivel = new String (" ");
			ResultSet resultSetNivel = dbconn.select("SELECT Designacao_Nivel FROM Nivel_Dificuldade WHERE ID_Nivel="+"'"+nivelQuestao+"'");
			while (resultSetNivel.next()) {
				designacaoNivel= resultSetNivel.getString("Designacao_Nivel");
			}
			Question questao = new Question(moduloQuestao, subModuloQuestao, designacaoNivel, textoQuestao, respostaQuestao, linkQuestao, emailUserQuestao);
			System.out.println(questao.toString());
			lista.add(questao);	
			System.out.println(lista.size());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void apagar() { // Não deveria ser Question question?

	}

	public boolean inserirQuestao() { // boolean?????????
		return false;
	}

	public boolean editarQuestao(Question question) { // boolean???????
		return false;
	}

	public boolean userQuestion(Docente user) {
		return false;
	}
	
	public static void main(String[] args) {
		Question q = new Question();
		Docente d = new Docente("victor@iscte.pt", "Victor", "Victor");
		q.aplicarFiltro("Portugues", "Lusiadas", " ", true, d);
		
		
	}
	
	@Override
	public String toString() {
		return "Question [modulo=" + modulo + ", subModulo=" + subModulo
				+ ", nivel=" + nivel + ", pergunta=" + pergunta + ", emailDocente="
				+ emailDocente + "]";
	}

}
