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

			<fieldset id="posters"><img id="imagemDoFilme" src="<%= f.getUrl()%>" alt="<%= f.getNome()%>"></fieldset>
			<fieldset id="detalhaFilme">
				<strong>Nome:</strong> <%= f.getNome() %><br>
			    <strong>Ano:</strong> <a href="listaFilmesDeUmAno?ano=<%= f.getAno() %>"><%= f.getAno() %></a><br>
				<strong>Classificação Etária:</strong> <%= f.getClassificacao() %><br>
				<strong>Avaliação:</strong> <%= f.getAvaliacao() %><br>
				<strong>Duração:</strong> <%= f.getDuracao() %>min<br>
				<strong>Data de Lançamento:</strong> <%= f.getData_lancamento() %><br>
				<strong>Gêneros:</strong>
				<%for(Genero g: generosDoFilme){%>
					<tr><td>
					/<a href="listaFilmesDoGenero?idgenero=<%=g.getId_genero() %>"><%=g.getNome()%></a></td></tr>
				<% }%><br>
				
				<strong>Atores:</strong>
				<%for(Pessoa p: todosOsAtoresDeUmFilme){%>
					<tr><td>
					/<a href="detalhaPessoa?idPessoa=<%=p.getId_pessoa() %>"><%= p.getNome()%></a></td></tr>
				<% }%><br>
				
				<strong>Diretores:</strong>
				<%for(Pessoa p: todosOsDiretoresDeUmFilme){%>
					<tr><td>
					/<a href="detalhaPessoa?idPessoa=<%=p.getId_pessoa() %>"><%= p.getNome()%></a></td></tr>
				<% }%><br>
				 <strong>Sinopse:</strong> <%= f.getSinopse() %>
			</fieldset>
		</fieldset><br>
		
		<div id="adicionarGenero">
			<form action="/Catalogo_de_filmes/adicionarGeneroFilme" >
				<fieldset>
					<h3><strong>Adicionar gêneros ao filme</strong></h3>
					<select name="idgenero">
						<%for(Genero g: todosOsGeneros){%>
							<option value="<%= g.getId_genero()%>"><%= g.getNome() %></option>
						<% }%>
					</select><br>
					<input type="hidden" name="idfilme" value="<%=f.getId_filme() %>"><br>
					<input type="submit" value="Adicionar"/>
				</fieldset>
			</form>
		</div>
		<div id="excluirGenero">
			<form action="/Catalogo_de_filmes/excluirGeneroDoFilme" >
				<fieldset>
					<h3><strong>Excluir gêneros do filme</strong></h3>
					<select name="idgenero">
						<%for(Genero g: generosDoFilme){%>
							<option value="<%= g.getId_genero()%>"><%= g.getNome() %></option>
						<% }%>
					</select><br>
					<input type="hidden" name="idfilme" value="<%=f.getId_filme() %>"><br>
					<input type="submit" value="Excluir"/>
				</fieldset>
			</form>
		</div>
		
		<div id="adicionarAtor">
			<form action="/Catalogo_de_filmes/adicionarAtor" >
				<fieldset>
					<h3><strong>Adicionar ator ao filme</strong></h3>
					<select name="idpessoa">
						<%for(Pessoa p: todasAsProfissoes){%>
							<option value="<%= p.getId_pessoa()%>"><%= p.getNome()%></option>
						<% }%>
					</select><br>
					<input type="hidden" name="idfilme" value="<%=f.getId_filme() %>"><br>
					<input type="submit" value="Adicionar"/><br>
				</fieldset>
			</form>
		</div>
		
		<div id="adicionarDiretor">
			<form action="/Catalogo_de_filmes/adicionarDiretor" >
				<fieldset>
					<h3><strong>Adicionar diretor ao filme</strong></h3>
					<select name="idpessoa">
						<%for(Pessoa p: diretoresExistentes){%>
							<option value="<%= p.getId_pessoa()%>"><%= p.getNome()%></option>
						<% }%>
					</select><br>
					<input type="hidden" name="idfilme" value="<%=f.getId_filme() %>"><br>
					<input type="submit" value="Adicionar"/><br>
				</fieldset>
			</form>
		</div>
		
		<div id="excluirAtor">
			<form action="/Catalogo_de_filmes/excluirAtorDeUmFilme" >
				<fieldset>
					<h3><strong>Excluir Ator</strong></h3>
					<select name="idpessoa">
						<%for(Pessoa p: todosOsAtoresDeUmFilme){%>
							<option value="<%= p.getId_pessoa()%>"><%= p.getNome()%></option>
						<% }%>
					</select><br>
					<input type="hidden" name="idfilme" value="<%=f.getId_filme() %>"><br>
					<input type="submit" value="Excluir"/><br>
				</fieldset>
			</form>
		</div>
		
		<div id="excluirDiretor">
			<form action="/Catalogo_de_filmes/excluirDiretorDeUmFilme" >
				<fieldset>
					<h3><strong>Excluir diretor</strong></h3>
					<select name="idpessoa">
						<%for(Pessoa p: todosOsDiretoresDeUmFilme){%>
							<option value="<%= p.getId_pessoa()%>"><%= p.getNome()%></option>
						<% }%>
					</select><br>
					<input type="hidden" name="idfilme" value="<%=f.getId_filme() %>"><br>
					<input type="submit" value="Excluir"/><br>
				</fieldset>
			</form>
		</div><br>
		
		<form action="/Catalogo_de_filmes/administrador" method ="post">
			<div id="botao">
				<input type="submit" value="Voltar ao Inicio"/>
			</div>	
		</form>
	</body>
</html>