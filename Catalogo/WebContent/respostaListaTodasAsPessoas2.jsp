<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Pessoa" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de todos os filmes</title>
		<link rel="stylesheet" type="text/css" href="estilo.css">
	</head>
	<body>
	
	<% ArrayList<Pessoa> Pessoas = (ArrayList<Pessoa>) request.getAttribute("Pessoas");  %>
	<% String nomeDaPessoa  = (String) request.getParameter("nomeDaPessoa");  %>
	
	
	<strong><h3>Resultado da pesquisa:</strong> "<%= nomeDaPessoa %>"</h3><br><br>
	
	<div id="listaDePessoas">
		<%for(Pessoa p: Pessoas){%>
			<fieldset id="postersDePessoa">
			<a id="imagem" href="detalhaPessoa2?idPessoa=<%=p.getId_pessoa() %>"><img id="imagemDaPessoa" src="<%= p.getUrl()%>" alt="<%= p.getNome()%>"></a>
			<%= p.getNome()%>
			</fieldset>		
		<% }%><br>
	</div>
	<form action="/Catalogo_de_filmes/inicio">
		<input type="submit" value="Voltar ao Inicio"/>
	</form>
		
	
	
	
	</body>
</html>