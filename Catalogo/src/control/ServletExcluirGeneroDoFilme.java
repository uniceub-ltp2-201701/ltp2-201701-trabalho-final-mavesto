package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.ExcluirGeneroDeUmFilmeDAO;

/**
 * Servlet implementation class ServletExcluirGeneroDoFilme
 */
@WebServlet("/excluirGeneroDoFilme")
public class ServletExcluirGeneroDoFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirGeneroDoFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
   // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idgenero = request.getParameter("idgenero");
		String idfilme = request.getParameter("idfilme");
		
		Connection conexao = Conexao.getConexao();
		
		ExcluirGeneroDeUmFilmeDAO egdufd = new ExcluirGeneroDeUmFilmeDAO(conexao);
		
		boolean b = egdufd.excluirGeneroDeUmFilme(idgenero, idfilme);
		
		if(b){
			request.setAttribute("idfilme", idfilme);
			RequestDispatcher rd = request.getRequestDispatcher("/detalhaFilme");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/respostaExcluirGeneroDeUmFilmeErro.jsp");
			rd.forward(request, response);
		}
	}

}
