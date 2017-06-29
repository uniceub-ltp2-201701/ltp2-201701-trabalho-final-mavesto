package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExcluirPessoaDAO {
	
private Connection conexao;
	
	//metodo construtor
	
	public ExcluirPessoaDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	//excluir pessoa/diretor
			public boolean excluirPessoaDiretor(String id_pessoa){
				PreparedStatement ps = null;
				
				boolean resultadoFinal = false;
				try {
					ps = conexao.prepareStatement("delete from pessoa_diretor where pessoa_diretor.id_pessoa = ?");
					ps.setInt(1, Integer.parseInt(id_pessoa));
				
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
		public boolean excluirPessoaAtor(String id_pessoa){
			PreparedStatement ps = null;
			
			boolean resultadoFinal = false;
			try {
				ps = conexao.prepareStatement("delete from pessoa_ator where pessoa_ator.id_pessoa = ?");
				ps.setInt(1, Integer.parseInt(id_pessoa));
			
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
	
	//excluir pessoa
	public boolean excluirPessoa(String id_pessoa){
		PreparedStatement ps = null;
		
		boolean resultadoFinal = false;
		try {
			ps = conexao.prepareStatement("delete from pessoa where id_pessoa = ?");
			ps.setInt(1, Integer.parseInt(id_pessoa));
		
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
