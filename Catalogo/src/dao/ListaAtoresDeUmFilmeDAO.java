package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Pessoa;

public class ListaAtoresDeUmFilmeDAO {


	private Connection conexao;

	public ListaAtoresDeUmFilmeDAO(Connection conexao){

		this.conexao = conexao;
	}

	public ArrayList<Pessoa> getTodosOsAtoresDeUmFilme(String id_filme){

		ArrayList<Pessoa> atoresDoFilme = new ArrayList<Pessoa>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conexao.prepareStatement("SELECT pessoa.id_pessoa, pessoa.nome, pessoa.idade, pessoa.biografia FROM pessoa_ator, pessoa WHERE pessoa_ator.id_filme = ? and pessoa_ator.id_pessoa = pessoa.id_pessoa ORDER BY nome");
			ps.setInt(1, Integer.parseInt(id_filme));
			rs = ps.executeQuery();

			while(rs.next()){
				atoresDoFilme.add(new Pessoa(rs.getInt("id_pessoa"), rs.getString("nome"), rs.getInt("idade"), rs.getString("biografia")));
			}
			ps.close();
			rs.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return atoresDoFilme;


	}
}
