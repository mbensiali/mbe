<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cuicui.io</title>
</head>
<body>
<h2>liste des messages</h2>
<table border="1">
<tr><th>ID</th><th>titre</th><th>corps</th><th></th><th>actions</th></tr>
<s:iterator value="messages">
<tr>
	<td><s:property value="id" /></td>
	<td><s:property value="titre" /></td>
	<td><s:property value="corps" /></td>
	<td><s:iterator value=etiquetages" status ="pos">
		<s:property value="libelle"/>
		<s:if test="#pos.last == false">,</s:if>
	</s:iterator></td>
	<td><s:a action="edit/%{id}">edition</s:a>
		<s:a action="remove/%{id}" onclick="return confirm ('etes-vous sur?');">suppression</s:a>
	</td>
</tr>
</s:iterator>

</table>
<s:a action="create">creation nouveau message</s:a>


</body>
</html>