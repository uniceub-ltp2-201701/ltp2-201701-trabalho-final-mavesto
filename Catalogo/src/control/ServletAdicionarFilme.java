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

/**
 * Servlet implementation class ServletAdicionarFilme
 */
@WebServlet("/adicionarFilme")
public class ServletAdicionarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAdicionarFilme() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomedofilme = request.getParameter("nomedofilme");
		String sinopsedofilme = request.getParameter("sinopsedofilme");
		String classificacaodofilme = request.getParameter("classificacaodofilme");
		String avaliacaodofilme = request.getParameter("avaliacaodofilme");
		String anodofilme = request.getParameter("anodofilme");
		String duracaodofilme = request.getParameter("duracaodofilme");
		String datadofilme = request.getParameter("datadofilme");
		String urldofilme = request.getParameter("urldofilme");

		Connection conexao = Conexao.getConexao();
		AdicionarFilmeDAO afd = new AdicionarFilmeDAO(conexao);
		boolean b =   afd.adicionarFilme(nomedofilme, sinopsedofilme, classificacaodofilme, avaliacaodofilme, anodofilme, duracaodofilme, datadofilme, urldofilme);
		if(b){
			RequestDispatcher rd = request.getRequestDispatcher("/administrador");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/respostaAdicionarFilmeErro.jsp");
			rd.forward(request, response);
		}


	}

}
