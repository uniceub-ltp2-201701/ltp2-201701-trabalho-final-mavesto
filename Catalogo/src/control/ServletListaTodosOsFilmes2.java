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
import dao.ListarTodosOsFilmesDAO;
import model.Filme;

/**
 * Servlet implementation class ServletListaTodosOsFilmes2
 */
@WebServlet("/listaTodosOsFilmes2")
public class ServletListaTodosOsFilmes2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListaTodosOsFilmes2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nomeDoFilme = request.getParameter("nomeDoFilme");


		try {

			Connection conexao = Conexao.getConexao();

			ListarTodosOsFilmesDAO ltofd = new ListarTodosOsFilmesDAO(conexao);
			ArrayList<Filme> Filmes = ltofd.getTodosOsFilmes(nomeDoFilme);

			request.setAttribute("Filmes", Filmes);
			request.setAttribute("nomeDoFilme", nomeDoFilme);
			RequestDispatcher rd = request.getRequestDispatcher("respostaListaTodosOsFilmes2.jsp");
			rd.forward(request, response);





		} catch (Exception e) {
			e.printStackTrace();
		}


	}


}


