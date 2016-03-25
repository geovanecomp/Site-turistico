package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EmpresaService;
import service.ImagemEmpresaService;
import service.TelefoneEmpresaService;

import entities.Empresa;

/**
 * Servlet implementation class CadastrarEmpresaController
 */
public class CadastrarEmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarEmpresaController() {
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
		String email = request.getParameter("email");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String distrito = request.getParameter("distrito");
		String endereco = request.getParameter("endereco");
		String cep = request.getParameter("cep");
		String horarioInicio = request.getParameter("horarioInicio");
		String horarioFim = request.getParameter("horarioFim");
		String diaInicio = request.getParameter("diaInicio");
		String diaFim = request.getParameter("diaFim");
		String strGastoMedio = request.getParameter("gastoMedio");
		String cnpj = request.getParameter("cnpj");
		String telefone = request.getParameter("telefone");
		List<String> listaImagens =  (List<String>) sessao.getAttribute("listaItens");		
		List<String> listaTelefones = new ArrayList<String>();
		//List<String> listaTelefones = (List<String>)sessao.getAttribute("listaTelefones");
		listaTelefones.add(telefone);
		String status = "";
		EmpresaService es = new EmpresaService();
		if(nome.length() > 0 && categoria.length() > 0 && descricao.length() > 0 && email.length() > 0 && estado.length() > 0 &&
				cidade.length() > 0 && distrito.length() > 0 && endereco.length() > 0 && cep.length() > 0 && horarioInicio.length() > 0 &&
				horarioFim.length() > 0 && diaInicio.length() > 0 && diaFim.length() > 0 && strGastoMedio.length() > 0 && cnpj.length() > 0 && telefone.length() > 0 && es.validarHora(horarioInicio, horarioFim)==true){
			
			if(es.validarCnpj(cnpj)==true && es.buscarEmpresaPeloCnpj(cnpj)==null){
				int pontuacao = 0;
				Empresa empresa = new Empresa(nome, categoria, descricao, email, estado, cidade, distrito, endereco, cep, horarioInicio,
						 horarioFim, diaInicio, diaFim, pontuacao, strGastoMedio, cnpj);
				
				TelefoneEmpresaService tes = new TelefoneEmpresaService();
				ImagemEmpresaService ies = new ImagemEmpresaService();
				es.cadastrarEmpresa(empresa);
				int idEmpresa = es.buscarUltimaEmpresa().getidEmpresa();
				tes.cadastrarTelefoneEmpresa(listaTelefones, idEmpresa);
				ies.cadastarImagemEmpresa(listaImagens, idEmpresa);
				status = "Cadastro efetuado com sucesso!";
				sessao.removeAttribute("listaItens");
				request.setAttribute("status", status);
				RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
				disp.forward(request,response);
			}
			else{
				String dadosEmpresa[] = new String[16];
				dadosEmpresa[0] = nome ;dadosEmpresa[1] = categoria; dadosEmpresa[2] = descricao; dadosEmpresa[3] = estado; dadosEmpresa[4] = cidade;
				dadosEmpresa[5] = distrito; dadosEmpresa[6] = endereco; dadosEmpresa[7] = cep; dadosEmpresa[8] = horarioInicio; dadosEmpresa[9] = horarioFim; dadosEmpresa[10] = diaInicio;
				dadosEmpresa[11] = diaFim; dadosEmpresa[12] = strGastoMedio; dadosEmpresa[13] = telefone; dadosEmpresa[14] = email ;dadosEmpresa[15] = cnpj;
				for(int i = 0 ; i < dadosEmpresa.length ; i++ ){
					if(dadosEmpresa[i] == null || dadosEmpresa[i].length()<1){
						dadosEmpresa[i] = "";
					}
				}
				request.setAttribute("arrayDadosEmpresa", dadosEmpresa);
				status = "Cnpj inválido";
				RequestDispatcher disp = request.getRequestDispatcher("cadastrarEmpresa.jsp");
				disp.forward(request,response);
			}
			
					
		}
		else{
			String dadosEmpresa[] = new String[17];
			dadosEmpresa[0] = nome ;dadosEmpresa[1] = categoria; dadosEmpresa[2] = descricao; dadosEmpresa[3] = estado; dadosEmpresa[4] = cidade;
			dadosEmpresa[5] = distrito; dadosEmpresa[6] = endereco; dadosEmpresa[7] = cep; dadosEmpresa[8] = horarioInicio; dadosEmpresa[9] = horarioFim; dadosEmpresa[10] = diaInicio;
			dadosEmpresa[11] = diaFim; dadosEmpresa[12] = strGastoMedio; dadosEmpresa[13] = telefone; dadosEmpresa[14] = email ;dadosEmpresa[15] = cnpj;
			for(int i = 0 ; i < dadosEmpresa.length ; i++ ){
				if(dadosEmpresa[i] == null || dadosEmpresa[i].length()<1){
					dadosEmpresa[i] = "";
				}
			}
			request.setAttribute("arrayDadosEmpresa", dadosEmpresa);
			status = "Por favor, preencha todos os dados corretamente";
			RequestDispatcher disp = request.getRequestDispatcher("cadastrarEmpresa.jsp");
			disp.forward(request,response);
		}
	}

}
