<%@page import="webToDo.metier.Tache"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TodoList.io, the new hype webapp for you're life</title>
</head>
<body>
	<h2>TodoList.io the app</h2>
	<table border="1">
		<tr><th>description</th><th>categorie</th><th>priorite</th><th>actions</th></tr>
		<%
		List<Tache> taches = (List<Tache>)request.getAttribute("taches");
		for (Tache t : taches ){
		%>
		<tr>
			<td><%= t.getDescritpion() %></td>
			<td><%= t.getCategorie() %></td>
			<td><%= t.getPriorite() %></td>
			<td>actions...</td>
		</tr>
		<%
		}
		%>
	</table>
	<form method="post">
		<label> for="description"</label><input type="text" name="description" /><br />
		<label> for="categorie"</lablel><input type="text" name="categorie" /><br />
		<label> for="priorite"</label><select name="priorite">
			<option value="1">faible</option>
			<option value="2">moyenne</option>
			<option value="3">haute</option>
			<option value="4">critique</option>
			</select><br />
		<input type="submit" value="ajouter" />
	</form>	
</body>
</html>