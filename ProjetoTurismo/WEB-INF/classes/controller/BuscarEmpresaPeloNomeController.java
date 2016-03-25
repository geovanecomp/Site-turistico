package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.EmpresaService;
import entities.Empresa;

/**
 * Servlet implementation class BuscarEmpresaPeloNomeController
 */
public class BuscarEmpresaPeloNomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarEmpresaPeloNomeController() {
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
			EmpresaService es = new EmpresaService();
			List<Empresa> listaEmpresas = es.buscarEmpresaPeloNome(nome);
			if(listaEmpresas.size()>0){
				request.setAttribute("listaEmpresas", listaEmpresas);
				RequestDispatcher disp = request.getRequestDispatcher("exibirEmpresas.jsp");
				disp.forward(request,response);
			}
			else{
				String status = "Nenhuma empresa encontrada.";
				request.setAttribute("status", status);
				RequestDispatcher disp = request.getRequestDispatcher("conhecerNovosLugares.jsp");
				disp.forward(request,response);		
			}
			
		}
		else{
			String status = "Nome da empresa não fornecido";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("conhecerNovosLugares.jsp");
			disp.forward(request,response);		
		}
	}

}
