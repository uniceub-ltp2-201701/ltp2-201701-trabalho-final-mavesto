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
import dao.ExcluirAtorDeUmFilmeDAO;

/**
 * Servlet implementation class ServletExcluirAtorDeUmFilme
 */
@WebServlet("/excluirAtorDeUmFilme")
public class ServletExcluirAtorDeUmFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirAtorDeUmFilme() {
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
		
		ExcluirAtorDeUmFilmeDAO eadufd = new ExcluirAtorDeUmFilmeDAO(conexao);
		
		boolean b = eadufd.excluirAtorDeUmFilme(idpessoa, idfilme);
		
		if(b){
			request.setAttribute("idfilme", idfilme);
			RequestDispatcher rd = request.getRequestDispatcher("/detalhaFilme");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/respostaExcluirAtorDeUmFilmeErro.jsp");
			rd.forward(request, response);
		}
		
	}

}
