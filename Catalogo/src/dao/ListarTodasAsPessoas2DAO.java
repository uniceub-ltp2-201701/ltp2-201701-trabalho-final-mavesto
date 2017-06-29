package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Pessoa;

public class ListarTodasAsPessoas2DAO {
	
	private Connection conexao;

	public ListarTodasAsPessoas2DAO(Connection conexao){

		this.conexao = conexao;
	}

	public ArrayList<Pessoa> getTodosAsPessoas(String nomeDaPessoa){

		ArrayList<Pessoa> todasAsPessoas = new ArrayList<Pessoa>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conexao.prepareStatement("SELECT id_pessoa, nome, idade, biografia, url FROM pessoa WHERE nome like ?");
			ps.setString(1, nomeDaPessoa+"%");
			
			rs = ps.executeQuery();

			while(rs.next()){
				todasAsPessoas.add(new Pessoa(rs.getInt("id_pessoa"), rs.getString("nome"), rs.getInt("idade"), rs.getString("biografia"), rs.getString("url")));
			}
			ps.close();
			rs.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return todasAsPessoas;
	}
}
