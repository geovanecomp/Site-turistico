package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpresaService;
import service.PontuacaoEmpresaService;

import entities.PontuacaoEmpresa;

/**
 * Servlet implementation class CadastrarPontuacaoEmpresaController
 */
public class CadastrarPontuacaoEmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarPontuacaoEmpresaController() {
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
		String strIdEmpresa = request.getParameter("idEmpresa");
		String strPontuacao = request.getParameter("pontuacao");
		String strIdUsuario = request.getParameter("idUsuario");
		if(strIdEmpresa.length()>0 && strIdEmpresa!=null && strPontuacao.length()>0 && strPontuacao!=null && strIdUsuario.length()>0 && strIdUsuario!=null ){
			int idEmpresa = Integer.parseInt(strIdEmpresa);
			int pontuacao = Integer.parseInt(strPontuacao);
			int idUsuario = Integer.parseInt(strIdUsuario);
			PontuacaoEmpresa pontuacaoEmpresa = new PontuacaoEmpresa(idEmpresa, idUsuario, pontuacao);
			PontuacaoEmpresaService pes = new PontuacaoEmpresaService();
			EmpresaService es = new EmpresaService();
			pes.cadastrarPontuacaoEmpresa(pontuacaoEmpresa);
			int novaPontuacao = pes.retornarMediaPontuacaoEmpresa(idEmpresa);
			es.alterarPontuacaoEmpresa(idEmpresa, novaPontuacao);			
			String status = "Pontuação cadastrada com sucesso!";
			request.setAttribute("status", status);
			System.out.println("quase chegando");
			//RequestDispatcher disp = request.getRequestDispatcher("BuscarEmpresaPeloIdController.do?idEmpresa="+strIdEmpresa+"&verificador=1");
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
			System.out.println("passou");
		}
	}

}
