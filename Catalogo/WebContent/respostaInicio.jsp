<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		
			
			
		
		
		<div id="listaDeFilmesInicio">
			<%for(Filme f: Filmes){%>
				<fieldset id="posters">
					<a id="imagem" href="detalhaFilme2?idfilme=<%=f.getId_filme() %>"><img id="imagemDoFilme" src="<%= f.getUrl()%>" alt="<%= f.getNome()%>"></a>
				</fieldset>
			<% }%>	
		</div>
		
		<form action="/Catalogo_de_filmes/login" method="post">
			<div id="usuario">
				<strong>Nome: </strong><input type="text" name="nomeusuario"/>
				<strong>Senha: </strong><input type="password" name="senhausuario"/>
				<input type="submit" value="Login"/>
			</div>
		</form>
		
		
			<div id="pesquisas">
				<form action="/Catalogo_de_filmes/listaTodosOsFilmes2">
					<strong>Pesquisar filme: </strong><input type="text" name="nomeDoFilme"/>
					<input type="submit" value="Pesquisar"/><br><br>
				</form>
				
				<form action="/Catalogo_de_filmes/listaFilmesDoGenero2">
					<strong>Pesquisar filmes de: </strong>
					<select name="idgenero">
						<%for(Genero g: generos){%>
							<option value="<%= g.getId_genero()%>"><%= g.getNome() %></option>
						<% }%>
					</select>
					<input type="submit" value="Pesquisar"/>
				</form>
				
				<form action="/Catalogo_de_filmes/listaTodasAsPessoas">
					<strong>Pesquisar Pessoa: </strong><input type="text" name="nomeDaPessoa"/>
					<input type="submit" value="Pesquisar"/><br><br>
				</form>
			</div>
			<form action="/Catalogo_de_filmes/listaFilmesPorNota">
				<strong>Pesquisar filmes de pontuação: </strong>
				<select id="avaliacao" name="avaliacao">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					
				</select>
				<input type="submit" value="Pesquisar"/>
			</form>
	</body>
</html>