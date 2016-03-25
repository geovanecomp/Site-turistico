package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Circuito;

import service.CircuitoService;

/**
 * Servlet implementation class AlterarDadosCircuitoController
 */
public class AlterarDadosCircuitoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarDadosCircuitoController() {
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
		String strData = request.getParameter("data");
		String descricao = request.getParameter("descricao");
		String strIdCircuito = request.getParameter("idCircuito");
		String strIdUsuario = request.getParameter("idUsuario");
		String status = "";
		if((nome.length()>0 || nome!=null) && (strData.length()>0 || strData!=null) && (descricao.length()>0 || descricao!=null) &&
				(strIdCircuito.length()>0 || strIdCircuito!=null) && (strIdUsuario.length()>0 || strIdUsuario!=null)){
			int idCircuito = Integer.parseInt(strIdCircuito);
			int idUsuario = Integer.parseInt(strIdUsuario); 
			CircuitoService cs = new CircuitoService();
			int intData = Integer.parseInt(cs.retornaNumerosData(strData));
			Date data = new Date((intData%10000)-1900, ((intData/10000)%100)-1, intData/1000000);//yyyy/mm/dd
			Circuito circuito = new Circuito(idCircuito, nome, data, descricao, idUsuario);
			cs.alterarDadosCircuito(circuito);
			status = "Circuito alterado corretamente.";
			request.setAttribute("status",status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
			
		}
		else{
			status = "Favor, preencher todos os dados corretamente.";
			request.setAttribute("status",status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
		}
	}

}
