package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.PontoTuristicoService;
import entities.PontoTuristico;

/**
 * Servlet implementation class BuscarPontoTuristicoPeloNomeController
 */
public class BuscarPontoTuristicoPeloNomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPontoTuristicoPeloNomeController() {
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
		if(nome.length()>0){
			PontoTuristicoService pts = new PontoTuristicoService();
			List<PontoTuristico> listaPontosTuristicos = pts.buscarPontoTuristicoPeloNome(nome);
			if(listaPontosTuristicos.size()>0){
				request.setAttribute("listaPontosTuristicos", listaPontosTuristicos);
				RequestDispatcher disp = request.getRequestDispatcher("exibirPontosTuristicos.jsp");
				disp.forward(request,response);
			}
			else{
				String status = "Nenhuma empresa encontrada.";
				request.setAttribute("status", status);
				RequestDispatcher disp = request.getRequestDispatcher("buscarPontoTuristicoPeloNome.jsp");
				disp.forward(request,response);		
			}
			
		}
		else{
			String status = "Nome da empresa não fornecido";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("buscarPontoTuristicoPeloNome.jsp");
			disp.forward(request,response);		
		}
	}

}
