<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>produit.io</title>
</head>
<body>
<h2>liste des produits</h2>
<table border="1">
<tr><th>ID</th><th>nom</th><th>prix</th><th>poids</th><th>stock</th><th>actions</th></tr>
<s:iterator  value="produits" >
<tr>
	<td><s:property value="id" /></td>
	<td><s:property value="nom" /></td>
	<td><s:property value="prix" /></td>
	<td><s:property value="poids" /></td>
	<td><s:property value="stock" /></td>
	<td><s:property value="categorie" /></td>
	<td>
		<s:a action="edit/%{id}">edition</s:a>
		<s:a action="remove/%{id}" onclick="return confirm('etes vous sur?');" >suppression</s:a>
	</td>	
</tr>
</s:iterator>
</table>
<s:a action="create">creation nouveau produit</s:a>
</body>
</html>