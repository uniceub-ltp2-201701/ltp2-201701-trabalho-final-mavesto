package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionarGeneroFilmeDAO;
import dao.Conexao;


@WebServlet("/adicionarGeneroFilme")
public class ServletAdicionarGeneroFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletAdicionarGeneroFilme() {
        super();
       
    }

   // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_filme = request.getParameter("idfilme");
		String id_genero = request.getParameter("idgenero");
		
		Connection conexao = Conexao.getConexao();
		
		AdicionarGeneroFilmeDAO agfd = new AdicionarGeneroFilmeDAO(conexao);
		
		boolean b = agfd.adicionarGeneroFilme(id_genero, id_filme); 
		
		
		if(b){
			request.setAttribute("idfilme", id_filme);
			RequestDispatcher rd = request.getRequestDispatcher("/detalhaFilme");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/respostaAdicionarGeneroFilmeErro.jsp");
			rd.forward(request, response);
		}
		
	}

}
