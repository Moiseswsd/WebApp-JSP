package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Pessoa.
 */
public class Pessoa {
	
	/** The login. */
	private String login;
	
	/** The senha. */
	private String senha;
	
	/** The nome. */
	private String nome;
	
	/** The cpf. */
	private String cpf;
	
	/** The idade. */
	private String idade;
	
	/** The endereco ID. */
	private String enderecoID;
	
	/** The contato ID. */
	private String contatoID;
	
	/** The cargo ID. */
	private String cargoID;
	
	/** The pessoa ID. */
	private String pessoaID;
	
	/** The contatos. */
	private Contato contatos;
	
	/** The endereco. */
	private Endereco endereco;
	
	/** The cargo. */
	private Cargo cargo;
	
	/**
	 * Instantiates a new pessoa.
	 *
	 * @param login the login
	 * @param senha the senha
	 * @param nome the nome
	 * @param cpf the cpf
	 * @param idade the idade
	 * @param enderecoID the endereco ID
	 * @param contatoID the contato ID
	 * @param cargoID the cargo ID
	 * @param contatos the contatos
	 * @param endereco the endereco
	 * @param cargo the cargo
	 */
	public Pessoa(String login, String senha, String nome, String cpf, String idade, String enderecoID,
			String contatoID, String cargoID, Contato contatos, Endereco endereco, Cargo cargo) {
		super();
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.enderecoID = enderecoID;
		this.contatoID = contatoID;
		this.cargoID = cargoID;
		this.contatos = contatos;
		this.endereco = endereco;
		this.cargo = cargo;
	}

	/**
	 * Instantiates a new pessoa.
	 *
	 * @param login the login
	 * @param senha the senha
	 * @param nome the nome
	 * @param cpf the cpf
	 * @param idade the idade
	 * @param enderecoID the endereco ID
	 * @param contatoID the contato ID
	 * @param cargoID the cargo ID
	 * @param pessoaID the pessoa ID
	 * @param contatos the contatos
	 * @param endereco the endereco
	 * @param cargo the cargo
	 */
	public Pessoa(String login, String senha, String nome, String cpf, String idade, String enderecoID,
			String contatoID, String cargoID, String pessoaID, Contato contatos, Endereco endereco, Cargo cargo) {
		super();
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.enderecoID = enderecoID;
		this.contatoID = contatoID;
		this.cargoID = cargoID;
		this.pessoaID = pessoaID;
		this.contatos = contatos;
		this.endereco = endereco;
		this.cargo = cargo;
	}

	/**
	 * Instantiates a new pessoa.
	 */
	public Pessoa() {
		super();
		this.login="";
		this.senha="";
		this.nome ="";
		this.cpf ="";
		this.idade ="";
		this.enderecoID ="";
		this.contatoID ="";
		this.cargoID ="";
		this.pessoaID ="";
		this.contatos = null;
		this.endereco = null;
		this.cargo = null;
	}
	
	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the senha.
	 *
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Sets the senha.
	 *
	 * @param senha the new senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the idade.
	 *
	 * @return the idade
	 */
	public String getIdade() {
		return idade;
	}

	/**
	 * Sets the idade.
	 *
	 * @param idade the new idade
	 */
	public void setIdade(String idade) {
		this.idade = idade;
	}

	/**
	 * Gets the endereco ID.
	 *
	 * @return the endereco ID
	 */
	public String getEnderecoID() {
		return enderecoID;
	}

	/**
	 * Sets the endereco ID.
	 *
	 * @param enderecoID the new endereco ID
	 */
	public void setEnderecoID(String enderecoID) {
		this.enderecoID = enderecoID;
	}

	/**
	 * Gets the contato ID.
	 *
	 * @return the contato ID
	 */
	public String getContatoID() {
		return contatoID;
	}

	/**
	 * Sets the contato ID.
	 *
	 * @param contatoID the new contato ID
	 */
	public void setContatoID(String contatoID) {
		this.contatoID = contatoID;
	}

	/**
	 * Gets the cargo ID.
	 *
	 * @return the cargo ID
	 */
	public String getCargoID() {
		return cargoID;
	}

	/**
	 * Sets the cargo ID.
	 *
	 * @param cargoID the new cargo ID
	 */
	public void setCargoID(String cargoID) {
		this.cargoID = cargoID;
	}

	/**
	 * Gets the contatos.
	 *
	 * @return the contatos
	 */
	public Contato getContatos() {
		return contatos;
	}

	/**
	 * Sets the contatos.
	 *
	 * @param contatos the new contatos
	 */
	public void setContatos(Contato contatos) {
		this.contatos = contatos;
	}

	/**
	 * Gets the endereco.
	 *
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * Sets the endereco.
	 *
	 * @param endereco the new endereco
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * Gets the cargo.
	 *
	 * @return the cargo
	 */
	public Cargo getCargo() {
		return cargo;
	}

	/**
	 * Sets the cargo.
	 *
	 * @param cargo the new cargo
	 */
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	/**
	 * Gets the pessoa ID.
	 *
	 * @return the pessoa ID
	 */
	public String getPessoaID() {
		return pessoaID;
	}

	/**
	 * Sets the pessoa ID.
	 *
	 * @param pessoaID the new pessoa ID
	 */
	public void setPessoaID(String pessoaID) {
		this.pessoaID = pessoaID;
	}
	
	/**
	 * Resetar bean.
	 */
	public void resetarBean() {
		this.login="";
		this.senha="";
		this.nome ="";
		this.cpf ="";
		this.idade ="";
		this.enderecoID ="";
		this.contatoID ="";
		this.cargoID ="";
		this.pessoaID ="";
		this.contatos = null;
		this.endereco = null;
		this.cargo = null;
		
	}
}	

	