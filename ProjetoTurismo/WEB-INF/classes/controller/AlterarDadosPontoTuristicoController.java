package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.PontoTuristicoService;
import entities.PontoTuristico;

/**
 * Servlet implementation class AlterarDadosPontoTuristicoController
 */
public class AlterarDadosPontoTuristicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarDadosPontoTuristicoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strIdPontoTuristico = request.getParameter("idPontoTuristico");
		String nome = request.getParameter("nome");
		String categoria = request.getParameter("categoria");
		String descricao = request.getParameter("descricao");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String distrito = request.getParameter("distrito");
		String endereco = request.getParameter("endereco");
		String cep = request.getParameter("cep");
		String horarioInicio = request.getParameter("horarioInicio");
		String horarioFim = request.getParameter("horarioFim");
		String diaInicio = request.getParameter("diaInicio");
		String diaFim = request.getParameter("diaFim");
		String taxaCobrada = request.getParameter("taxaCobrada");
		//List<String> listaImagens = (List<String>) sessao.getAttribute("listaItens");
		PontoTuristicoService pts = new PontoTuristicoService();
		String status = "";
		if(nome.length() > 0 && categoria.length() > 0 && descricao.length() > 0 && estado.length() > 0 &&
				cidade.length() > 0 && distrito.length() > 0 && endereco.length() > 0 && cep.length() > 0 && horarioInicio.length() > 0 &&
				horarioFim.length() > 0 && diaInicio.length() > 0 && diaFim.length()>0 && taxaCobrada.length()>0 && pts.validarHora(horarioInicio, horarioFim)==true){
			int pontuacao = 0;
			int idPontoTuristico = Integer.parseInt(strIdPontoTuristico);
			PontoTuristico pontoTuristico = new PontoTuristico(idPontoTuristico, nome, categoria, descricao, estado, cidade, distrito, endereco, cep, horarioInicio, horarioFim, diaInicio, diaFim, pontuacao, taxaCobrada);
			//ImagemEmpresaService ies = new ImagemEmpresaService();
			pts.alterarDadosPontoTuristico(pontoTuristico);
			//ies.alterarImagemEmpresa(listaImagens, idEmpresa);
			status = "Atualização efetuada com sucesso!";
			//sessao.removeAttribute("listaItens");
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
			
		}
		else{
			status = "Por favor, preencha todos os dados corretamente";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");//Estou mandando para mensagem.jsp, pois estou com problemas com o campo "value" da jsp
			disp.forward(request,response);	
		}
		
		
	}
		
		

}
