<%@page import="webBlogging.metier.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>App. Blogging - poster des messages</title>
	</head>
	<body>
		<h2>The Blogging application </h2>
		
		<table border="1">
			<tr><th>Titre</th><th>Corps</th><th>Categorie</th><th>Auteur</th></tr>
		<% 
		List<Post> posts = (List<Post>)request.getAttribute("posts");
		for (Post p : posts) {			
		%>
		<tr>
			<td><%= p.getTitre() %></td>
			<td><%= p.getCorps() %></td>
			<td><%= p.getCategorie() %></td>
			<td><%= p.getAuteur() %></td>
			<td>
				<form method="get" action="postedit">
					<input type="hidden" 
						   name="id"
						   value="<%= p.getId() %>"/>
					<input type="submit" value="editer produit" name="action" />
				</form>
			</td>
		</tr>
		<%
		}
		%>
		</table>	
	
		<form method="get" action="postedit">
			<input type="hidden" name="id" value="0">
			<input type="submit" name="action" value="creer post" />
		</form>
	</body>
</html>