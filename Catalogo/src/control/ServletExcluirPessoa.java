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
import dao.ExcluirPessoaDAO;

/**
 * Servlet implementation class ServletExcluirPessoa
 */
@WebServlet("/excluirPessoa")
public class ServletExcluirPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirPessoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idpessoa = request.getParameter("idpessoa");
		
		Connection conexao = Conexao.getConexao();
		ExcluirPessoaDAO epd = new ExcluirPessoaDAO(conexao);
		
		boolean bbb = epd.excluirPessoaAtor(idpessoa);
		boolean bb = epd.excluirPessoaDiretor(idpessoa);
		boolean b = epd.excluirPessoa(idpessoa);
		
		if(b || bb || bbb ){
			RequestDispatcher rd = request.getRequestDispatcher("/administrador");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/respostaExcluirFilmeErro.jsp");
			rd.forward(request, response);
		}
		
		
		
		
	}

}
