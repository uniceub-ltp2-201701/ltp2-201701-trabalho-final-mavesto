<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Filme" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista De filmes De Um Ano</title>
		<link rel="stylesheet" type="text/css" href="estilo.css">
	</head>
	<body>
	
		<% String ano = (String) request.getAttribute("ano");  %>
		<%ArrayList<Filme> Filmes = (ArrayList<Filme>) request.getAttribute("Filmes");  %>
		
		<fieldset>
		<legend><h2><strong>Filmes de <%= ano %>: </strong></h2></legend>
			<%for(Filme f: Filmes){%>
				<fieldset id="posters">
					<a id="imagem" href="detalhaFilme?idfilme=<%=f.getId_filme() %>"><img id="imagemDoFilme" src="<%= f.getUrl()%>" alt="<%= f.getNome()%>"></a>
				</fieldset>
			<% }%>
		</fieldset><br>
		<form action="/Catalogo_de_filmes/administrador" method="post">
			<input type="submit" value="Voltar ao Inicio"/>
		</form>
	</body>
</html>


					
