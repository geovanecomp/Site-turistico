package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Circuito;

import service.CircuitoService;

/**
 * Servlet implementation class SelecionarCircuitoController
 */
public class SelecionarCircuitoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelecionarCircuitoController() {
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
		String strCircuito = request.getParameter("idCircuito");
		String status = "";
		HttpSession session = request.getSession();
		if(strCircuito.length()>0){
			int idCircuito = Integer.parseInt(strCircuito);
			CircuitoService cs = new CircuitoService();
			Circuito circuitoSessao = cs.buscarCircuitoPeloId(idCircuito);
			String statusCircuito = "Circuito "+circuitoSessao.getNome()+" selecionado.";
			session.setAttribute("circuitoSessao", circuitoSessao);
			session.setAttribute("statusCircuito",statusCircuito);
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			disp.forward(request,response);
		}else{
			status = "Favor, preencher todos os dados corretamente.";
			request.setAttribute("status",status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
		}
	}

}
