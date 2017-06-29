package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static Connection conexao = null;

	public static Connection getConexao(){

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conexao = DriverManager.getConnection("jdbc:mysql://localhost/filmes", "root", "");


		} 
		catch (Exception e) {
			e.printStackTrace();
		}



		return conexao;

	}

}
