package model;

public class Docente {
	private String email;
	private String nome;
	private String password;
	
	
	public Docente(String email, String nome, String password) {
		this.email = email;
		this.nome = nome;
		this.password = password;
	}
	
	public String toString() {
		return "Docente [email=" + email + ", nome=" + nome 
				+ "]";
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	
}
