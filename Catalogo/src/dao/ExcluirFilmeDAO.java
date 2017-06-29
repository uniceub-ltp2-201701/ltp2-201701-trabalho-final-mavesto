package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExcluirFilmeDAO {
private Connection conexao;
	
	//metodo construtor
	
	public ExcluirFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	//excluir pessoa/diretor
			public boolean excluirPessoaDiretor(String id_filme){
				PreparedStatement ps = null;
				
				boolean resultadoFinal = false;
				try {
					ps = conexao.prepareStatement("delete from pessoa_diretor where pessoa_diretor.id_filme = ?");
					ps.setInt(1, Integer.parseInt(id_filme));
				
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
	
	//excluir pessoa/ator
		public boolean excluirPessoaAtor(String id_filme){
			PreparedStatement ps = null;
			
			boolean resultadoFinal = false;
			try {
				ps = conexao.prepareStatement("delete from pessoa_ator where pessoa_ator.id_filme = ?");
				ps.setInt(1, Integer.parseInt(id_filme));
			
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
	
	//excluir filme/genero
	public boolean excluirFilmeGenero(String id_filme){
		PreparedStatement ps = null;
		
		boolean resultadoFinal = false;
		try {
			ps = conexao.prepareStatement("delete from genero_filme where genero_filme.id_filme = ?");
			ps.setInt(1, Integer.parseInt(id_filme));
		
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

	
	public boolean excluirFilme(String id_filme){
		PreparedStatement ps = null;
		
		boolean resultadoFinal = false;
		try {
			ps = conexao.prepareStatement("delete from filme where id_filme = ?");
			ps.setInt(1, Integer.parseInt(id_filme));
		
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
