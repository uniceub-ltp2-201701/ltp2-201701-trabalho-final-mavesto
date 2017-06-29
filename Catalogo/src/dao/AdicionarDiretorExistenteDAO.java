package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionarDiretorExistenteDAO {

	 private Connection conexao;
	 
	 public AdicionarDiretorExistenteDAO( Connection conexao){
		 this.conexao = conexao;
	 }
	 
	 public boolean adicionarDiretorExistente( String idpessoa,String idfilme ){
		 
		 PreparedStatement ps = null;
			
			boolean resultadoFinal = false;
			try {
				ps = conexao.prepareStatement("insert into pessoa_diretor( id_pessoa, id_filme) values(?,?)");
				
				ps.setInt(1, Integer.parseInt(idpessoa));
				ps.setInt(2, Integer.parseInt(idfilme));
			
				
				
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
