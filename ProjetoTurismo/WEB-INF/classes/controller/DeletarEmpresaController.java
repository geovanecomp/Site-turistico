package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpresaService;
import service.TelefoneEmpresaService;

/**
 * Servlet implementation class DeletarEmpresaController
 */
public class DeletarEmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarEmpresaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strIdEmpresa = request.getParameter("idEmpresa");
		if(strIdEmpresa.length()>0){
			int idEmpresa = Integer.parseInt(strIdEmpresa);
			EmpresaService es = new EmpresaService();
			TelefoneEmpresaService tes = new TelefoneEmpresaService();
			es.deletarEmpresaPeloId(idEmpresa);
			tes.deletarTelefoneEmpresa(idEmpresa);
			String status = "Empresa deletada com sucesso";
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
