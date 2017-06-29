package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionarFilmeDAO {
	
	private Connection conexao;
	
	//metodo construtor
	
	public AdicionarFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean adicionarFilme(String nome, String sinopse,  String classificacao, String avaliacao, String ano, String duracao, String data_lancamento, String url){
		PreparedStatement ps = null;
		
		boolean resultadoFinal = false;
		try {
			ps = conexao.prepareStatement("insert into filme( nome,  sinopse,  classificacao,  avaliacao,  ano, duracao,  data_lancamento, url) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, nome);
			ps.setString(2, sinopse);
			ps.setString(3, classificacao);
			ps.setDouble(4, Double.parseDouble(avaliacao));
			ps.setInt(5, Integer.parseInt(ano));
			ps.setInt(6, Integer.parseInt(duracao));
			ps.setString(7, data_lancamento);
			ps.setString(8, url);
			
			
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
