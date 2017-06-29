package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExcluirGeneroDeUmFilmeDAO {
	private Connection conexao;
	
	public ExcluirGeneroDeUmFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}

	//excluir pessoa/diretor
	public boolean excluirGeneroDeUmFilme( String id_Genero,String id_Filme){
		PreparedStatement ps = null;

		boolean resultadoFinal = false;
		try {
			ps = conexao.prepareStatement("delete from genero_filme where genero_filme.id_genero = ? and genero_filme.id_filme = ?");
			ps.setInt(1, Integer.parseInt(id_Genero));
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
