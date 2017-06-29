package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionarGeneroFilmeDAO {
	private Connection conexao;
	
	public AdicionarGeneroFilmeDAO(Connection conexao){
		this.conexao = conexao;
	
	}
	
	public boolean adicionarGeneroFilme(String id_genero, String id_filme){
PreparedStatement ps = null;
		
		boolean resultadoFinal = false;
		try {
			ps = conexao.prepareStatement("insert into genero_filme(id_genero, id_filme) values (?,?)");
			
			ps.setInt(1, Integer.parseInt(id_genero));
			ps.setInt(2, Integer.parseInt(id_filme));
			
			
			
			int resultadoUpdate = ps.executeUpdate();
			if(resultadoUpdate == 1){
				resultadoFinal = true;
			}
			else{
				resultadoFinal = false;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return resultadoFinal;
	}
	

}
