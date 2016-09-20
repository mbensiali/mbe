<%@page import="webProduit.metier.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WEBAPP Products list</title>
</head>
<body>

	<table border="1">
		<tr><th>Nom</th><th>Prix</th><th>Poids</th><th>Stock</th><th>actions</th></tr>
	<% 
	List<Produit> produits = (List<Produit>)request.getAttribute("produits");
	for (Produit p : produits) {			
	%>
	<tr>
		<td><%= p.getNom() %></td>
		<td><%= p.getPrix() %></td>
		<td><%= p.getPoids() %></td>
		<td><%= p.getStock() %></td>
		<td><form method="post">
			<input type="hidden" 
				   name="nom"
				   value="<%= p.getNom()%>"/>
			<input type="submit" value="supprmier" name="action" />
			</form>
		</td>
	</tr>
	<%
	}
	%>
	</table>

	<form method="post">
		<label for="nom">nom</label> <input type="text" name="nom" id="nom" /><br />
		<label for="prix">prix</label> <input type="text" name="prix" id="prix"/><br />
		<label for="poids">poids</label> <input type="text" name="poids" id="poids"/><br />
		<label for="stock">stock</label> <input type="stock" name="stock" id="stock"/><br />
		<input type="submit" value="ajouter" />
	</form>

</body>
</html>