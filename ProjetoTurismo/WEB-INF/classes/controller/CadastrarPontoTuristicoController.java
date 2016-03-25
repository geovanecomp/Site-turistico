package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ImagemPontoTuristicoService;
import service.PontoTuristicoService;

import entities.PontoTuristico;

/**
 * Servlet implementation class CadastrarPontoTuristicoController
 */
public class CadastrarPontoTuristicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarPontoTuristicoController() {
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
		HttpSession sessao = request.getSession();
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
		List<String> listaImagens = (List<String>) sessao.getAttribute("listaItens");
		String status = "";
		PontoTuristicoService pts = new PontoTuristicoService();
		if(nome.length() > 0 && categoria.length() > 0 && descricao.length() > 0 && estado.length() > 0 &&
				cidade.length() > 0 && distrito.length() > 0 && endereco.length() > 0 && cep.length() > 0 && horarioInicio.length() > 0 &&
				horarioFim.length() > 0 && diaInicio.length() > 0 && diaFim.length()>0 && taxaCobrada.length()>0 && pts.validarHora(horarioInicio, horarioFim)==true){
			int pontuacao = 0;
			PontoTuristico pontoTuristico = new PontoTuristico(nome, categoria, descricao, estado, cidade, distrito, endereco, cep, horarioInicio, horarioFim, diaInicio, diaFim, pontuacao, taxaCobrada);
			ImagemPontoTuristicoService ipts = new ImagemPontoTuristicoService();
			pts.cadastrarPontoTuristico(pontoTuristico);
			int idPontoTuristico = pts.buscarUltimoPontoTuristico().getIdPontoTuristico();
			ipts.cadastarImagemPontoTuristicoDAO(listaImagens, idPontoTuristico);
			
			status = "Cadastro efetuado com sucesso!";
			sessao.removeAttribute("listaItens");
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
				
		}
		else{
			String dadosPontoTuristico[] = new String[13];
			dadosPontoTuristico[0] = nome ;dadosPontoTuristico[1] = categoria; dadosPontoTuristico[2] = descricao; dadosPontoTuristico[3] = estado; dadosPontoTuristico[4] = cidade;
			dadosPontoTuristico[5] = distrito; dadosPontoTuristico[6] = endereco; dadosPontoTuristico[7] = cep; dadosPontoTuristico[8] = horarioInicio; dadosPontoTuristico[9] = horarioFim; dadosPontoTuristico[10] = diaInicio;
			dadosPontoTuristico[11] = diaFim; dadosPontoTuristico[12] = taxaCobrada;
			for(int i = 0 ; i < dadosPontoTuristico.length ; i++ ){
				if(dadosPontoTuristico[i] == null || dadosPontoTuristico[i].length()<1){
					dadosPontoTuristico[i] = "";
				}
			}
			request.setAttribute("arraydadosPontoTuristico", dadosPontoTuristico);
			status = "Por favor, preencha todos os dados corretamente";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("cadastrarPontoTuristico.jsp");
			disp.forward(request,response);
	
		}
	}
}
