package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Pessoa;

public class ListaDiretorDeUmFilmeDAO {
	private Connection conexao;

	public ListaDiretorDeUmFilmeDAO(Connection conexao){

		this.conexao = conexao;
	}

	public ArrayList<Pessoa> getTodosOsDiretoresDeUmFilme(String id_filme){

		ArrayList<Pessoa> diretoresDoFilme = new ArrayList<Pessoa>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conexao.prepareStatement("SELECT pessoa.id_pessoa, pessoa.nome, pessoa.idade, pessoa.biografia FROM pessoa_diretor, pessoa WHERE pessoa_diretor.id_filme = ? and pessoa_diretor.id_pessoa = pessoa.id_pessoa ORDER BY nome");
			ps.setInt(1, Integer.parseInt(id_filme));
			rs = ps.executeQuery();

			while(rs.next()){
				diretoresDoFilme.add(new Pessoa(rs.getInt("id_pessoa"), rs.getString("nome"), rs.getInt("idade"), rs.getString("biografia")));
			}
			ps.close();
			rs.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return diretoresDoFilme;


	}



}
