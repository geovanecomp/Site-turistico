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
import service.ComentarioPontoTuristicoService;
import service.ImagemPontoTuristicoService;
import service.PontoTuristicoService;
import service.PontuacaoPontoTuristicoService;
import service.UsuarioService;
import entities.ComentarioPontoTuristico;
import entities.ImagemPontoTuristico;
import entities.PontoTuristico;
import entities.PontuacaoPontoTuristico;
import entities.Usuario;

/**
 * Servlet implementation class BuscarPontoTuristicoPeloIdController
 */
public class BuscarPontoTuristicoPeloIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPontoTuristicoPeloIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		String strIdPontoTuristico = request.getParameter("idPontoTuristico");
		String strVerificador = request.getParameter("verificador");//tem que passar um verificador qualquer, se for diferente de null vai para "informaçõesPontoTuristico.jsp"
	
		if(strIdPontoTuristico.length()>0){
			List<PontuacaoPontoTuristico> listaPontuacaoPontoTuristicoUsuario = new ArrayList<PontuacaoPontoTuristico>();
			Usuario usuarioSessao = (Usuario) sessao.getAttribute("usuarioSessao");
			int idPontoTuristico = Integer.parseInt(strIdPontoTuristico);
			PontoTuristicoService pts =  new PontoTuristicoService();
			PontoTuristico pontoTuristico = pts.buscarPontoTuristicoPeloId(idPontoTuristico);
			UsuarioService us = new UsuarioService();
			ComentarioPontoTuristicoService cpts = new ComentarioPontoTuristicoService();
			PontuacaoPontoTuristicoService ppts = new PontuacaoPontoTuristicoService();
			listaPontuacaoPontoTuristicoUsuario = ppts.buscarPontuacaoPontoTuristicoPeloIdPontoTuristicoUsuario(idPontoTuristico, usuarioSessao.getIdUsuario());
			request.setAttribute("listaPontuacaoPontoTuristicoUsuario", listaPontuacaoPontoTuristicoUsuario);
			ImagemPontoTuristicoService ipts = new ImagemPontoTuristicoService();
			List<String> listaImagens = new ArrayList<String>();
			List<ImagemPontoTuristico> listaImagensPontoTuristico = ipts.buscarImagensPeloIdPontoTuristico(idPontoTuristico);
			Iterator<ImagemPontoTuristico> elementosImagem = listaImagensPontoTuristico.iterator();
			while(elementosImagem.hasNext()){
				listaImagens.add(elementosImagem.next().getImagem());
			}
			
			List<ComentarioPontoTuristico> listaComentariosPontoTuristico = cpts.buscarTodosComentariosPontoTuristico(idPontoTuristico);
			List<Usuario> listaUsuariosEmpresa = new ArrayList<Usuario>();
			Iterator<ComentarioPontoTuristico> elementosComentariosPontoTuristico = listaComentariosPontoTuristico.iterator();
			while(elementosComentariosPontoTuristico.hasNext()){
				listaUsuariosEmpresa.add(us.buscarUsuarioPeloId(elementosComentariosPontoTuristico.next().getIdUsuario()));
			}
			request.setAttribute("listaUsuariosEmpresa",listaUsuariosEmpresa);
			request.setAttribute("listaComentariosPontoTuristico",listaComentariosPontoTuristico);
			request.setAttribute("listaImagens", listaImagens);
			request.setAttribute("pontoTuristico", pontoTuristico);
			
			if(usuarioSessao!=null){
				if(strVerificador!=null){
					RequestDispatcher disp = request.getRequestDispatcher("informacoesPontoTuristico.jsp");
					disp.forward(request,response);
				}
				else if (usuarioSessao.getAdministrador() == 1 ){
					RequestDispatcher disp = request.getRequestDispatcher("alterarDadosPontoTuristico.jsp");
					disp.forward(request,response);
					
				}
			}
			
		}
		else{
			request.setAttribute("status", "Erro.");
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
