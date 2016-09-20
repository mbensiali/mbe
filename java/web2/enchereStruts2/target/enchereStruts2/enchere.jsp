<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>saisir une enchere!!!</title>
</head>
<body>
	<h2>coolBook.io</h2>
	<s:form action="saveEnchere" method="post">
		<s:textfield name="description" label="description" />
		<s:textfield name="prixDepart" label="prix de depart"/>
		<s:textfield name="enchereMin" label="enchere minimum"/>
		<s:textfield name="prixActuel" label="prix actuel"/>
		<s:submit/>
	
	</s:form>

</body>
</html>