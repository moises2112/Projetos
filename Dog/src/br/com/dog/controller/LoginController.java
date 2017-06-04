package br.com.dog.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.dog.controller.util.NavegacaoUtil;
import br.com.dog.model.dao.UsuarioDAO;
import br.com.dog.model.dao.impl.jdbc.UsuarioDao;
import br.com.dog.model.entity.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request
				.getRequestDispatcher(NavegacaoUtil.LOGIN);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = null;
		UsuarioDAO userDAO = new UsuarioDao();

		String emailDaTela = request.getParameter("email");
		String senhaDaTela = request.getParameter("senha");

		Usuario usuario=null;
		try {
			usuario = userDAO.buscarLoginSenha(senhaDaTela, emailDaTela);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (usuario != null) {
			view = request.getRequestDispatcher(NavegacaoUtil.LIST_USUARIO);
			try {
				request.setAttribute("listaDeUsuarios", userDAO.readAll());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("usuarioLogado", usuario);

			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
		} else {
			view = request.getRequestDispatcher(NavegacaoUtil.LOGIN);
			request.setAttribute("erroAoLogar", "Usuario n�o encontrado");
		}
		view.forward(request, response);
	}

}
