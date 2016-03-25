package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Usuario;

import service.UsuarioService;

/**
 * Servlet implementation class AlterarDadosUsuarioController
 */
public class AlterarDadosUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarDadosUsuarioController() {
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
		HttpSession session = request.getSession();
		Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioSessao");
		
		int idUsuario = Integer.parseInt(strIdUsuario);
		
		int administrador = 0; 
		if(strAdministrador!=null && strAdministrador.length()>0){
			administrador = Integer.parseInt(strAdministrador);
		}
		String strDia = "";
		String strMes = "";
		String strAno = "";
		for(int i = 0; i<10 ; i++){
			if(i<2){
				strDia = strDia+strNascimento.charAt(i);
			}
			else if(i>2 && i<=4){
				strMes = strMes+strNascimento.charAt(i);
			}
			else if(i>5){
				strAno = strAno+strNascimento.charAt(i);
			}
		}
		strNascimento = strDia+strMes+strAno;
		int intNascimento = Integer.parseInt(strNascimento);

		Date nascimento = new Date((intNascimento%10000)-1900, ((intNascimento/10000)%100)-1, intNascimento/1000000);//yyyy/mm/dd
		if(nome.length()>0 && login.length()>0 && senha.length()>0 && email.length()>0 && sexo.length()>0 && 
				 cidade.length()>0  && estado.length()>0 &&	profissao.length()>0 && estadoCivil.length()>0 &&
				 escolaridade.length()>0){
			Usuario usuario = new Usuario(idUsuario, nome, login, senha, email, sexo, nascimento, cidade, estado, profissao, estadoCivil, escolaridade, administrador);
			UsuarioService us = new UsuarioService();
			us.alterarDadosUsuario(usuario);
			if(usuarioSessao.getIdUsuario() == idUsuario){
				session.removeAttribute("usuarioSessao");
				usuario = us.buscarUsuarioPeloId(usuario.getIdUsuario());
				session.setAttribute("usuarioSessao", usuario);
				
			}
			String status = "Atualização efetuada com sucesso!";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
								
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
			request.setAttribute("status", "Favor preencha todos os campos corretamente.");
			RequestDispatcher disp = request.getRequestDispatcher("alterarDadosUsuario.jsp");
			disp.forward(request,response);
		}
	}

}
