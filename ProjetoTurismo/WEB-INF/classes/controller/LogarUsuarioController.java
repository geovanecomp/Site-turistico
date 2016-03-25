package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UsuarioService;
import entities.Usuario;

/**
 * Servlet implementation class LogarUsuarioController
 */
public class LogarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogarUsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login  = request.getParameter("login");
		String senha = request.getParameter("senha");
		if(login!=null && login.length()>0 && senha !=null && senha.length()>0){
			UsuarioService us = new UsuarioService();
			Usuario usuario = us.buscarUsuarioPorLogin(login);
			if(usuario!=null){
				if(login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())){
					//String status = "Bem vindo "+usuario.getNome()+", login efetuado.";
					HttpSession session = request.getSession();				
					//request.setAttribute("status", status);
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
					session.setAttribute("nascimentoUsuarioSessao", strNascimento);
					session.setAttribute("usuarioSessao", usuario);
					RequestDispatcher disp = request.getRequestDispatcher("perfilUsuario.jsp");
					disp.forward(request, response);
					//vai ser login efetuado com sucesso, e encaminhar para uma pagina de sucesso/inicio
				}
			}
			else{
				String status = "Usuário não encontrado";
				request.setAttribute("status",status);
				RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
				disp.forward(request,response);
			}
		}
		else{
			String status = "Favor informe todos os dados";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
			disp.forward(request, response);
		}
		//se nao foi redirecionado nos ifs acima, então irá retornar a pagina informando dos dados inválidos.
	}
	
}
