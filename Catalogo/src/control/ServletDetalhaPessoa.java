package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.DetalhaPessoaDAO;
import model.Filme;
import model.Pessoa;

/**
 * Servlet implementation class ServletDetalhaPessoa
 */
@WebServlet("/detalhaPessoa")
public class ServletDetalhaPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalhaPessoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idPessoa = request.getParameter("idPessoa");
		
		Connection conexao = Conexao.getConexao();
		
		DetalhaPessoaDAO dpd = new DetalhaPessoaDAO(conexao);
		
		Pessoa p = dpd.getPessoa(idPessoa);
		
		ArrayList<Filme> filmesQueFoiAtor = dpd.getFilmesQueFoiAtor(idPessoa);
		ArrayList<Filme> filmeQueFoiDiretor = dpd.getFilmesQueFoiDiretor(idPessoa);
		
		request.setAttribute("pessoa", p);
		request.setAttribute("filmesQueFoiAtor", filmesQueFoiAtor);
		request.setAttribute("filmeQueFoiDiretor", filmeQueFoiDiretor);
		
		RequestDispatcher rd = request.getRequestDispatcher("respostaDetalhaPessoa.jsp");
		rd.forward(request, response);
		
	}

}
