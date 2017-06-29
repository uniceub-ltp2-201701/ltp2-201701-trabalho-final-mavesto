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
import dao.ListaTodosOsGenerosDAO;
import dao.ListarFilmesDAO;
import dao.ListarTodasAsPessoasDAO;
import model.Filme;
import model.Genero;
import model.Pessoa;

/**
 * Servlet implementation class ServletInicio
 */
@WebServlet("/inicio")
public class ServletInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		ListarFilmesDAO lfd = new ListarFilmesDAO(conexao);
		ArrayList<Filme> Filmes = lfd.getTodosOsFilmes();
		
		ListarTodasAsPessoasDAO ltapd = new ListarTodasAsPessoasDAO(conexao);
		ArrayList<Pessoa> todasAsPessoas = ltapd.getTodosAsPessoas();
		
		ListaTodosOsGenerosDAO ltogd = new ListaTodosOsGenerosDAO(conexao);
		ArrayList<Genero> generos = ltogd.getTodosOsGeneros();
		
		request.setAttribute("Filmes", Filmes);
		request.setAttribute("todasAsPessoas", todasAsPessoas);
		request.setAttribute("generos", generos);
		RequestDispatcher rd = request.getRequestDispatcher("respostaInicio.jsp");
		rd.forward(request, response);
	}

}
