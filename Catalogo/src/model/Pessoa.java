package model;

public class Pessoa {
	
	//Atributos
	private int id_pessoa;
	private String nome;
	private int idade;
	private String biografia;
	private String url;
	
	public Pessoa(int id_pessoa, String nome, int idade, String biografia){
		this.setId_pessoa(id_pessoa);
		this.setNome(nome);
		this.setIdade(idade);
		this.setBiografia(biografia);
	}
	
	public Pessoa(int id_pessoa, String nome, int idade, String biografia, String url){
		this.setUrl(url);
		this.setId_pessoa(id_pessoa);
		this.setNome(nome);
		this.setIdade(idade);
		this.setBiografia(biografia);
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	//metodo get e set
	public int getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

}
