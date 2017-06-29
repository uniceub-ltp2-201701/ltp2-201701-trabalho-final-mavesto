package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Login {
	
	private Connection conexao;
	
	//metodo construtor
	public Login(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean teste(String nome, String senha) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean resultado = false;
			
			ps = conexao.prepareStatement("SELECT usuario.nome, usuario.senha FROM filmes.usuario WHERE nome = ? and senha = ?");
			
			ps.setString(1, nome);
			ps.setString(2, senha);
			
			rs = ps.executeQuery();
			
			
			if(rs.first()){
				resultado =  true;
			}
			else{
				resultado =  false;
			}
	
		
			return resultado;
		
		
				
	}

}
