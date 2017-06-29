package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionarPessoaDAO {
	
	private Connection conexao;
	 
	 public AdicionarPessoaDAO( Connection conexao){
		 this.conexao = conexao;
	 }
	 
	 public boolean adicionarPessoa( String nome, String idade, String biografia, String urldapessoa){
		 
		 PreparedStatement ps = null;
			
			boolean resultadoFinal = false;
			try {
				ps = conexao.prepareStatement("insert into pessoa( nome, idade, biografia, url) values(?,?,?,?)");
				
				ps.setString(1, nome);
				ps.setInt(2, Integer.parseInt(idade));
				ps.setString(3, biografia);
				ps.setString(4, urldapessoa);
				
				
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
