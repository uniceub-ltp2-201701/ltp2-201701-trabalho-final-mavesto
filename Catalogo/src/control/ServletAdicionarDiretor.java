package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionarDiretorExistenteDAO;
import dao.Conexao;

/**
 * Servlet implementation class ServletAdicionarDiretor
 */
@WebServlet("/adicionarDiretor")
public class ServletAdicionarDiretor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdicionarDiretor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idpessoa = request.getParameter("idpessoa");
		String idfilme = request.getParameter("idfilme");
		
		Connection conexao = Conexao.getConexao();
		
		AdicionarDiretorExistenteDAO aded = new AdicionarDiretorExistenteDAO(conexao);
		
		
		
		boolean b =  aded.adicionarDiretorExistente(idpessoa, idfilme);
		if(b){
			request.setAttribute("idfilme", idfilme);
			RequestDispatcher rd = request.getRequestDispatcher("/detalhaFilme");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/respostaAtorErro.jsp");
			rd.forward(request, response);
		}
	}

}
