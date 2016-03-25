package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.ComentarioEmpresa;

import service.ComentarioEmpresaService;


/**
 * Servlet implementation class CadastrarComentarioEmpresa
 */
public class CadastrarComentarioEmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarComentarioEmpresaController() {
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
		String strIdUsuario = request.getParameter("idUsuario");
		String texto = request.getParameter("texto");
		String strIdEmpresa = request.getParameter("idEmpresa");
		if(strIdUsuario.length()>0 && strIdEmpresa.length()>0 && texto.length()>0){
			int idUsuario = Integer.parseInt(strIdUsuario);
			int idEmpresa = Integer.parseInt(strIdEmpresa);
			Date data = new Date(System.currentTimeMillis());
			String strData = data+"";
			String strDia = "";
			String strMes = "";
			String strAno = "";
			for(int i = 0; i<10 ; i++){
				if(i<=3){
					strAno = strAno+strData.charAt(i);
				}
				else if(i>=5 && i<=6){
					strMes = strMes+strData.charAt(i);
				}
				else if(i>=8){
					strDia = strDia+strData.charAt(i);
				}
			}
			strData = strDia+"/"+strMes+"/"+strAno;
			ComentarioEmpresaService ces = new ComentarioEmpresaService();
			ComentarioEmpresa comentarioEmpresa =  new ComentarioEmpresa(strData, texto, idUsuario, idEmpresa);
			ces.cadastrarComentarioEmpresa(comentarioEmpresa);
			String status = "Comentário realizado com sucesso!";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request, response);
			
		}
		else{
			/*RequestDispatcher disp = request.getRequestDispatcher("PerguntaExibirController.do?id="+idPergunta);
			disp.forward(request, response);*/
			request.setAttribute("status", "Favor preencha todos os campos corretamente");
			RequestDispatcher disp = request.getRequestDispatcher("BuscarEmpresaPeloIdController.do?id="+strIdEmpresa);			
			//RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request,response);
		}
	}
	

}
