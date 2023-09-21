package model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * The Class VerificaLoginProfessor.
 */
public class VerificaLoginProfessor {
	
	/**
	 * Verifica login.
	 *
	 * @param session the session
	 * @param request the request
	 * @param response the response
	 */
	public void verificaLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		Pessoa pessoa = (Pessoa)session.getAttribute("pessoa");
		if(pessoa == null ||pessoa.getCargoID() == null || pessoa.getCargoID().isEmpty() || pessoa.getCargoID().equals("3")) {
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
