package br.com.baseweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.baseweb.controller.util.NavegacaoUtil;
import br.com.baseweb.model.dao.UsuarioDAOMock;
import br.com.baseweb.model.entity.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAOMock usuarioDAO;
	  
	  
	/**
     * Default constructor. 
     */
    public LoginController() {
    	usuarioDAO = new UsuarioDAOMock();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher( NavegacaoUtil.LOGIN );
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = null;
        
        String emailDaTela  = request.getParameter("email");
        String senhaDaTela = request.getParameter("senha");

        Usuario usuario = usuarioDAO.buscarUsuarioPorNomeESenha(emailDaTela, senhaDaTela);
        
       	if(usuario!=null){
           	view = request.getRequestDispatcher( NavegacaoUtil.LIST_USUARIO );
            request.setAttribute("listaDeUsuarios", usuarioDAO.buscarTodos());
            request.setAttribute("usuarioLogado", usuario);
            
            HttpSession session=request.getSession();  
            session.setAttribute("usuario", usuario);
       	}else{
           	view = request.getRequestDispatcher( NavegacaoUtil.LOGIN );
            request.setAttribute("erroAoLogar", "Usuario não encontrado");   		
       	}
        view.forward(request, response);
	}

}
