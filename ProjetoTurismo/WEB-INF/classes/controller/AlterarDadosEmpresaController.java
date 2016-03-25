package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.EmpresaService;
import service.TelefoneEmpresaService;
import entities.Empresa;

/**
 * Servlet implementation class AlterarDadosEmpresaController
 */
public class AlterarDadosEmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarDadosEmpresaController() {
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
		//List<String> listaImagens = (List<String>) sessao.getAttribute("listaItens");
		List<String> listaTelefones = new ArrayList<String>();
		//List<String> listaTelefones = (List<String>)sessao.getAttribute("listaTelefones");
		listaTelefones.add(telefone);
		EmpresaService es = new EmpresaService();
		String status = "";
		if(strIdEmpresa.length()>0 && nome.length() > 0 && categoria.length() > 0 && descricao.length() > 0 && email.length() > 0 && estado.length() > 0 &&
				cidade.length() > 0 && distrito.length() > 0 && endereco.length() > 0 && cep.length() > 0 && horarioInicio.length() > 0 &&
				horarioFim.length() > 0 && diaInicio.length() > 0 && diaFim.length() > 0 && strGastoMedio.length() > 0 && cnpj.length() > 0 && telefone.length() > 0 && es.validarHora(horarioInicio, horarioFim)==true){
			if(es.validarCnpj(cnpj)==true){
				int pontuacao = 0;
				//int gastoMedio = Integer.parseInt(strGastoMedio);
				int idEmpresa = Integer.parseInt(strIdEmpresa);
				Empresa empresa = new Empresa(idEmpresa, nome, categoria, descricao, email, estado, cidade, distrito, endereco, cep, horarioInicio,
						 horarioFim, diaInicio, diaFim, pontuacao, strGastoMedio, cnpj);
				
				TelefoneEmpresaService tes = new TelefoneEmpresaService();
				//ImagemEmpresaService ies = new ImagemEmpresaService();
				es.alterarDadosEmpresa(empresa);
				tes.alterarTelefoneEmpresa(listaTelefones, idEmpresa);
				//ies.alterarImagemEmpresa(listaImagens, idEmpresa);
				status = "Atualização efetuada com sucesso!";
				//sessao.removeAttribute("listaItens");
				request.setAttribute("status", status);
				RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
				disp.forward(request,response);
			}
			else{
				status = "Cnpj inválido";
				request.setAttribute("status", status);
				RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
				disp.forward(request,response);
			}
			
			
		}
		else{
			status = "Por favor, preencha todos os campos corretamente";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");//Estou mandando para mensagem.jsp, pois estou com problemas com o campo "value" da jsp
			disp.forward(request,response);
		}
	}

}
