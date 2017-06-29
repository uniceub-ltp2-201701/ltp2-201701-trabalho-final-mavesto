package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Filme;
import model.Genero;

public class DetalhaFilmeDAO {
	
	private Connection conexao;
	
	//metopdo construtor
	
	public DetalhaFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public Filme getFilme(String idfilme){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Filme f = null;
		try {
			ps = conexao.prepareStatement("SELECT id_filme, nome, sinopse, classificacao, avaliacao, ano, duracao, data_lancamento, url FROM filme WHERE id_filme = ?");
			ps.setInt(1, Integer.parseInt(idfilme));
			rs = ps.executeQuery();
			while(rs.next()){
				f = new Filme(rs.getInt("id_filme"), rs.getString("nome"), rs.getString("sinopse"), rs.getString("classificacao"), rs.getDouble("avaliacao"), 
						 rs.getInt("ano"), rs.getInt("duracao"), rs.getDate("data_lancamento"), rs.getString("url"));
				
			}
			ps.close();
			rs.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}
	
	public ArrayList<Genero> genero(String idfilme){
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Genero> generos = new ArrayList<Genero>();
		
		try {
			ps = conexao.prepareStatement("SELECT genero.id_genero, genero.nome from genero, genero_filme, filme where genero_filme.id_filme = ? and genero_filme.id_genero = genero.id_genero and genero_filme.id_filme = filme.id_filme ORDER BY nome");
			ps.setInt(1, Integer.parseInt(idfilme));
			rs = ps.executeQuery();
			while(rs.next()){
				generos.add(new Genero(rs.getInt("id_genero"), rs.getString("nome")));
				
			}
			ps.close();
			rs.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return generos;
	}
	

}

