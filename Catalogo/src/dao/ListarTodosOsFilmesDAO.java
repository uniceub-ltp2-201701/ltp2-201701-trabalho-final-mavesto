package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Filme;

public class ListarTodosOsFilmesDAO {
	
private Connection conexao;
	
	//metodo construtor
	
	public ListarTodosOsFilmesDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Filme> getTodosOsFilmes(String nomeDoFilme){
		ArrayList<Filme> Filmes =  new ArrayList<Filme>();
		try {
			
			 PreparedStatement ps = null;
			 ResultSet rs = null;
			 
			 ps = conexao.prepareStatement("SELECT id_filme, nome, sinopse, classificacao, avaliacao, ano, duracao, data_lancamento, url FROM filme WHERE nome LIKE ? order by data_lancamento desc ");
			 ps.setString(1, "%"+nomeDoFilme+"%");
			 rs = ps.executeQuery();
			 
			 while(rs.next()){
				 Filmes.add(new Filme(rs.getInt("id_filme"), rs.getString("nome"), rs.getString("sinopse"), rs.getString("classificacao"), rs.getDouble("avaliacao"), 
						 rs.getInt("ano"), rs.getInt("duracao"), rs.getDate("data_lancamento"), rs.getString("url")));
			 }
			 ps.close();
			 rs.close();
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Filmes;
	}

}
