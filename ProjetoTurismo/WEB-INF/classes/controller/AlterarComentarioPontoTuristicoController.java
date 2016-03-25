package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ComentarioPontoTuristicoService;

/**
 * Servlet implementation class AlterarComentarioPontoTuristicoController
 */
public class AlterarComentarioPontoTuristicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarComentarioPontoTuristicoController() {
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
		String texto = request.getParameter("textoTextArea");
		System.out.println(texto);
		if(strIdComentarioPontoTuristico.length()>0){
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
			int idComentarioPontoTuristico = Integer.parseInt(strIdComentarioPontoTuristico);
			ComentarioPontoTuristicoService cpts = new ComentarioPontoTuristicoService();
			cpts.alterarComentarioPontoTuristico(texto, idComentarioPontoTuristico, strData);
			String status = "Coment�rio atualizado com sucesso!";
			request.setAttribute("status", status);
			RequestDispatcher disp = request.getRequestDispatcher("mensagem.jsp");
			disp.forward(request, response);
		}
	}

}
