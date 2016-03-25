package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.PontoTuristicoService;

/**
 * Servlet implementation class DeletarPontoTuristicoController
 */
public class DeletarPontoTuristicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarPontoTuristicoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strIdPontoTuristico = request.getParameter("idPontoTuristico");
		if(strIdPontoTuristico.length()>0){
			int idPontoTuristico = Integer.parseInt(strIdPontoTuristico);
			PontoTuristicoService pts = new PontoTuristicoService();
			pts.deletarPontoTuristicoPeloId(idPontoTuristico);
			String status = "Ponto Turistico deletado com sucesso";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
