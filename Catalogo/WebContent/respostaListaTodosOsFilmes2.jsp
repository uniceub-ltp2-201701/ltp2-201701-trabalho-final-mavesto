<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Filme" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de todos os filmes</title>
		<link rel="stylesheet" type="text/css" href="estilo.css">
	</head>
	<body>
	
	<% ArrayList<Filme> Filmes = (ArrayList<Filme>) request.getAttribute("Filmes");  %>
	<% String nomeDoFilme  = (String) request.getParameter("nomeDoFilme");  %>
	
	
	<strong><h3>Resultado da pesquisa:</strong> "<%= nomeDoFilme %>"</h3><br><br>
	
	
	<%for(Filme f: Filmes){%>
		
		<fieldset id="posters">
					<a id="imagem" href="detalhaFilme2?idfilme=<%=f.getId_filme() %>"><img id="imagemDoFilme" src="<%= f.getUrl()%>" alt="<%= f.getNome()%>"></a>
				</fieldset>			
	<% }%><br>
	
	<form action="/Catalogo_de_filmes/inicio" >
		<input type="submit" value="Voltar ao Inicio"/>
	</form>
		
	
	
	
	</body>
</html>