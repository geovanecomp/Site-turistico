package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entities.Circuito;
import entities.Usuario;

import service.CircuitoService;

/**
 * Servlet implementation class BuscarTodosCircuitosController
 */
public class BuscarTodosCircuitosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarTodosCircuitosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioSessao");
		CircuitoService cs = new CircuitoService();
		List<Circuito> listaCircuitos = cs.buscarCircuitosPeloIdUsuario(usuario.getIdUsuario());
		request.setAttribute("listaCircuitos", listaCircuitos);
		RequestDispatcher disp = request.getRequestDispatcher("exibirCircuitos.jsp");
		disp.forward(request,response);
	}

}
