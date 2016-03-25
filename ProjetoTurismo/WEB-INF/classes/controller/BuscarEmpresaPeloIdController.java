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
import javax.servlet.http.HttpSession;

import entities.ComentarioEmpresa;
import entities.Empresa;
import entities.ImagemEmpresa;
import entities.PontuacaoEmpresa;
import entities.TelefoneEmpresa;
import entities.Usuario;

import service.ComentarioEmpresaService;
import service.EmpresaService;
import service.ImagemEmpresaService;
import service.PontuacaoEmpresaService;
import service.TelefoneEmpresaService;
import service.UsuarioService;

/**
 * Servlet implementation class BuscarEmpresaPeloIdController
 */
public class BuscarEmpresaPeloIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarEmpresaPeloIdController() {
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
		//doGet(request,response);
		HttpSession sessao = request.getSession();
		String strIdEmpresa = request.getParameter("idEmpresa");
		String strVerificador = request.getParameter("verificador");//tem que passar um verificador qualquer, se for diferente de null vai para "informaçõesEmpresas.jsp"
	
		if(strIdEmpresa.length()>0){
			List<PontuacaoEmpresa> listaPontuacaoEmpresaUsuario = new ArrayList<PontuacaoEmpresa>();
			Usuario usuarioSessao = (Usuario) sessao.getAttribute("usuarioSessao");
			int idEmpresa = Integer.parseInt(strIdEmpresa);
			UsuarioService us = new UsuarioService();
			EmpresaService es =  new EmpresaService();
			Empresa empresa = es.buscarEmpresaPeloId(idEmpresa);
			TelefoneEmpresaService tes = new TelefoneEmpresaService();
			ImagemEmpresaService ies = new ImagemEmpresaService();
			ComentarioEmpresaService ces = new ComentarioEmpresaService();
			PontuacaoEmpresaService pes = new PontuacaoEmpresaService();
			listaPontuacaoEmpresaUsuario = pes.buscarPontuacaoEmpresaPeloIdEmpresaUsuario(idEmpresa, usuarioSessao.getIdUsuario());
			request.setAttribute("listaPontuacaoEmpresaUsuario", listaPontuacaoEmpresaUsuario);
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
			
			
			
			List<ComentarioEmpresa> listaComentariosEmpresa = ces.buscarTodosComentariosEmpresa(idEmpresa);
			List<Usuario> listaUsuariosEmpresa = new ArrayList<Usuario>();
			Iterator<ComentarioEmpresa> elementosComentariosEmpresa = listaComentariosEmpresa.iterator();
			while(elementosComentariosEmpresa.hasNext()){
				listaUsuariosEmpresa.add(us.buscarUsuarioPeloId(elementosComentariosEmpresa.next().getIdUsuario()));
			}
			request.setAttribute("listaUsuariosEmpresa",listaUsuariosEmpresa);
			request.setAttribute("listaComentariosEmpresa",listaComentariosEmpresa);
			request.setAttribute("listaImagens", listaImagens);
			request.setAttribute("listaTelefones", listaTelefones);
			request.setAttribute("empresa", empresa);
			if(usuarioSessao!=null){
				if(strVerificador!=null){
					RequestDispatcher disp = request.getRequestDispatcher("informacoesEmpresa.jsp");
					disp.forward(request,response);
				}
				else if (usuarioSessao.getAdministrador() == 1 ){
					RequestDispatcher disp = request.getRequestDispatcher("alterarDadosEmpresa.jsp");
					disp.forward(request,response);
					
				}
			}
			
		}
		else{
			request.setAttribute("status", "Erro.");
			RequestDispatcher disp = request.getRequestDispatcher("buscarEmpresaPeloCnpj.jsp");
			disp.forward(request,response);
		}
	}

}
