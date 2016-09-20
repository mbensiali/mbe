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
<h2>edition des categories</h2>
<s:form action="save2" method="post">
<s:hidden name="id" />
<s:textfield name="libelle" label="categorie produit" />
<s:submit value="sauvegarder" />
</s:form>
</body>
</html>