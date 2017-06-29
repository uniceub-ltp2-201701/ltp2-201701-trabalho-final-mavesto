package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Filme;

public class ListaFilmesDeUmAnoDAO {
	private Connection conexao;

	public ListaFilmesDeUmAnoDAO(Connection conexao){

		this.conexao = conexao;
	}

	public ArrayList<Filme> getTodosOsFilmesDeUmAno(String ano){

		ArrayList<Filme> todosOsFilmesDeUmAno = new ArrayList<Filme>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conexao.prepareStatement("SELECT id_filme, nome, sinopse, classificacao, avaliacao, ano, duracao, data_lancamento, url FROM filme WHERE ano = ? order by data_lancamento desc");
			ps.setInt(1, Integer.parseInt(ano));
			
			rs = ps.executeQuery();

			while(rs.next()){
				todosOsFilmesDeUmAno.add(new Filme(rs.getInt("id_filme"), rs.getString("nome"), rs.getString("sinopse"), rs.getString("classificacao"), rs.getDouble("avaliacao"), 
						 rs.getInt("ano"), rs.getInt("duracao"), rs.getDate("data_lancamento"), rs.getString("url")));
			}
			ps.close();
			rs.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return todosOsFilmesDeUmAno;


	}
}
