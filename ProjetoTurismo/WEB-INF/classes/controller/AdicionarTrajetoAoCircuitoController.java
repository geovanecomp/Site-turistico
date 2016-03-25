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
import entities.Trajeto;
import entities.Usuario;

import service.CircuitoService;
import service.TrajetoService;


/**
 * Servlet implementation class AdicionarTrajetoAoCircuitoController
 */
public class AdicionarTrajetoAoCircuitoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarTrajetoAoCircuitoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Circuito circuitoSessao = (Circuito)session.getAttribute("circuitoSessao");
		String strIdEmpresa = request.getParameter("idEmpresa");
		String strIdPontoTuristico = request.getParameter("idPontoTuristico");
		String status = "";
		if(strIdEmpresa != "0" || strIdPontoTuristico != "0" && circuitoSessao!=null){
			int idPontoTuristico = Integer.parseInt(strIdPontoTuristico);
			int idEmpresa = Integer.parseInt(strIdEmpresa);
			TrajetoService ts = new TrajetoService();			
			int idCircuito = circuitoSessao.getIdCircuito();
			Date data = circuitoSessao.getData();
			int idUsuario = circuitoSessao.getIdUsuario();
			Trajeto trajeto = new Trajeto(data, idUsuario, idEmpresa, idPontoTuristico, idCircuito);
			ts.cadastrarTrajeto(trajeto);
			status = "Trajeto inserido ao circuito com sucesso!";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
		}
		else if(circuitoSessao==null){
			status = "Por favor selecione ou crie um circuito antes de adicionar um trajeto";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
		}
		else{
			status = "Por favor informe todos os dados corretamente";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
		}
		
	}

}
