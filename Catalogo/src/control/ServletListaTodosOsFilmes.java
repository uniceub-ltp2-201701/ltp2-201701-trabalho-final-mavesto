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
 * Servlet implementation class ServletListaTodosOsFilmes
 */
@WebServlet("/listaTodosOsFilmes")
public class ServletListaTodosOsFilmes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListaTodosOsFilmes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nomeDoFilme = request.getParameter("nomeDoFilme");
			

		try {

			Connection conexao = Conexao.getConexao();

			ListarTodosOsFilmesDAO ltofd = new ListarTodosOsFilmesDAO(conexao);
			ArrayList<Filme> Filmes = ltofd.getTodosOsFilmes(nomeDoFilme);

			request.setAttribute("Filmes", Filmes);
			request.setAttribute("nomeDoFilme", nomeDoFilme);
			RequestDispatcher rd = request.getRequestDispatcher("respostaListaTodosOsFilmes.jsp");
			rd.forward(request, response);





		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
