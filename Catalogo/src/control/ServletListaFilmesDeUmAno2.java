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
import dao.ListaFilmesDeUmAnoDAO;
import model.Filme;

/**
 * Servlet implementation class ServletListaFilmesDeUmAno2
 */
@WebServlet("/listaFilmesDeUmAno2")
public class ServletListaFilmesDeUmAno2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaFilmesDeUmAno2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ano = request.getParameter("ano");

		Connection conexao = Conexao.getConexao();

		ListaFilmesDeUmAnoDAO lfduad = new ListaFilmesDeUmAnoDAO(conexao);
		ArrayList<Filme> Filmes = lfduad.getTodosOsFilmesDeUmAno(ano);


		request.setAttribute("Filmes", Filmes);
		request.setAttribute("ano", ano);
		RequestDispatcher rd = request.getRequestDispatcher("respostaListaFilmesDeUmAno2.jsp");
		rd.forward(request, response);
	}

}
