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
import dao.DetalhaGeneroDAO;
import dao.ListaFilmesDoGeneroDAO;
import model.Filme;
import model.Genero;

/**
 * Servlet implementation class ServletListaFilmesDoGenero
 */
@WebServlet("/listaFilmesDoGenero")
public class ServletListaFilmesDoGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaFilmesDoGenero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idgenero = request.getParameter("idgenero");
		
		Connection conexao = Conexao.getConexao();
		
		ListaFilmesDoGeneroDAO lfdgd = new ListaFilmesDoGeneroDAO(conexao);
		ArrayList<Filme> filmesDoGenero = lfdgd.getTodosOsFilmesDoGenero(idgenero);
		
		DetalhaGeneroDAO dgd = new DetalhaGeneroDAO(conexao);
		Genero g = dgd.getGenero(idgenero);
		
		request.setAttribute("filmesDoGenero", filmesDoGenero);
		request.setAttribute("genero", g);
		
		RequestDispatcher rd = request.getRequestDispatcher("respostaListaFilmesDoGenero.jsp");
		rd.forward(request, response);
		
	}

}
