package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExcluirDiretorDeUmFilmeDAO {
	
	private Connection conexao;

	//metodo construtor

	public ExcluirDiretorDeUmFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}

	//excluir pessoa/diretor
	public boolean excluirDiretorDeUmFilme( String id_Pessoa,String id_Filme){
		PreparedStatement ps = null;

		boolean resultadoFinal = false;
		try {
			ps = conexao.prepareStatement("delete from pessoa_diretor where pessoa_diretor.id_pessoa = ? and pessoa_diretor.id_filme = ?");
			ps.setInt(1, Integer.parseInt(id_Pessoa));
			ps.setInt(2, Integer.parseInt(id_Filme));
			

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
