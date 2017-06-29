<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Filme" %>
<%@ page import="model.Pessoa" %>
<%@ page import="model.Genero" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de Filmes</title>
		 <link rel="stylesheet" type="text/css" href="estilo.css">
	</head>
	<body>
		<% ArrayList<Filme> Filmes = (ArrayList<Filme>) request.getAttribute("Filmes");  %>
		<% ArrayList<Pessoa> todasAsPessoas = (ArrayList<Pessoa>) request.getAttribute("todasAsPessoas");  %>
		<% ArrayList<Genero> generos = (ArrayList<Genero>) request.getAttribute("generos");  %>
		
		<div id="listaDeFilmes">
			<fieldset>
				<legend><h3><strong>Filmes</strong></h3></legend>
				<table border="2">
					<tr>
						<td><strong>Títulos</strong></td>
						<td><strong>Excluir</strong></td>
					</tr>
				<%for(Filme f: Filmes){%>
					<tr><td>
					<a  href="detalhaFilme?idfilme=<%=f.getId_filme() %>"><%=f.getNome()%></a></td>
					<td><form action="/Catalogo_de_filmes/excluirFilme" method="post"><input type="hidden" name="idfilme" value="<%=f.getId_filme() %>">
					<input type="submit" value="Excluir!"/></form></td></tr>
					
				<% }%>
				</table>
			</fieldset>
		</div>
		
		<div id="excluirPessoa">
			<form action="/Catalogo_de_filmes/excluirPessoa" method="post">
				<fieldset>
					<h3><strong>Excluir pessoa no banco de dados</strong></h3>
					<select name="idpessoa">
						<%for(Pessoa p: todasAsPessoas){%>
							<option value="<%= p.getId_pessoa()%>"><%= p.getNome() %></option>
						<% }%>
					</select><br><br>
					
					<input type="submit" value="Excluir"/>
				</fieldset>
			</form>
		</div>
		
		<div id="adicionarUmNovoFilme">
			<form action="/Catalogo_de_filmes/adicionarFilme" method="post">
				<fieldset>
					<legend><h3><strong>Adicionar um novo filme</strong></h3></legend>
					<strong>Nome:</strong><input type="text" name="nomedofilme"/><br>
					<strong>Sinopse: </strong><input type="text" name="sinopsedofilme"/><br>
					<strong>Classificação Etária: </strong><input type="text" name="classificacaodofilme"/><br>
					<strong>Avaliação: </strong><input type="text" name="avaliacaodofilme"/><br>
					<strong>Ano: </strong><input type="text" name="anodofilme"/><br>
					<strong>Duração:</strong> <input type="text" name="duracaodofilme"/><br>
					<strong>Data de Lançamento: </strong><input type="text" name="datadofilme"/><br>
					<strong>URL da Imagem: </strong><input type="text" name="urldofilme"/><br><br>
					<input type="submit" value="Adicionar"/>
				</fieldset>
			</form>
		</div>
		
		<div id="adicionarUmaNovaPessoa">
			<form action="/Catalogo_de_filmes/adicionarPessoa" method="post">
				<fieldset>
					<h3><strong>Adicionar uma nova pessoa no banco de dados</strong></h3>
					<strong>Nome:</strong><input type="text" name="nomedapessoa"/><br>
					<strong>Idade: </strong><input type="text" name="idadedapessoa"/><br>
					<strong>Biografia: </strong><input type="text" name="biografiadapessoa"/><br>
					<strong>URL: </strong><input type="text" name="urldapessoa"/><br><br>
					<input type="submit" value="Adicionar"/>
				</fieldset>
			</form>
		</div>
		
		<form action="/Catalogo_de_filmes/listaTodosOsFilmes">
			Pesquisar filme: <input type="text" name="nomeDoFilme"/>
			<input type="submit" value="Pesquisar"/>
			
		</form>
		
		
			<form action="/Catalogo_de_filmes/listaFilmesDoGenero" >
				Pesquisar filmes de: 
					<select name="idgenero">
						<%for(Genero g: generos){%>
							<option value="<%= g.getId_genero()%>"><%= g.getNome() %></option>
						<% }%>
					</select>
					
					<input type="submit" value="Pesquisar"/><br>
				
			</form>
			
			<form action="/Catalogo_de_filmes/inicio" >
				
					
					<input type="submit" value="Deslogar"/>
				
			</form>
			
			
		
		
		
		
		
		
		
		
</html>