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
 * Servlet implementation class BuscarNovosAtrativosController
 */
public class BuscarNovosAtrativosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarNovosAtrativosController() {
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
		String verificador = request.getParameter("verificador");
		EmpresaService es = new EmpresaService();
		PontoTuristicoService pts = new PontoTuristicoService();
		List<Empresa> listaEmpresas = es.buscarCincoUltimasEmpresas();
		List<PontoTuristico> listaPontosTuristicos = pts.buscarCincoUltimosPontoTuristicos();
		request.setAttribute("listaEmpresas", listaEmpresas);
		request.setAttribute("listaPontosTuristicos", listaPontosTuristicos);
		
		if(verificador==null){
			RequestDispatcher disp = request.getRequestDispatcher("conhecerNovosLugares.jsp");
			disp.forward(request,response);
		}
		else if(verificador.equals("2")){
			listaEmpresas = es.buscarDuasUltimasEmpresas();
			listaPontosTuristicos = pts.buscarDoisUltimosPontoTuristicos();
			request.setAttribute("listaEmpresas", listaEmpresas);
			request.setAttribute("listaPontosTuristicos", listaPontosTuristicos);
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			disp.forward(request,response);
		}
		else{
			RequestDispatcher disp = request.getRequestDispatcher("painelAdministrador.jsp");
			disp.forward(request,response);
		}
		
	}

}
