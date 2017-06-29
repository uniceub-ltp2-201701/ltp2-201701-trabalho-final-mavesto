<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Filme" %>
<%@ page import="model.Pessoa" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Detalhe do Ator/Diretor</title>
		<link rel="stylesheet" type="text/css" href="estilo.css">
	</head>
	<body>
		<% Pessoa p = (Pessoa) request.getAttribute("pessoa");  %>
		<%ArrayList<Filme> filmesQueFoiAtor = (ArrayList<Filme>) request.getAttribute("filmesQueFoiAtor");  %>
		<%ArrayList<Filme> filmeQueFoiDiretor = (ArrayList<Filme>) request.getAttribute("filmeQueFoiDiretor");  %>
		
		
		<fieldset>
		<legend><h2><strong>Informações do Ator/Diretor</strong></h2></legend>
		
			<fieldset id="posters"><img id="imagemDoFilme" src="<%= p.getUrl()%>" alt="<%= p.getNome()%>"></fieldset><br>
			
			<strong>Nome:</strong> <%= p.getNome() %><br><br>
		    <strong>Idade:</strong> <%= p.getIdade() %><br><br>
		    <strong>Biografia:</strong> <%= p.getBiografia()%><br><br>
			<strong>Filmes em que <%= p.getNome() %> foi ator/atriz:</strong>
			<%for(Filme f: filmesQueFoiAtor){%>

				<tr><td><br>
				-<a href="detalhaFilme?idfilme=<%=f.getId_filme() %>"><%=f.getNome()%></a></td></tr><br>
			<% }%><br><br>
			
			<strong>Filmes em que <%= p.getNome() %> foi diretor/diretora:</strong>
			<%for(Filme f: filmeQueFoiDiretor){%>
				<tr><td><br>
				-<a href="detalhaFilme?idfilme=<%=f.getId_filme() %>"><%=f.getNome()%></a></td></tr><br>

				<tr><td>
				
			<% }%><br><br>
			
			
		</fieldset><br>
		<form action="/Catalogo_de_filmes/administrador" method="post">
			<input type="submit" value="Voltar ao Inicio"/>
		</form>
		
	</body>
</html>