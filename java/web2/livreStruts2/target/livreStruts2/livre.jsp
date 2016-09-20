<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>saisir un livre!!!</title>
</head>
<body>
	<h2>coolBook.io</h2>
	<s:form action="saveBook" method="post">
		<s:textfield name="titre" label="titre du livre" />
		<s:textfield name="auteur" label="auteur du livre"/>
		<s:textfield name="categorie" label="categorie du livre"/>
		<s:textfield name="nbpage" label="nombre de pages du livre"/>
		<s:textfield name="isbn" label="code isbn du livre"/>
		<s:submit/>
	
	</s:form>

</body>
</html>