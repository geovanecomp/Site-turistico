package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Usuario;

import service.UsuarioService;

/**
 * Servlet implementation class BuscarUsuarioPeloIdController
 */
public class BuscarUsuarioPeloIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarUsuarioPeloIdController() {
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
		String strIdUsuario = request.getParameter("idUsuario");
		if(strIdUsuario.length()>0 && strIdUsuario!=null){
			int idUsuario = Integer.parseInt(strIdUsuario);
			UsuarioService us = new UsuarioService();
			Usuario usuario = us.buscarUsuarioPeloId(idUsuario);
			String strNascimento = usuario.getNascimento()+"";
			String strDia = "";
			String strMes = "";
			String strAno = "";
			for(int i = 0; i<10 ; i++){
				if(i<=3){
					strAno = strAno+strNascimento.charAt(i);
				}
				else if(i>=5 && i<=6){
					strMes = strMes+strNascimento.charAt(i);
				}
				else if(i>=8){
					strDia = strDia+strNascimento.charAt(i);
				}
			}
			strNascimento = strDia+"/"+strMes+"/"+strAno;
			request.setAttribute("strNascimento", strNascimento);
			request.setAttribute("usuario", usuario);
			RequestDispatcher disp = request.getRequestDispatcher("informacoesUsuario.jsp");
			disp.forward(request,response);	
		}
		else{
			String status = "Id usuario n�o fornecido";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
		}
	}

}
