package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Genero;

public class ListaGenerosQueNaoEstaoNoFilmeDAO {
	
	private Connection conexao;
	
	public ListaGenerosQueNaoEstaoNoFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Genero> getTodosOsGeneros(String id_filme){
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Genero> generos = new ArrayList<Genero>();
		
		try {
			ps = conexao.prepareStatement("select genero.id_genero, genero.nome from genero where genero.id_genero not in (SELECT genero_filme.id_genero from genero_filme where genero_filme.id_filme = ?) ORDER BY nome");
			ps.setInt(1, Integer.parseInt(id_filme));
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
