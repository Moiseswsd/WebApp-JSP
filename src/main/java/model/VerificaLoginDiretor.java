package model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * The Class VerificaLoginDiretor.
 */
public class VerificaLoginDiretor {

	/**
	 * Verifica login.
	 *
	 * @param session the session
	 * @param request the request
	 * @param response the response
	 * @param pessoa the pessoa
	 */
	public void verificaLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response, Pessoa pessoa) {
		if(pessoa == null || pessoa.getCargoID() == null || pessoa.getCargoID().isEmpty() || pessoa.getCargoID().isBlank() ||!pessoa.getCargoID().equals("1")) {
			try {
			session.invalidate();
			pessoa.resetarBean();
			response.sendRedirect("index.jsp");
			} catch(Exception e) {
				System.out.println("Erro no model.VerificaLogin");
			}
		}
	}	
}

