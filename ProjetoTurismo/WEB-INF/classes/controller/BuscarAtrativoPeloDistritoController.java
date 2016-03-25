package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Empresa;
import entities.PontoTuristico;

import service.EmpresaService;
import service.PontoTuristicoService;

/**
 * Servlet implementation class BuscarAtrativoPeloDistritoController
 */
public class BuscarAtrativoPeloDistritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarAtrativoPeloDistritoController() {
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
		String distrito = request.getParameter("distrito");
		if(distrito.length()>0 && distrito !=null){
			EmpresaService es = new EmpresaService();
			PontoTuristicoService pts = new PontoTuristicoService();
			List<Empresa> listaEmpresas = es.buscarEmpresaPeloDistrito(distrito);
			List<PontoTuristico> listaPontosTuristicos = pts.buscarPontoTuristicoPeloDistrito(distrito);
			request.setAttribute("listaEmpresas", listaEmpresas);
			request.setAttribute("listaPontosTuristicos", listaPontosTuristicos);
			RequestDispatcher disp = request.getRequestDispatcher("exibirAtrativos.jsp");
			disp.forward(request,response);
			
		}
		else{
			String status = "Nenhum atrativo encontrado.";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("conhecerNovosLugares.jsp");
			disp.forward(request,response);	
		}
	}

}

