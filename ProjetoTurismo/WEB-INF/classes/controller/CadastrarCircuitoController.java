package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Circuito;

import service.CircuitoService;

/**
 * Servlet implementation class CriarCircuitoController
 */
public class CadastrarCircuitoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarCircuitoController() {
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
		String nome = request.getParameter("nome");
		String strData = request.getParameter("data");
		String descricao = request.getParameter("descricao");
		String strIdUsuario = request.getParameter("idUsuario");
		CircuitoService cs = new CircuitoService();
		String status = "";
		if(nome.length()>0 && strData.length()>0 && descricao.length()>0 && strIdUsuario.length()>0 && cs.validarData(strData)){
			HttpSession session = request.getSession();
			if(session.getAttribute("circuito")!=null){
				session.removeAttribute("circuito");
			}
			int idUsuario = Integer.parseInt(strIdUsuario);
			int intData = Integer.parseInt(cs.retornaNumerosData(strData));
			Date data = new Date((intData%10000)-1900, ((intData/10000)%100)-1, intData/1000000);//yyyy/mm/dd
			Circuito circuito = new Circuito(nome, data, descricao, idUsuario);
			cs.cadastrarCircuito(circuito);
			status = "Circuito "+circuito.getNome()+" cadastrado com sucesso. Para selecionar-lo, basta ir em seu perfil";
			session.setAttribute("circuito", circuito);
			request.setAttribute("status",status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
		}
		else{
			status = "Favor, preencher todos os dados corretamente.";
			request.setAttribute("status",status);
			RequestDispatcher disp = request.getRequestDispatcher("criarCircuito.jsp");
			disp.forward(request,response);
		}
	}

}
