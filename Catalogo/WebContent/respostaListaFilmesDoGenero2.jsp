<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Filme" %>
<%@ page import="model.Genero" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista De filmes Do Gênero</title>
		<link rel="stylesheet" type="text/css" href="estilo.css">
	</head>
	<body>
	
		<% Genero g = (Genero) request.getAttribute("genero");  %>
		<%ArrayList<Filme> filmesDoGenero = (ArrayList<Filme>) request.getAttribute("filmesDoGenero");  %>
		
		
		<fieldset>
		<legend><h2><strong>Filmes do gênero <%= g.getNome()%>: </strong></h2></legend>
			<%for(Filme f: filmesDoGenero){%>
				<fieldset id="posters">
					<a id="imagem" href="detalhaFilme2?idfilme=<%=f.getId_filme() %>"><img id="imagemDoFilme" src="<%= f.getUrl()%>" alt="<%= f.getNome()%>"></a>
				</fieldset>
			<% }%>	
		</fieldset><br>
		<form action="/Catalogo_de_filmes/inicio">
			<input type="submit" value="Voltar ao Inicio"/>
		</form>
		
		<a href="/Catalogo_de_filmes/detalhaFilme2"></a>
	</body>
</html>