package br.com.dog.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.com.baseweb.model.dao.UsuarioDAOMock;
//import br.com.baseweb.model.entity.Usuario;
//import br.com.dog.controller.util.NavegacaoUtil;
//
///**
// * Servlet implementation class UsuarioController
// */
//@WebServlet("/UsuarioController.do")
//public class UsuarioController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	
//	  private UsuarioDAOMock usuarioDAO;
//	  
//	 
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public UsuarioController() {
//    	usuarioDAO = new UsuarioDAOMock();
//        // TODO Auto-generated constructor stub
//    }
//
//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("Test");
//	}
//
//    
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String forward = "";
//        String action = request.getParameter( "action" );
// 
//        if( action.equalsIgnoreCase( "remover" ) ) {
//            forward = NavegacaoUtil.LIST_USUARIO;
//            int usuarioId = Integer.parseInt( request.getParameter("usuarioId") );
//            Usuario usuarioParaDeletacao = usuarioDAO.buscarUsuarioPorId(usuarioId);
//            usuarioDAO.removerUsuario(usuarioParaDeletacao);
//            
//            request.setAttribute("listaDeUsuarios", usuarioDAO.buscarTodos());
//        }
//        else if( action.equalsIgnoreCase( "editar" ) ) {
//            forward = NavegacaoUtil.INSERIR_OU_EDITAR;
//            int usuarioId = Integer.parseInt( request.getParameter("usuarioId") );
//            Usuario usuarioEdicao = usuarioDAO.buscarUsuarioPorId(usuarioId);
//            request.setAttribute("usuario", usuarioEdicao);
//        }
//        else if( action.equalsIgnoreCase( "inserir" ) ) {
//            forward = NavegacaoUtil.INSERIR_OU_EDITAR;
//        }
//        else {
//            forward = NavegacaoUtil.LIST_USUARIO;
//            List<Usuario> lista = usuarioDAO.buscarTodos();
//            
//            request.setAttribute("listaDeUsuarios", lista);
//        }
//        RequestDispatcher view = request.getRequestDispatcher( forward );
//        view.forward(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Usuario usuario = new Usuario();
//        usuario.setNome( request.getParameter( "nome" ) );
//        usuario.setEmail( request.getParameter( "email" ) );
//        usuario.setSenha( request.getParameter( "senha" ) );
//        String usuarioId = request.getParameter("usuarioId");
//        
//        
//        if( usuarioId == null || usuarioId.isEmpty() )
//        	usuarioDAO.adicionarUsuario(usuario);
//        else {
//        	usuario.setId(Integer.parseInt(usuarioId));
//        	usuarioDAO.atualizarUsuario(usuario);
//        }
//        RequestDispatcher view = request.getRequestDispatcher( NavegacaoUtil.LIST_USUARIO );
//        request.setAttribute("listaDeUsuarios", usuarioDAO.buscarTodos());
//        view.forward(request, response);
//	}
//
//}
