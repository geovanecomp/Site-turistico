package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TrajetoService;

/**
 * Servlet implementation class DeletarTrajetoController
 */
public class DeletarTrajetoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarTrajetoController() {
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
		String strIdEmpresa = request.getParameter("idEmpresa");
		String strIdPontoTuristico = request.getParameter("idPontoTuristico");
		String status = "";
		if(strIdEmpresa==null && strIdPontoTuristico!=null){
			int idPontoTuristico = Integer.parseInt(strIdPontoTuristico);
			TrajetoService ts = new TrajetoService();
			ts.deletarTrajetoPeloIdPontoTuristico(idPontoTuristico);
			status = "Trajeto deletado com sucesso.";
			request.setAttribute("status", status);
			RequestDispatcher disp =  request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request, response);
		}
		else if(strIdPontoTuristico==null && strIdEmpresa!=null){
			int idEmpresa = Integer.parseInt(strIdEmpresa);
			TrajetoService ts = new TrajetoService();
			ts.deletarTrajetoPeloIdEmpresa(idEmpresa);
			status = "Trajeto deletado com sucesso.";
			request.setAttribute("status", status);
			RequestDispatcher disp =  request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request, response);
		}
		else{
			status = "Favor, informe todos os dados corretamente";
			request.setAttribute("status", status);
			RequestDispatcher disp =  request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request, response);
		}
	}

}
