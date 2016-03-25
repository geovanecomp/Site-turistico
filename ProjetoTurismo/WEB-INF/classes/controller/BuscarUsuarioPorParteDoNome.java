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
 * Servlet implementation class BuscarUsuarioPorParteDoNome
 */
public class BuscarUsuarioPorParteDoNome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarUsuarioPorParteDoNome() {
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
		String nome = request.getParameter("nome");
		if(nome.length()>0){
			UsuarioService us = new UsuarioService();
			List<Usuario> listaUsuarios = us.buscarUsuarioPorParteDoNome(nome);
			if(listaUsuarios.size()>0){
				request.setAttribute("listaUsuarios", listaUsuarios);
				RequestDispatcher disp = request.getRequestDispatcher("exibirUsuarios.jsp");
				disp.forward(request,response);
			}
			else{
				String status = "Nenhum usuário encontrado.";
				request.setAttribute("status", status);
				RequestDispatcher disp = request.getRequestDispatcher("buscarUsuarioPorParteDoNome.jsp");
				disp.forward(request,response);		
			}
			
		}
		else{
			String status = "Nome do usuario não fornecido";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("buscarUsuarioPorParteDoNome.jsp");
			disp.forward(request,response);		
		}
		
	}

}
