<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>saisir un produit!!!</title>
</head>
<body>
	<h2>coolProduit.io</h2>
	<s:form action="save" method="post">
		<s:textfield name="nom" label="nom" />
		<s:textfield name="prix" label="prix"/>
		<s:textfield name="poids" label="poids"/>
		<s:textfield name="stock" label="stock"/>
		<s:submit/>
	
	</s:form>

</body>
</html>