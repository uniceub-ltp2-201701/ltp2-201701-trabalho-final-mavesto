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
import dao.ListaFilmesPorNotaDAO;
import model.Filme;

/**
 * Servlet implementation class ServletListaFilmesPorNota
 */
@WebServlet("/listaFilmesPorNota")
public class ServletListaFilmesPorNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaFilmesPorNota() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String avaliacao = request.getParameter("avaliacao");

		Connection conexao = Conexao.getConexao();

		ListaFilmesPorNotaDAO lfpnd = new ListaFilmesPorNotaDAO(conexao);
		ArrayList<Filme> Filmes = lfpnd.getTodosOsFilmesPorNota(avaliacao);


		request.setAttribute("Filmes", Filmes);
		request.setAttribute("avaliacao", avaliacao);
		RequestDispatcher rd = request.getRequestDispatcher("respostaListaFilmesPorNota.jsp");
		rd.forward(request, response);
	}
}


