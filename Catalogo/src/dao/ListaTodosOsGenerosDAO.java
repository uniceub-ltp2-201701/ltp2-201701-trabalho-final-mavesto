package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Genero;

public class ListaTodosOsGenerosDAO {

	private Connection conexao;

	public ListaTodosOsGenerosDAO(Connection conexao){
		this.conexao = conexao;
	}

	public ArrayList<Genero> getTodosOsGeneros(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Genero> generos = new ArrayList<Genero>();

		try {
			ps = conexao.prepareStatement("select genero.id_genero, genero.nome from genero ORDER BY nome");
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
