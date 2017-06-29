package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Filme;

public class ListaFilmesPorNotaDAO {

	private Connection conexao;

	public ListaFilmesPorNotaDAO(Connection conexao){

		this.conexao = conexao;
	}

	public ArrayList<Filme> getTodosOsFilmesPorNota(String avaliacao){

		ArrayList<Filme> todosOsFilmesPorNota = new ArrayList<Filme>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conexao.prepareStatement("SELECT filme.id_filme, filme.nome, filme.sinopse, filme.classificacao, filme.avaliacao, filme.ano, filme.duracao, filme.data_lancamento, filme.url " +
										  "FROM filme where filme.avaliacao >= ? and filme.avaliacao <= (? + 0.9) order by avaliacao desc");
			ps.setDouble(1, Double.parseDouble(avaliacao));
			ps.setDouble(2, Double.parseDouble(avaliacao));
			
			rs = ps.executeQuery();

			while(rs.next()){
				todosOsFilmesPorNota.add(new Filme(rs.getInt("id_filme"), rs.getString("nome"), rs.getString("sinopse"), rs.getString("classificacao"), rs.getDouble("avaliacao"), 
						 rs.getInt("ano"), rs.getInt("duracao"), rs.getDate("data_lancamento"), rs.getString("url")));
			}
			ps.close();
			rs.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return todosOsFilmesPorNota;


	}
}
