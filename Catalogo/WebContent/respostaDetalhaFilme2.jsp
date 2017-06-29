<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Filme" %>
<%@ page import="model.Genero" %>
<%@ page import="model.Pessoa" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Detalhes do Filme</title>
		<link rel="stylesheet" type="text/css" href="estilo.css">
	</head>
	<body>
		<% Filme f = (Filme) request.getAttribute("Filme");  %>
		<%ArrayList<Genero> generosDoFilme = (ArrayList<Genero>) request.getAttribute("generosDoFilme");  %>
		<%ArrayList<Genero> todosOsGeneros = (ArrayList<Genero>) request.getAttribute("todosOsGeneros");  %>
		<%ArrayList<Pessoa> todasAsProfissoes = (ArrayList<Pessoa>) request.getAttribute("todasAsProfissoes");  %>
		<%ArrayList<Pessoa> todosOsAtoresDeUmFilme = (ArrayList<Pessoa>) request.getAttribute("todosOsAtoresDeUmFilme");  %>
		<%ArrayList<Pessoa> todosOsDiretoresDeUmFilme = (ArrayList<Pessoa>) request.getAttribute("todosOsDiretoresDeUmFilme");  %>
		<%ArrayList<Pessoa> diretoresExistentes = (ArrayList<Pessoa>) request.getAttribute("diretoresExistentes");  %>
		
		<fieldset>
		<legend><h2><strong>Informações do filme</strong></h2></legend>
			
			<fieldset id="posters"><img id="imagemDoFilme" src="<%= f.getUrl()%>" alt="<%= f.getNome()%>"></fieldset><br>
			<strong>Nome:</strong> <%= f.getNome() %><br>
		    <strong>Ano:</strong> <a href="listaFilmesDeUmAno2?ano=<%= f.getAno() %>"><%= f.getAno() %></a><br>
		    <strong>Sinopse:</strong> <%= f.getSinopse() %><br>
			<strong>Classificação Etária:</strong> <%= f.getClassificacao() %><br>
			<strong>Avaliação:</strong> <%= f.getAvaliacao() %><br>
			<strong>Duração:</strong> <%= f.getDuracao() %>min<br>
			<strong>Data de Lançamento:</strong> <%= f.getData_lancamento() %><br><br>
			<strong>Gêneros:</strong>
			<%for(Genero g: generosDoFilme){%>
				<tr><td>
				/<a href="listaFilmesDoGenero2?idgenero=<%=g.getId_genero() %>"><%=g.getNome()%></a></td></tr>
			<% }%><br><br>
			
			<strong>Atores:</strong>
			<%for(Pessoa p: todosOsAtoresDeUmFilme){%>
				<tr><td>
				/<a href="detalhaPessoa2?idPessoa=<%=p.getId_pessoa() %>"><%= p.getNome()%></a></td></tr>
			<% }%><br><br>
			
			<strong>Diretores:</strong>
			<%for(Pessoa p: todosOsDiretoresDeUmFilme){%>
				<tr><td>
				/<a href="detalhaPessoa2?idPessoa=<%=p.getId_pessoa() %>"><%= p.getNome()%></a></td></tr>
			<% }%>
		</fieldset><br>
		
		
		<form action="/Catalogo_de_filmes/inicio">
			<input type="submit" value="Voltar ao Inicio"/>
		</form>
	</body>
</html>