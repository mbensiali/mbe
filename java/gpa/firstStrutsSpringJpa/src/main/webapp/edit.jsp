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
<h2>edition messages</h2>
<s:form action="save" method="post">
<s:hidden name="id" />
<s:textfield name="titre" label="titre du message" />
<s:textfield name="corps" label="corps du message" />
<s:submit value="sauvegarder" />
</s:form>
</body>
</html>