package model;

public class Genero {
	
	//atributos
	private int id_genero;
	private String nome;
	
	
	//metodo construtor
	public Genero(int id_genero, String nome){
		this.setId_genero(id_genero);
		this.setNome(nome);
	}
	
	
	//metodo get e set
	public int getId_genero() {
		return id_genero;
	}
	public void setId_genero(int id_genero) {
		this.id_genero = id_genero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
