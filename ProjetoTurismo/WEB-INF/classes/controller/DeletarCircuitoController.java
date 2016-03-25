package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CircuitoService;
import service.EmpresaService;
import service.TelefoneEmpresaService;

/**
 * Servlet implementation class DeletarCircuitoController
 */
public class DeletarCircuitoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarCircuitoController() {
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
		String strIdCircuito = request.getParameter("idCircuito");
		if(strIdCircuito.length()>0){
			int idCircuito = Integer.parseInt(strIdCircuito);
			CircuitoService cs = new CircuitoService();
			cs.deletarCircuitoPeloId(idCircuito);
			String status = "Circuito deletado com sucesso";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);	
		}
	}

}
