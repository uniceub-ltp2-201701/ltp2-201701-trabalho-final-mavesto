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
import dao.DetalhaFilmeDAO;
import dao.ListaAtoresDeUmFilmeDAO;
import dao.ListaDiretorDeUmFilmeDAO;
import dao.ListaTodosOsDiretoresDAO;
import dao.ListarTodosOsAtoresDAO;
import dao.ListaGenerosQueNaoEstaoNoFilmeDAO;
import model.Filme;
import model.Genero;
import model.Pessoa;

/**
 * Servlet implementation class ServletDetalhaFilme
 */
@WebServlet("/detalhaFilme")
public class ServletDetalhaFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDetalhaFilme() {
		super();

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id_filme = request.getParameter("idfilme");


		Connection conexao = Conexao.getConexao();
		DetalhaFilmeDAO dfd = new DetalhaFilmeDAO(conexao);
		Filme f = dfd.getFilme(id_filme);
		ArrayList<Genero> generosDoFilme = dfd.genero(id_filme);
		
		ListaGenerosQueNaoEstaoNoFilmeDAO togd = new ListaGenerosQueNaoEstaoNoFilmeDAO(conexao);
		ArrayList<Genero> todosOsGeneros = togd.getTodosOsGeneros(id_filme);
		
		ListarTodosOsAtoresDAO ltoad = new ListarTodosOsAtoresDAO(conexao);
		ArrayList<Pessoa> pessoas = ltoad.getTodosOsAtores(id_filme);
		
		ListaAtoresDeUmFilmeDAO ladufd = new ListaAtoresDeUmFilmeDAO(conexao);
		
		ArrayList<Pessoa> atores = ladufd.getTodosOsAtoresDeUmFilme(id_filme);
		
		ListaDiretorDeUmFilmeDAO lddufd = new ListaDiretorDeUmFilmeDAO(conexao);
		
		ArrayList<Pessoa> diretoresDeUmFilme = lddufd.getTodosOsDiretoresDeUmFilme(id_filme);
		
		ListaTodosOsDiretoresDAO ltodd = new ListaTodosOsDiretoresDAO(conexao);
		
		ArrayList<Pessoa> diretoresExistentes = ltodd.getTodosOsDiretores(id_filme);
		
		

		request.setAttribute("Filme", f);
		request.setAttribute("generosDoFilme", generosDoFilme);
		request.setAttribute("todosOsGeneros", todosOsGeneros);
		request.setAttribute("todasAsProfissoes", pessoas);
		request.setAttribute("todosOsAtoresDeUmFilme", atores);
		request.setAttribute("todosOsDiretoresDeUmFilme", diretoresDeUmFilme);
		request.setAttribute("diretoresExistentes", diretoresExistentes);
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalhaFilme.jsp");
		rd.forward(request, response);


	}
}
