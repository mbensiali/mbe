<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>liste des encheres</title>
</head>
<body>
<h2>coolEncheres.io</h2>
<table border="1">
<tr><th>ID</th><th>description</th><th>prixDepart</th><th>enchereMin</th><th>prixActuel</th></tr>
<s:iterator value="encheres" >
<tr>
<td><s:property value="id" /></td>
<td><s:property value="description" /></td>
<td><s:property value="prixDepart" /></td>
<td><s:property value="enchereMin" /></td>
<td><s:property value="prixActuel" /></td>
</tr>
</s:iterator>
</table>
</body>
</html>