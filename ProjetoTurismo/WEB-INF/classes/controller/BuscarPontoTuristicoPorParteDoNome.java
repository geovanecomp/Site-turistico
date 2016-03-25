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
 * Servlet implementation class BuscarPontoTuristicoPorParteDoNome
 */
public class BuscarPontoTuristicoPorParteDoNome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPontoTuristicoPorParteDoNome() {
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
			List<PontoTuristico> listaPontosTuristicos = pts.buscarPontoTuristicoPorParteDoNome(nome);
			if(listaPontosTuristicos.size()>0){
				request.setAttribute("listaPontosTuristicos", listaPontosTuristicos);
				RequestDispatcher disp = request.getRequestDispatcher("exibirPontosTuristicos.jsp");
				disp.forward(request,response);
			}
			else{
				String status = "Nenhum ponto turístico encontrado.";
				request.setAttribute("status", status);
				RequestDispatcher disp = request.getRequestDispatcher("conhecerNovosLugares.jsp");
				disp.forward(request,response);		
			}
			
		}
		else{
			String status = "Nome do ponto turístico não fornecido";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("conhecerNovosLugares.jsp");
			disp.forward(request,response);		
		}
	}

}
