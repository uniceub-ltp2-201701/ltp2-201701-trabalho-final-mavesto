package model;

import java.sql.Date;

public class Filme {
	
	//atributos
	private int id_filme;
	private String nome;
	private String sinopse;
	private String classificacao;
	private double avaliacao;
	private int ano;
	private int duracao;
	private Date data_lancamento;
	private String url;
	

	public Filme(int id_filme, String nome, String sinopse,  String classificacao, double avaliacao, int ano, int duracao, Date data_lancamento){
		this.setId_filme(id_filme);
		this.setNome(nome);
		this.setSinopse(sinopse);
		this.setClassificacao(classificacao);
		this.setAvaliacao(avaliacao);
		this.setAno(ano);
		this.setDuracao(duracao);
		this.setData_lancamento(data_lancamento);
	}
	
	public Filme(int id_filme, String nome, String sinopse,  String classificacao, double avaliacao, int ano, int duracao, Date data_lancamento, String url){
		this.setId_filme(id_filme);
		this.setNome(nome);
		this.setSinopse(sinopse);
		this.setClassificacao(classificacao);
		this.setAvaliacao(avaliacao);
		this.setAno(ano);
		this.setDuracao(duracao);
		this.setData_lancamento(data_lancamento);
		this.setUrl(url);
	}
	
	
	
	//metodod get e set
	public int getId_filme() {
		return id_filme;
	}
	public void setId_filme(int id_filme) {
		this.id_filme = id_filme;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public double getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public Date getData_lancamento() {
		return data_lancamento;
	}
	public void setData_lancamento(Date data_lancamento) {
		this.data_lancamento = data_lancamento;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	

}
