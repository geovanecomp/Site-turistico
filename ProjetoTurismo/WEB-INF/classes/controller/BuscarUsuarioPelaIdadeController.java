package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Usuario;

import service.UsuarioService;

/**
 * Servlet implementation class BuscarUsuarioPelaIdadeController
 */
public class BuscarUsuarioPelaIdadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarUsuarioPelaIdadeController() {
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
		String strIdade = request.getParameter("idade");
		if(strIdade.length()>0){
			int idade = Integer.parseInt(strIdade);
			UsuarioService us = new UsuarioService();
			List<Usuario> listaUsuariosIdade = us.getIdade(us.buscarTodosUsuarios(), idade);
					
			if(listaUsuariosIdade.size()>0){
				request.setAttribute("listaUsuarios", listaUsuariosIdade);
				RequestDispatcher disp = request.getRequestDispatcher("exibirUsuarios.jsp");
				disp.forward(request,response);
			}
			else{
				String status = "Nenhum usuário encontrado";
				request.setAttribute("status", status);
				RequestDispatcher disp = request.getRequestDispatcher("buscarUsuarioPelaIdade.jsp");
				disp.forward(request,response);	
			}
		}
		else{
			String status = "Idade do usuário não fornecida";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("buscarUsuarioPelaIdade.jsp");
			disp.forward(request,response);	
		}
	}

}
