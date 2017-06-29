package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionarFilmeDAO;
import dao.Conexao;
import dao.ExcluirFilmeDAO;

/**
 * Servlet implementation class ServletExcluirFilme
 */
@WebServlet("/excluirFilme")
public class ServletExcluirFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_filme = request.getParameter("idfilme");
		Connection conexao = Conexao.getConexao();
		
		ExcluirFilmeDAO efd = new ExcluirFilmeDAO(conexao);
		
		boolean bbbb =   efd.excluirPessoaAtor(id_filme);
		
		boolean bbb =   efd.excluirPessoaDiretor(id_filme);
		
		boolean bb =   efd.excluirFilmeGenero(id_filme);
				
		boolean b =   efd.excluirFilme(id_filme);
		
		if(b || bb || bbb || bbbb){
			RequestDispatcher rd = request.getRequestDispatcher("/administrador");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/respostaExcluirPessoaErro.jsp");
			rd.forward(request, response);
		}
	}

}
