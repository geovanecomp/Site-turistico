package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.PontoTuristicoService;
import service.PontuacaoPontoTuristicoService;
import entities.PontuacaoPontoTuristico;

/**
 * Servlet implementation class CadastrarPontuacaoPontoTuristicoController
 */
public class CadastrarPontuacaoPontoTuristicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarPontuacaoPontoTuristicoController() {
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
		String strPontoTuristico = request.getParameter("idPontoTuristico");
		String strPontuacao = request.getParameter("pontuacao");
		String strIdUsuario = request.getParameter("idUsuario");
		if(strPontoTuristico.length()>0 && strPontoTuristico!=null && strPontuacao.length()>0 && strPontuacao!=null && strIdUsuario.length()>0 && strIdUsuario!=null ){
			int idPontoTuristico = Integer.parseInt(strPontoTuristico);
			int pontuacao = Integer.parseInt(strPontuacao);
			int idUsuario = Integer.parseInt(strIdUsuario);
			PontuacaoPontoTuristico pontuacaoPontoTuristico = new PontuacaoPontoTuristico(idPontoTuristico, idUsuario, pontuacao);
			PontuacaoPontoTuristicoService ppts = new PontuacaoPontoTuristicoService();
			PontoTuristicoService pts = new PontoTuristicoService();
			ppts.cadastrarPontuacaoPontuacaoPontoTuristico(pontuacaoPontoTuristico);
			int novaPontuacao = ppts.retornarMediaPontuacaoPontoTuristico(idPontoTuristico);
			pts.alterarPontuacaoEmpresa(idPontoTuristico, novaPontuacao);
			String status = "Pontuação cadastrada com sucesso!";
			request.setAttribute("status", status);
			//RequestDispatcher disp = request.getRequestDispatcher("BuscarEmpresaPeloIdController.do?idEmpresa="+strIdEmpresa+"&verificador=1");
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
		}
	}

}
