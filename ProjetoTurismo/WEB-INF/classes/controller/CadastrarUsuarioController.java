package controller;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UsuarioService;

import entities.Usuario;

/**
 * Servlet implementation class CadastrarUsuarioController
 */
public class CadastrarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarUsuarioController() {
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
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String sexo = request.getParameter("sexo");
		String strNascimento = request.getParameter("nascimento");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String profissao = request.getParameter("profissao");
		String estadoCivil = request.getParameter("estadoCivil");
		String escolaridade = request.getParameter("escolaridade");
		String strAdministrador =  request.getParameter("administrador");
		String status = "";
		int administrador = 0;
		UsuarioService us = new UsuarioService();
		if(strAdministrador!=null && strAdministrador.length()>0){
			administrador = Integer.parseInt(strAdministrador);
		}

		if(nome.length()>0 && login.length()>0 && senha.length()>0 && email.length()>0 && sexo.length()>0 && 
				cidade.length()>0  && estado.length()>0 && profissao.length()>0 && estadoCivil.length()>0 && escolaridade.length()>0 &&
				strNascimento.length()>0 && us.validarDataNascimento(strNascimento)){
			if(us.buscarUsuarioPorLogin(login)==null){
				Date nascimento = null;
				int intNascimento = Integer.parseInt(us.retornaNumerosData(strNascimento));
				nascimento = new Date((intNascimento%10000)-1900, ((intNascimento/10000)%100)-1, intNascimento/1000000);//yyyy/mm/dd
				Usuario usuario = new Usuario(nome, login, senha, email, sexo, nascimento, cidade, estado, profissao, estadoCivil, escolaridade,administrador);		
				us.cadastrarUsuario(usuario);
				status = "Cadastro efetuado com sucesso!";
				request.setAttribute("status", status);
				RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
				disp.forward(request,response);
			}
			else{
				status = "Login já utilizado, por favor escolha outro.";
				request.setAttribute("status", status);
				RequestDispatcher disp = request.getRequestDispatcher("cadastrarUsuario.jsp");
				disp.forward(request,response);
			}
						
		}
		else{
			String dadosUsuario[] = new String[11];
			dadosUsuario[0] = nome ;dadosUsuario[1] = login; dadosUsuario[2] = senha; dadosUsuario[3] = email; dadosUsuario[4] = sexo;
			dadosUsuario[5] = strNascimento; dadosUsuario[6] = cidade; dadosUsuario[7] = estado; dadosUsuario[8] = profissao; dadosUsuario[9] = estadoCivil; dadosUsuario[10] = escolaridade;
			for(int i = 0 ; i < dadosUsuario.length ; i++ ){
				if(dadosUsuario[i] == null || dadosUsuario[i].length()<1){
					dadosUsuario[i] = "";
				}
			}
			request.setAttribute("arrayDadosUsuario", dadosUsuario);
			status = "Favor preencha todos os campos corretamente.";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("cadastrarUsuario.jsp");
			disp.forward(request,response);
		}


	}
}
