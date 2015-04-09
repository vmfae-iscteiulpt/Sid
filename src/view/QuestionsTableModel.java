package view;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Question;

public class QuestionsTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Lista de Questions
	private List<Question> linhasQuestions;
	//array com os nome das colunas
	private String[] colunas = new String[] {"Modulo" , "Sub-Modulo", "Nivel", "Pergunta"};
	//Contantes representados o indoce das colunas
	private static final int MODULO =0;
	private static final int SUBMODULO =1;
	private static final int NIVEL =2;
	private static final int PERGUNTA =3;
	
	
	//Cria um QuestionsTableModel se nenhuma linha
	public QuestionsTableModel(){
		this.linhasQuestions= new LinkedList<Question>();
	}
	
	public QuestionsTableModel(List<Question> listaQuestions){
		this.linhasQuestions= new LinkedList<Question>(listaQuestions);
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return linhasQuestions.size();
	}
	@Override
	public String getColumnName(int ColumnIndex){
		return colunas[ColumnIndex];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
	    switch (columnIndex) {
	    case MODULO:
	        return String.class;
	    case SUBMODULO:
	        return String.class;
	    case NIVEL:
	        return String.class;
	    case PERGUNTA:
	        return String.class;
	    default:
	        // Não deve ocorrer, pois só existem 4 colunas
	        throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    }
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	    return false;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	    // Pega o question referente a linha especificada.
	    Question question = linhasQuestions.get(rowIndex);
	 
	    switch (columnIndex) {
	    case MODULO:
	        return question.getModulo();
	    case SUBMODULO:
	        return question.getSubModulo();
	    case NIVEL:
	        return question.getNivel();
	    case PERGUNTA:
	        return question.getPergunta();
	    default:
	        // Não deve ocorrer, pois só existem 4 colunas
	        throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    }
	}
	
	
	//Manupulação do Objeto Question!!!
	
	// Retorna a questiao referente a linha especificada
	public Question getQuestion(int indiceLinha) {
	    return linhasQuestions.get(indiceLinha);
	}
	 
	// Adiciona a questao especificado ao modelo
	public void addQuestion(Question question) {
	    // Adiciona o registro.
	    linhasQuestions.add(question);
	 
	    // Pega a quantidade de registros e subtrai 1 para
	    // achar o último índice. A subtração é necessária
	    // porque os índices começam em zero.
	    int ultimoIndice = getRowCount() - 1;
	 
	    // Notifica a mudança.
	    fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	 
	// Remove a questao da linha especificada.
	public void removeQuestion(int indiceLinha) {
	    // Remove o registro.
	    linhasQuestions.remove(indiceLinha);
	 
	    // Notifica a mudança.
	    fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
	 
	// Adiciona uma lista de questions no final da lista.
	public void addListaDeQuestion(List<Question> questions) {
	    // Pega o tamanho antigo da tabela, que servirá
	    // como índice para o primeiro dos novos registros
	    int indice = getRowCount();
	 
	    // Adiciona os registros.
	    linhasQuestions.addAll(questions);
	 
	    // Notifica a mudança.
	    fireTableRowsInserted(indice, indice + questions.size());
	}
	 
	// Remove todos os registros.
	public void limpar() {
	    // Remove todos os elementos da lista de sócios.
	    linhasQuestions.clear();
	 
	    // Notifica a mudança.
	    fireTableDataChanged();
	}
	
	
	
	

}
