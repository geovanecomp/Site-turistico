package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Empresa;
import entities.ImagemEmpresa;
import entities.TelefoneEmpresa;

import service.EmpresaService;
import service.ImagemEmpresaService;
import service.TelefoneEmpresaService;

/**
 * Servlet implementation class BuscarEmpresaPeloCnpj
 */
public class BuscarEmpresaPeloCnpj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarEmpresaPeloCnpj() {
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
		String cnpj = request.getParameter("cnpj");
		if(cnpj.length()>0 && cnpj!=null){
			EmpresaService es =  new EmpresaService();
			Empresa empresa =  es.buscarEmpresaPeloCnpj(cnpj);
			TelefoneEmpresaService tes = new TelefoneEmpresaService();
			ImagemEmpresaService ies = new ImagemEmpresaService();
			int idEmpresa = empresa.getidEmpresa();
			
			List<TelefoneEmpresa> listaTelefonesEmpresa = tes.buscarTelefonesPeloIdEmpresa(idEmpresa); //armazena objetos telefones
			List<String> listaTelefones = new ArrayList<String>(); //armazena strings de telefones
			Iterator<TelefoneEmpresa> elementosTelefone = listaTelefonesEmpresa.iterator();
			while(elementosTelefone.hasNext()){
				listaTelefones.add(elementosTelefone.next().getTelefone());
			}
						
			List<String> listaImagens = new ArrayList<String>();
			List<ImagemEmpresa> listaImagensEmpresa = ies.buscarImagensPeloIdEmpresa(idEmpresa);
			Iterator<ImagemEmpresa> elementosImagem = listaImagensEmpresa.iterator();
			while(elementosImagem.hasNext()){
				listaImagens.add(elementosImagem.next().getImagem());
			}
			
			request.setAttribute("listaImagens", listaImagens);
			request.setAttribute("listaTelefones", listaTelefones);
			request.setAttribute("empresa", empresa);
			RequestDispatcher disp = request.getRequestDispatcher("informacoesEmpresa.jsp");
			disp.forward(request,response);
		}
		else{
			request.setAttribute("status", "Favor preencha todos os campos corretamente.");
			RequestDispatcher disp = request.getRequestDispatcher("buscarEmpresaPeloCnpj.jsp");
			disp.forward(request,response);
		}
		
	}

}
