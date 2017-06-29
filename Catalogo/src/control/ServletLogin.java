package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.Login;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeusuario = request.getParameter("nomeusuario");
		String senhausuario = request.getParameter("senhausuario");
		
		try {
			Connection conexao = Conexao.getConexao();
			Login l = new Login(conexao);
			
			boolean b = l.teste(nomeusuario, senhausuario);
			
			if(b){
				RequestDispatcher rd = request.getRequestDispatcher("/administrador");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/erroNoLogin.jsp");
				rd.forward(request, response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
