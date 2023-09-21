package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/** The connection. */
	private Connection connection;
	
	/** The url. */
	private String url;
	
	/** The usuario. */
	private String usuario;
	
	/** The senha. */
	private String senha;
	
	/**
	 * Instantiates a new dao.
	 */
	public DAO(){
		this.url = "jdbc:mysql://127.0.0.1:3306/pessoa?useTimezone=true&serverTimezone=UTC";
		this.usuario = "root";
		this.senha = "arqui2185142215";
	}
	
	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, usuario, senha);
			return connection;
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * Criar cadastro.
	 *
	 * @param pessoa the pessoa
	 */
	public void criarCadastro(Pessoa pessoa) {
		String sql = "insert into pessoas(login, senha, nome, cpf, idade, enderecoID, contatoID, cargoID) values (?,?,?,?,?,?,?,?);";
		try {
			connection = conectar();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoa.getLogin());
			statement.setString(2, pessoa.getSenha());
			statement.setString(3, pessoa.getNome());
			statement.setString(4, pessoa.getCpf());
			statement.setString(5, pessoa.getIdade());
			statement.setString(6, pessoa.getEnderecoID());
			statement.setString(7, pessoa.getContatoID());
			statement.setString(8, pessoa.getCargoID());
			statement.executeUpdate();
			connection.close();
			System.out.println("Contato criado com sucesso!");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Validar login.
	 *
	 * @param pessoa the pessoa
	 * @return true, if successful
	 */
	public boolean validarLogin(Pessoa pessoa) {
		String sql = "select * from pessoas where login=? and senha=?;";
		try {
			connection = this.conectar(); 
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoa.getLogin());
			statement.setString(2, pessoa.getSenha());
			ResultSet result = statement.executeQuery();
			if(result.next()){
				connection.close();
				return true;
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		try {
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * Deletar cadastro.
	 *
	 * @param pessoa the pessoa
	 */
	public void deletarCadastro(Pessoa pessoa) {
		String sql = "delete from pessoas where pessoaID=?;";
		try {
			connection = conectar();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoa.getPessoaID());
			statement.executeUpdate();
			connection.close();
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Contato de id" + pessoa.getPessoaID() + "deletado");
		}
	}
	
	/**
	 * Obter cadastros.
	 *
	 * @return the array list
	 */
	public ArrayList<Pessoa> obterCadastros(){
		ArrayList<Pessoa> lista = new ArrayList<>();
		Contato contato = new Contato();
		Endereco endereco = new Endereco();
		Cargo cargo = new Cargo();
		String sql = "select * from pessoas order by nome;";
		try {
			connection = conectar();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				endereco = this.obterEndereco(result.getString("enderecoID"), connection);
				contato = this.obterContato(result.getString("contatoID"), connection);
				cargo = this.obterCargo(result.getString("cargoID"), connection);
				lista.add(new Pessoa( result.getString("login"), result.getString("senha"), result.getString("nome"), result.getString("cpf"), result.getString("idade"),
						result.getString("enderecoID"), result.getString("contatoID"), result.getString("cargoID"), result.getString("pessoaID"), contato, endereco, cargo));
			}
			connection.close();
			return lista;
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * Obter cadastro.
	 *
	 * @param pessoa the pessoa
	 * @return the pessoa
	 */
	public Pessoa obterCadastro(Pessoa pessoa) {
		Endereco endereco = new Endereco();
		Contato contato = new Contato();
		Cargo cargo = new Cargo();
		String sql = "select * from pessoas where pessoaID=?";
		try {
			this.connection = conectar();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoa.getPessoaID());
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				endereco = obterEndereco(result.getString("enderecoID"), connection);
				contato = obterContato(result.getString("contatoID"), connection);
				cargo = obterCargo(result.getString("cargoID"), connection);
				
				pessoa.setCargo(cargo);
				pessoa.setContatos(contato);			 								
				pessoa.setEndereco(endereco);
				pessoa.setCargoID(result.getString("cargoID"));
				pessoa.setContatoID(result.getString("contatoID"));
				pessoa.setCpf(result.getString("cpf"));
				pessoa.setEnderecoID(result.getString("enderecoID"));
				pessoa.setIdade(result.getString("idade"));
				pessoa.setLogin(result.getString("login"));
				pessoa.setNome(result.getString("nome"));
				pessoa.setPessoaID(result.getString("pessoaID"));
				pessoa.setSenha(result.getString("senha"));
			}
			connection.close();
			return pessoa;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Atualizar cadastro.
	 *
	 * @param pessoa the pessoa
	 */
	public void atualizarCadastro(Pessoa pessoa) {
		String sql= "update pessoas set login = ?, senha = ?, nome = ?, cpf = ?, idade = ?, enderecoID = ?, contatoID = ?, cargoID = ? WHERE pessoaID = ?";
		try {
			this.connection = this.conectar();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoa.getLogin());
			statement.setString(2, pessoa.getSenha());
			statement.setString(3, pessoa.getNome());
			statement.setString(4, pessoa.getCpf());
			statement.setString(5, pessoa.getIdade());
			statement.setString(6, pessoa.getEnderecoID());
			statement.setString(7, pessoa.getContatoID());
			statement.setString(8, pessoa.getCargoID());
			statement.setString(9, pessoa.getPessoaID());
			statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Obter cadastro login.
	 *
	 * @param pessoa the pessoa
	 * @return the pessoa
	 */
	public Pessoa obterCadastroLogin(Pessoa pessoa) {
		Endereco endereco = new Endereco();
		Contato contato = new Contato();
		Cargo cargo = new Cargo();
		String sql = "select * from pessoas where login=? and senha=?";
		try {
			this.connection = conectar();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoa.getLogin());
			statement.setString(2, pessoa.getSenha());
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				endereco = obterEndereco(result.getString("enderecoID"), connection);
				contato = obterContato(result.getString("contatoID"), connection);
				cargo = obterCargo(result.getString("cargoID"), connection);
				pessoa.setCargo(cargo);
				pessoa.setContatos(contato);			 								
				pessoa.setEndereco(endereco);
				pessoa.setCargoID(result.getString("cargoID"));
				pessoa.setContatoID(result.getString("contatoID"));
				pessoa.setCpf(result.getString("cpf"));
				pessoa.setEnderecoID(result.getString("enderecoID"));
				pessoa.setIdade(result.getString("idade"));
				pessoa.setLogin(result.getString("login"));
				pessoa.setNome(result.getString("nome"));
				pessoa.setPessoaID(result.getString("pessoaID"));
				pessoa.setSenha(result.getString("senha"));
			}
			connection.close();
			return pessoa;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * Verifica existencia login.
	 *
	 * @param login the login
	 * @return true, if successful
	 */
	public boolean verificaExistenciaLogin(String login) {
		String sql= "Select * from pessoas where login=?";
		try {
			this.connection = conectar();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				return true;
			}
		} catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Verifica existencia cpf.
	 *
	 * @param cpf the cpf
	 * @return true, if successful
	 */
	public boolean verificaExistenciaCpf(String cpf) {
		String sql= "Select * from pessoas where cpf=?";
		try {
			this.connection = conectar();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cpf);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				return true;
			}
		} catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Obter endereco.
	 *
	 * @param enderecoID the endereco ID
	 * @param connection the connection
	 * @return the endereco
	 */
	private Endereco obterEndereco(String enderecoID, Connection connection) {
		String sql = "select * from enderecos where enderecoID=?";
		this.connection = connection;
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, enderecoID);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				Endereco endereco = new Endereco(result.getString("estado"));
				
				return endereco;
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * Obter contato.
	 *
	 * @param contatoID the contato ID
	 * @param connection the connection
	 * @return the contato
	 */
	private Contato obterContato(String contatoID, Connection connection) {
		String sql = "select * from contatos where contatoID=?";
		this.connection = connection;
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, contatoID);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				Contato contato = new Contato(result.getString("telefoneFixo"), result.getString("telefoneMovel"));
				return contato;
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Obter cargo.
	 *
	 * @param cargoID the cargo ID
	 * @param connection the connection
	 * @return the cargo
	 */
	private Cargo obterCargo(String cargoID, Connection connection) {
		String sql = "select * from cargos where cargoID=?";
		this.connection = connection;
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, cargoID);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				Cargo cargo  = new Cargo(result.getString("cargo"));
				return cargo;
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
