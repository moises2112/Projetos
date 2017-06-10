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
import br.com.dog.model.dao.CachorroDAO;
import br.com.dog.model.dao.UsuarioDAO;
import br.com.dog.model.dao.impl.jdbc.CachorroDao;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher(NavegacaoUtil.LOGIN);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		RequestDispatcher view = null;
		if (action.equalsIgnoreCase("logar")) {
			UsuarioDAO userDAO = new UsuarioDao();

			String senhaDaTela = request.getParameter("senha");
			String emailDaTela = request.getParameter("email");

			Usuario usuario = null;

			try {
				// erro esta na linha abaixo
				usuario = userDAO.buscarLoginSenha(senhaDaTela, emailDaTela);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (usuario != null) {
				view = request.getRequestDispatcher(NavegacaoUtil.HOME);
				// try {
				//
				// request.setAttribute("listaDeUsuarios", userDAO.readAll());
				// } catch (SQLException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
				request.setAttribute("usuarioLogado", usuario);
				CachorroDAO dogDAO = new CachorroDao();
				try {
					request.setAttribute("myDogs", dogDAO.buscaPorUsuario(usuario));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// HttpSession session = request.getSession();
				// session.setAttribute("usuario", usuario);
			} else {
				view = request.getRequestDispatcher(NavegacaoUtil.LOGIN);
				request.setAttribute("erroAoLogar", "Usuario ou senha inv�lido");
			}
		} else if (action.equalsIgnoreCase("logout")) {
			view = request.getRequestDispatcher(NavegacaoUtil.LOGIN);
			request.removeAttribute("usuarioLogado");
		}
		view.forward(request, response);
	}
}
