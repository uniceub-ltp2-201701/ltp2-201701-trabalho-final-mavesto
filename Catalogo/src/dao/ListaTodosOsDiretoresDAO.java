package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Pessoa;

public class ListaTodosOsDiretoresDAO {
	
	private Connection conexao;

	public ListaTodosOsDiretoresDAO(Connection conexao){

		this.conexao = conexao;
	}

	public ArrayList<Pessoa> getTodosOsDiretores(String id_filme){

		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conexao.prepareStatement("select pessoa.id_pessoa, pessoa.nome, pessoa.idade, pessoa.biografia  from pessoa where pessoa.id_pessoa not in (SELECT pessoa_diretor.id_pessoa from pessoa_diretor where pessoa_diretor.id_filme = ?) ORDER BY nome");
			ps.setInt(1, Integer.parseInt(id_filme));
			rs = ps.executeQuery();

			while(rs.next()){
				pessoas.add(new Pessoa(rs.getInt("id_pessoa"), rs.getString("nome"), rs.getInt("idade"), rs.getString("biografia")));
			}
			ps.close();
			rs.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return pessoas;


	}

}
