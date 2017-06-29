package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Pessoa;

public class ListarTodasAsPessoasDAO {
	
	private Connection conexao;

	public ListarTodasAsPessoasDAO(Connection conexao){

		this.conexao = conexao;
	}

	public ArrayList<Pessoa> getTodosAsPessoas(){

		ArrayList<Pessoa> todasAsPessoas = new ArrayList<Pessoa>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = conexao.prepareStatement("SELECT id_pessoa, nome, idade, biografia, url FROM pessoa ORDER BY nome");
			
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
