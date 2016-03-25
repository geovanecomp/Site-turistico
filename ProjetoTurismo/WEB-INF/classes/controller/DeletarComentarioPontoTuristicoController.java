package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ComentarioPontoTuristicoService;
import entities.Usuario;

/**
 * Servlet implementation class DeletarComentarioPontoTuristicoController
 */
public class DeletarComentarioPontoTuristicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarComentarioPontoTuristicoController() {
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
		String strIdComentarioPontoTuristico = request.getParameter("idComentarioPontoTuristico");
		String strIdUsuario = request.getParameter("idUsuario");
		HttpSession sessao = request.getSession();
		Usuario usuarioSessao = (Usuario) sessao.getAttribute("usuarioSessao");
		if(strIdComentarioPontoTuristico.length()>0 && strIdUsuario.length()>0 && usuarioSessao!=null){
			int idComentarioPontoTuristico = Integer.parseInt(strIdComentarioPontoTuristico);
			int idUsuario = Integer.parseInt(strIdUsuario);
			if(idUsuario==usuarioSessao.getIdUsuario() || usuarioSessao.getAdministrador()==1){
				ComentarioPontoTuristicoService cpts = new ComentarioPontoTuristicoService();
				cpts.deletarComentarioPontoTuristicoPeloId(idComentarioPontoTuristico);
				String status = "Comentário deletado com sucesso!";
				request.setAttribute("status", status);
				RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
				disp.forward(request,response);	
			}
		}
		else{
			String status = "Erro";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
		}
	}

}
