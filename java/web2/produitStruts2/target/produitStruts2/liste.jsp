<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>liste des produits</title>
</head>
<body>
<h2>coolProduit.io</h2>
<table border="1">
<tr><th>ID</th><th>nom</th><th>prix</th><th>poids</th><th>stock</th></tr>
<s:iterator value="produits" >
<tr>
<td><s:property value="id" /></td>
<td><s:property value="nom" /></td>
<td><s:property value="prix" /></td>
<td><s:property value="poids" /></td>
<td><s:property value="stock" /></td>
</tr>
</s:iterator>
</table>
</body>
</html>