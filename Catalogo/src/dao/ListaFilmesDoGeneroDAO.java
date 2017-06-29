package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Filme;
import model.Pessoa;

public class ListaFilmesDoGeneroDAO {
	
	private Connection conexao;

	public ListaFilmesDoGeneroDAO(Connection conexao){

		this.conexao = conexao;
	}

	public ArrayList<Filme> getTodosOsFilmesDoGenero(String id_genero){

		ArrayList<Filme> todosOsFilmesDoGenero = new ArrayList<Filme>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conexao.prepareStatement("SELECT filme.id_filme, filme.nome, filme.sinopse, filme.classificacao, filme.avaliacao, filme.ano, filme.duracao, filme.data_lancamento, filme.url FROM filme, genero_filme "+
										  "where genero_filme.id_genero = ? and genero_filme.id_filme = filme.id_filme order by data_lancamento desc");
			ps.setInt(1, Integer.parseInt(id_genero));
			
			rs = ps.executeQuery();

			while(rs.next()){
				todosOsFilmesDoGenero.add(new Filme(rs.getInt("id_filme"), rs.getString("nome"), rs.getString("sinopse"), rs.getString("classificacao"), rs.getDouble("avaliacao"), 
						 rs.getInt("ano"), rs.getInt("duracao"), rs.getDate("data_lancamento"), rs.getString("url")));
			}
			ps.close();
			rs.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return todosOsFilmesDoGenero;


	}

}
