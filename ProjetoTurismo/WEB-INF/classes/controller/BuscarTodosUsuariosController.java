package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Usuario;

import service.UsuarioService;

/**
 * Servlet implementation class BuscarTodosUsuariosController
 */
public class BuscarTodosUsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarTodosUsuariosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usuario usuarioSessao = (Usuario)session.getAttribute("usuarioSessao");
		if(usuarioSessao!=null){
			UsuarioService us = new UsuarioService();
			List<Usuario> listaUsuarios = us.buscarTodosUsuarios();
			request.setAttribute("listaUsuarios", listaUsuarios);
			RequestDispatcher disp = request.getRequestDispatcher("exibirUsuarios.jsp");
			disp.forward(request,response);			
			
		}
		else{
			String status = "Erro";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);		
		}
	}

}
