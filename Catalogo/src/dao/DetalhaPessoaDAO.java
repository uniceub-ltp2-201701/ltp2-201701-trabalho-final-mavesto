package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Filme;
import model.Pessoa;

public class DetalhaPessoaDAO {
	
private Connection conexao;
	
	//metopdo construtor
	
	public DetalhaPessoaDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public Pessoa getPessoa(String idPessoa){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pessoa p = null;
		try {
			ps = conexao.prepareStatement("SELECT id_pessoa, nome, idade, biografia, url FROM pessoa where id_pessoa = ?");
			ps.setInt(1, Integer.parseInt(idPessoa));
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				p = new Pessoa(rs.getInt("id_pessoa"), rs.getString("nome"), rs.getInt("idade"), rs.getString("biografia"), rs.getString("url"));
				
			}
			ps.close();
			rs.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return p;
	}
	
	public ArrayList<Filme> getFilmesQueFoiDiretor(String idPessoa){
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		try {
			ps = conexao.prepareStatement("SELECT filme.id_filme, filme.nome, filme.sinopse, filme.classificacao, filme.avaliacao, filme.ano, filme.duracao, filme.data_lancamento "+ 
										  "FROM filme, pessoa_diretor where pessoa_diretor.id_pessoa = ? and pessoa_diretor.id_filme = filme.id_filme");
			ps.setInt(1, Integer.parseInt(idPessoa));
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				filmes.add(new Filme(rs.getInt("id_filme"), rs.getString("nome"), rs.getString("sinopse"), rs.getString("classificacao"), rs.getDouble("avaliacao"), 
						 rs.getInt("ano"), rs.getInt("duracao"), rs.getDate("data_lancamento")));
				
				
			}
			ps.close();
			rs.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return filmes;
	}
	
	public ArrayList<Filme> getFilmesQueFoiAtor(String idPessoa){
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		try {
			ps = conexao.prepareStatement("SELECT filme.id_filme, filme.nome, filme.sinopse, filme.classificacao, filme.avaliacao, filme.ano, filme.duracao, filme.data_lancamento "+ 
										  "FROM filme, pessoa_ator where pessoa_ator.id_pessoa = ? and pessoa_ator.id_filme = filme.id_filme");
			ps.setInt(1, Integer.parseInt(idPessoa));
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				filmes.add(new Filme(rs.getInt("id_filme"), rs.getString("nome"), rs.getString("sinopse"), rs.getString("classificacao"), rs.getDouble("avaliacao"), 
						 rs.getInt("ano"), rs.getInt("duracao"), rs.getDate("data_lancamento")));
				
				
			}
			ps.close();
			rs.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return filmes;
	}

}
