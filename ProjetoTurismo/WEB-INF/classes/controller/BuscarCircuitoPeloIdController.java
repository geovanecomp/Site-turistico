package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CircuitoService;
import service.TrajetoService;
import entities.Circuito;
import entities.Empresa;
import entities.PontoTuristico;
import entities.Trajeto;

/**
 * Servlet implementation class BuscarCircuitoPeloIdController
 */
public class BuscarCircuitoPeloIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarCircuitoPeloIdController() {
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
		String strVerificador = request.getParameter("verificador");
		String status = "";
		if(strIdCircuito.length()>0){
			int idCircuito = Integer.parseInt(strIdCircuito);
			CircuitoService es =  new CircuitoService();
			TrajetoService ts = new TrajetoService();
			List<Trajeto> listaTrajetos = ts.buscarTrajetoPeloIdCircuito(idCircuito);
			List<Empresa> listaTrajetosEmpresa = ts.retornaEmpresa(listaTrajetos);
			List<PontoTuristico> listaTrajetosPontoTuristico = ts.retornaPontoTuristico(listaTrajetos);
			Circuito circuito= es.buscarCircuitoPeloId(idCircuito);
			request.setAttribute("circuito", circuito);
			request.setAttribute("listaTrajetosEmpresa", listaTrajetosEmpresa);
			request.setAttribute("listaTrajetosPontoTuristico", listaTrajetosPontoTuristico);
		
			if(strVerificador==null){
				RequestDispatcher disp = request.getRequestDispatcher("alterarDadosCircuito.jsp");
				disp.forward(request,response);
			}
			else{
				RequestDispatcher disp = request.getRequestDispatcher("informacoesCircuito.jsp");
				disp.forward(request,response);
			}
			
		}
		else{
			status = "Favor preencher todos os dados corretamente.";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
		}
	}

}
