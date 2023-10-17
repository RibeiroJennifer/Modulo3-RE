package modelos;

public class Usuarios {

	//ATRIBUTOS
	
	private int ID;
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	
	//CONSTRUTORES
	
	public Usuarios() {
	}

	public Usuarios(int iD, String nome, String cpf, String email, String senha) {
		ID = iD;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}

	public Usuarios(String nome, String cpf, String email, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}

	//GETTERSeSETTERS

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	//TOSTRING
	
	@Override
	public String toString() {
		return "Usuarios [ID=" + ID + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha + "]";
	}
	
	
	
	
	
}
