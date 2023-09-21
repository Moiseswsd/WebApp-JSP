package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAO;
import model.Pessoa;

// TODO: Auto-generated Javadoc
/**
 * The Class Redirecionar.
 */
@WebServlet(urlPatterns= {"/logar","/cadastrar","/criar", "/main", "/logout","/altCadastro", "/obtemTodos", "/deletar", "/editar", "/att", "/editarPt2","/relatorio"})
public class Redirecionar extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
    
    /** The dao. */
    private DAO dao = new DAO(); 
	
	/** The pessoa. */
	private Pessoa pessoa = new Pessoa();
	    
	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String requisicao = request.getServletPath();
	HttpSession session = request.getSession(true);				
		if(requisicao.equals("/logar")) {
			this.logar(request, response);
		} else if(requisicao.equals("/cadastrar")) {			
			this.cadastrar(request, response);
		} else if(requisicao.equals("/altCadastro")) {	 	
			this.alterarCadastro(request, response);
		}else if(requisicao.equals("/editarPt2")) {	 		
			this.editarPt2(request, response);
		}else if(requisicao.equals("/obtemTodos")) {	
			this.pessoa = (Pessoa)session.getAttribute("pessoa");
			this.obterTodosCadastros(request, response);
		}else if(requisicao.equals("/criar")) {	 			
			this.criar(request, response);
		}else if(requisicao.equals("/editar")) {	 		
			this.editar(request, response);
		}else if(requisicao.equals("/deletar")) {	 		
			this.deletar(request, response);
		} else if(requisicao.equals("/relatorio")) {	 		
			this.gerarRelatorio(request, response);
		} else if (requisicao.equals("/main")){ 			
			this.pessoa = (Pessoa)session.getAttribute("pessoa");
			String cargoID = pessoa.getCargoID();
			if (cargoID == null || cargoID.isBlank() || cargoID.isEmpty()) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("logout");
				dispatcher.forward(request, response);
			} else if (cargoID.equals("1")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("diretor.jsp");
				dispatcher.forward(request, response);
			} else if (cargoID.equals("2")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("professor.jsp");
				dispatcher.forward(request, response);
			}  else if (cargoID.equals("3")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("aluno.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("logout");
				dispatcher.forward(request, response);
			}
		} else if (requisicao.equals("/logout")) {
			session.invalidate();
			pessoa.resetarBean();
			response.sendRedirect("index.jsp");
		}
	}
	
	/**
	 * Logar.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(pessoa == null) {
			pessoa = new Pessoa();
		}
		pessoa.setLogin(request.getParameter("login"));
		pessoa.setSenha(request.getParameter("senha"));
		if (dao.validarLogin(pessoa)) {
			pessoa = dao.obterCadastroLogin(pessoa);
			HttpSession session = request.getSession(true);
			session.setAttribute("pessoa", pessoa);									//Setando sessão
			RequestDispatcher dispatcher = request.getRequestDispatcher("main");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("loginInvalido","Login e/ou senha inválido(s)!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			HttpSession session = request.getSession(true);
			session.invalidate();
			dispatcher.forward(request, response);
		}
	}
	
	/**
	 * Cadastrar.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		pessoa.setLogin(request.getParameter("login"));
		pessoa.setSenha(request.getParameter("senha"));
		pessoa.setCargoID(request.getParameter("cargo"));
		pessoa.setContatoID(request.getParameter("contato"));
		pessoa.setEnderecoID(request.getParameter("endereco"));
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setIdade(request.getParameter("idade"));
		pessoa.setCpf(request.getParameter("cpf"));
		if (dao.verificaExistenciaCpf(pessoa.getCpf()) || dao.verificaExistenciaLogin(pessoa.getLogin())) {
			HttpSession session = request.getSession(true);					
			session.setAttribute("info", "Login/CPF já cadastrado!");	//Setando sessão
			response.sendRedirect("Cadastrar.jsp");
		} else {
			dao.criarCadastro(pessoa);
			pessoa = dao.obterCadastroLogin(pessoa);
			HttpSession session = request.getSession(true);					
			session.setAttribute("pessoa", pessoa);										//Setando sessão
			response.sendRedirect("main");
		}
	}
	
	/**
	 * Alterar cadastro.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void alterarCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		pessoa.setPessoaID(request.getParameter("pessoaID"));
		pessoa.setLogin(request.getParameter("login"));
		pessoa.setSenha(request.getParameter("senha"));
		pessoa.setCargoID(request.getParameter("cargo"));
		pessoa.setContatoID(request.getParameter("contato"));
		pessoa.setEnderecoID(request.getParameter("endereco"));
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setIdade(request.getParameter("idade"));
		pessoa.setCpf(request.getParameter("cpf"));
		dao.atualizarCadastro(pessoa);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main");
		dispatcher.forward(request, response);
	}
	
	/**
	 * Obter todos cadastros.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void obterTodosCadastros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<Pessoa> lista = dao.obterCadastros();
		HttpSession session = request.getSession();
		session.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("todosCadastros.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Criar.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void criar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		pessoa.setLogin(request.getParameter("login"));
		pessoa.setSenha(request.getParameter("senha"));
		pessoa.setCargoID(request.getParameter("cargo"));
		pessoa.setContatoID(request.getParameter("contato"));
		pessoa.setEnderecoID(request.getParameter("endereco"));
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setIdade(request.getParameter("idade"));
		pessoa.setCpf(request.getParameter("cpf"));
		if (dao.verificaExistenciaCpf(pessoa.getCpf()) || dao.verificaExistenciaLogin(pessoa.getLogin())) {
			HttpSession session = request.getSession(true);	
			this.pessoa = dao.obterCadastro(pessoa);
			session.setAttribute("info", "Login/CPF já cadastrado!");	//Setando sessão
			response.sendRedirect("criar.jsp");
		} else {
			dao.criarCadastro(pessoa);
			pessoa = dao.obterCadastro(pessoa);
			response.sendRedirect("obtemTodos");
		}
	}
	
	/**
	 * Editar.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Pessoa edicao = new Pessoa();
		edicao.setPessoaID(request.getParameter("pessoaID"));
		edicao = dao.obterCadastro(edicao);
		String cpfInicial = edicao.getCpf();
		String loginInicial = edicao.getLogin();
		HttpSession session = request.getSession();
		session.setAttribute("edicao", edicao);
		session.setAttribute("cpfInicial", cpfInicial);
		session.setAttribute("loginInicial", loginInicial);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * Deletar.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void deletar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Pessoa excluir = new Pessoa();
		excluir.setPessoaID(request.getParameter("pessoaID"));
		dao.deletarCadastro(excluir);
		response.sendRedirect("obtemTodos");
	}
	
	/**
	 * Editar pt 2.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void editarPt2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		Pessoa edicao = (Pessoa) session.getAttribute("edicao");
		String cpfInicial = (String)session.getAttribute("cpfInicial");
		String loginInicial = (String)session.getAttribute("loginInicial");
		if(cpfInicial != edicao.getCpf()) {
			if(dao.verificaExistenciaCpf(edicao.getCpf())) {
				session.setAttribute("info", "CPF já cadastrado!");	
				response.sendRedirect("editar.jsp");
			}
		} else if(loginInicial != edicao.getLogin()) {
			if(dao.verificaExistenciaLogin(edicao.getLogin())) {
				session.setAttribute("info", "Login já cadastrado!");	
				response.sendRedirect("editar.jsp");
			}
		} else {
			dao.atualizarCadastro(edicao);
			response.sendRedirect("obtemTodos");
		}
	}
	
	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Document document = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "cadastros.pdf");
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			document.add(new Paragraph("Lista de cadastros:"));
			document.add(new Paragraph(" "));
			PdfPTable table = new PdfPTable(5);
			PdfPCell column1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell column2 = new PdfPCell(new Paragraph("Idade"));
			PdfPCell column3 = new PdfPCell(new Paragraph("Local (estado)"));
			PdfPCell column4 = new PdfPCell(new Paragraph("Função"));
			PdfPCell column5 = new PdfPCell(new Paragraph("Cadastro ID"));
			table.addCell(column1);
			table.addCell(column2);
			table.addCell(column3);
			table.addCell(column4);
			table.addCell(column5);
			ArrayList<Pessoa> lista = dao.obterCadastros();
			for(int i=0; i<lista.size(); i++) {
				table.addCell(lista.get(i).getNome().toUpperCase());
				table.addCell(lista.get(i).getIdade());
				table.addCell(lista.get(i).getEndereco().getEstado());
				table.addCell(lista.get(i).getCargo().getCargo());
				table.addCell(lista.get(i).getPessoaID());
			}
			document.add(table);
			document.close();
		} catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			document.close();
		}
	}
}
	
