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
	private String explicacao;
	private int idQuestion;
	private DbConnection dbconn;
	private Connection conn;
	private LinkedList<Question> listaQuestions;


	public Question(int idQuestion, String modulo, String subModulo, String nivel, String pergunta,
			int resposta, String explicacao, String link, String emailDocente) {
		this.idQuestion=idQuestion;
		this.modulo = modulo;
		this.subModulo = subModulo;
		this.nivel = nivel;
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.explicacao =  explicacao;
		this.link = link;
		this.emailDocente = emailDocente;
	}


	public Question() {
	}
	

	public LinkedList<Question> aplicarFiltro(String modulo, String subModulo, String nivelQuestion, boolean minhaQuestao, Docente currentUser) {
		dbconn = new DbConnection();
		conn = dbconn.getConn();
		listaQuestions = new LinkedList<Question>();

		try {
			ResultSet resultSetNivel = dbconn.select("SELECT ID_Nivel FROM Nivel_Dificuldade WHERE Designacao_Nivel="+"'"+nivelQuestion+"'");
//			System.out.println("SELECT * FROM Nivel_Dificuldade WHERE Designacao_Nivel="+"'"+nivelQuestion+"'");
			int idNivel=0;;
			while (resultSetNivel.next()) {
				idNivel= resultSetNivel.getInt("ID_Nivel");	
			}
//			System.out.println("currentUser: "+currentUser.getEmail()+" modulo: "+"'"+ modulo + "'"+" subModulo: " + "'"+ subModulo +"'" +" id_Nivel: " + idNivel);

						
			ResultSet resultSet = dbconn.select("SELECT * FROM Questao");
			while (resultSet.next()) {
				if (minhaQuestao == false && !currentUser.getEmail().equals(resultSet.getString("Email_Docente"))){ // pesquisa de "Outros Docentes"
					
					if(modulo.equals(" ") && nivelQuestion.equals(" ")){
						System.out.println("Todas minhas perguntas ");
						addListaQuestions(resultSet,  listaQuestions);
						
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
							System.out.println("Todas minhas perguntas ");
							addListaQuestions(resultSet,  listaQuestions);
							
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
			
			int idQuestion = resultSet.getInt("ID_Questao");
			String moduloQuestao = resultSet.getString("Designacao_Modulo");
			String subModuloQuestao = resultSet.getString("Designacao_SubModulo");
			String textoQuestao = resultSet.getString("Texto");
			int respostaQuestao = resultSet.getInt("Resposta");
			String linkQuestao = resultSet.getString("Link_Ficheiro");
			int nivelQuestao = resultSet.getInt("ID_Nivel");
			String emailUserQuestao = resultSet.getString("Email_Docente");
			String explicacao = resultSet.getString("Explicacao");
			
			String designacaoNivel = new String (" ");
			ResultSet resultSetNivel = dbconn.select("SELECT Designacao_Nivel FROM Nivel_Dificuldade WHERE ID_Nivel="+"'"+nivelQuestao+"'");
			while (resultSetNivel.next()) {
				designacaoNivel= resultSetNivel.getString("Designacao_Nivel");
			}
			Question questao = new Question(idQuestion, moduloQuestao, subModuloQuestao, designacaoNivel, 
					textoQuestao, respostaQuestao, explicacao, linkQuestao, emailUserQuestao);
			System.out.println(questao.toString());
			lista.add(questao);	

//			System.out.println(lista.size());
			
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
		
		dbconn = new DbConnection();
		conn = dbconn.getConn();
		ResultSet resultSetNivel = dbconn.select("SELECT ID_Nivel FROM Nivel_Dificuldade WHERE Designacao_Nivel='"+question.getNivel()+"'");
		int idNivel=0;
		try {
			while (resultSetNivel.next()) {
				idNivel= resultSetNivel.getInt("ID_Nivel");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		UPDATE Questao set Texto = 'teste21' WHERE ID_Questao=1
		dbconn.update("UPDATE Questao"+ " SET TEXTO = '"+question.pergunta+"', Resposta="+question.getResposta()+ ", Explicacao='" +question.getExplicacao()
				+ "' ,Link_Ficheiro='"+question.getLink()+"', ID_NIVEL="+idNivel+", Designacao_SubModulo='"+question.getSubModulo()+"' WHERE ID_Questao =" +question.getIdQuestion());
		System.out.println("monkeyyy!");

//				E assim já altera na BD!
//		dbconn.insert("UPDATE \"Questao\" SET \"Text\"="+question.getPergunta() +" Where \"ID_Questao\"='"+module+"', '"+currentUser.getEmail()+"')");
//		dbconn.insert("INSERT INTO \"Modulo\" (\"Designacao_Modulo\" ,\"Email_Docente\") VALUES ('"+module+"', '"+currentUser.getEmail()+"')");

				
		try {//erro na ligaçao no limite
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		
		return true ;
	}

	public boolean userQuestion(Docente user) {
		return false;
	}
	

	public String getModulo() {
		return modulo;
	}
	

	public int getIdQuestion() {
		return idQuestion;
	}

	public String getSubModulo() {
		return subModulo;
	}

	public String getNivel() {
		return nivel;
	}

	public String getPergunta() {
		return pergunta;
	}

	public int getResposta() {
		return resposta;
	}

	public String getLink() {
		return link;
	}

	public String getEmailDocente() {
		return emailDocente;
	}

	public String getExplicacao() {
		return explicacao;
	}

	public static void main(String[] args) {
		Question q = new Question();
		Docente d = new Docente("victor@iscte.pt", "Victor", "Victor");
		q.aplicarFiltro("Portugues", " ", " ", false, d);
	}

	@Override
	public String toString() {
		return "Question [modulo=" + modulo + ", subModulo=" + subModulo
				+ ", nivel=" + nivel + ", pergunta=" + pergunta + ", resposta="
				+ resposta + ", link=" + link + ", emailDocente="
				+ emailDocente + ", explicacao=" + explicacao + "]";
	}

}
