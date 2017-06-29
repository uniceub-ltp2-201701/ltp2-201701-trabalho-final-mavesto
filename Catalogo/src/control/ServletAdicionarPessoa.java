package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionarPessoaDAO;
import dao.Conexao;

/**
 * Servlet implementation class ServletAdicionarPessoa
 */
@WebServlet("/adicionarPessoa")
public class ServletAdicionarPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdicionarPessoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
   // protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomedapessoa = request.getParameter("nomedapessoa");
		String idadedapessoa = request.getParameter("idadedapessoa");
		String biografiadapessoa = request.getParameter("biografiadapessoa");
		String urldapessoa = request.getParameter("urldapessoa");
		Connection conexao = Conexao.getConexao();
		
		AdicionarPessoaDAO apd = new AdicionarPessoaDAO(conexao);
		
		
		
		boolean b =  apd.adicionarPessoa(nomedapessoa, idadedapessoa, biografiadapessoa, urldapessoa);
		if(b){
			
			RequestDispatcher rd = request.getRequestDispatcher("/administrador");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/respostaAdicionarPessoaErro.jsp");
			rd.forward(request, response);
		}
		
	}

}
