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
import dao.ListarTodasAsPessoas2DAO;
import dao.ListarTodosOsFilmesDAO;
import model.Filme;
import model.Pessoa;

/**
 * Servlet implementation class ServletListaTodasAsPessoas
 */
@WebServlet("/listaTodasAsPessoas")
public class ServletListaTodasAsPessoas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaTodasAsPessoas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeDaPessoa = request.getParameter("nomeDaPessoa");
		

		try {

			Connection conexao = Conexao.getConexao();

			ListarTodasAsPessoas2DAO ltap2d = new ListarTodasAsPessoas2DAO(conexao);
			ArrayList<Pessoa> Pessoas = ltap2d.getTodosAsPessoas(nomeDaPessoa);

			request.setAttribute("Pessoas", Pessoas);
			request.setAttribute("nomeDaPessoa", nomeDaPessoa);
			RequestDispatcher rd = request.getRequestDispatcher("respostaListaTodasAsPessoas2.jsp");
			rd.forward(request, response);





		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
