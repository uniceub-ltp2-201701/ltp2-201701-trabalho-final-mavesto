package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Genero;

public class DetalhaGeneroDAO {

	private Connection conexao;

	//metopdo construtor

	public DetalhaGeneroDAO(Connection conexao){
		this.conexao = conexao;
	}

	public Genero getGenero(String idGenero){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Genero g = null;
		try {
			ps = conexao.prepareStatement("SELECT id_genero, nome FROM genero where id_genero = ?");
			ps.setInt(1, Integer.parseInt(idGenero));
			rs = ps.executeQuery();
			while(rs.next()){
				g = new Genero(rs.getInt("id_genero"), rs.getString("nome"));

			}
			ps.close();
			rs.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}


		return g;
	}

}
