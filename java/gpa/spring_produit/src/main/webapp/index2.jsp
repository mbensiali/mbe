<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>categorie.io</title>
</head>
<body>
<h2>liste des categories</h2>
<table border="1">
<tr><th>ID</th><th>libelle</th></tr>
<s:iterator  value="categories" >
<tr>
	<td><s:property value="id" /></td>
	<td><s:property value="libelle" /></td>
	<td>
		<s:a action="edit2/%{id}">edition</s:a>
		<s:a action="remove2/%{id}" onclick="return confirm('etes vous sur?');" >suppression</s:a>
	</td>	
</tr>
</s:iterator>
</table>
<s:a action="create2">creation nouvelle categorie</s:a>
</body>
</html>