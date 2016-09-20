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
<h2>edition des produits</h2>
<s:form action="save" method="post">
<s:hidden name="id" />
<s:textfield name="nom" label="nom du produit" />
<s:textfield name="prix" label="prix du produit" />
<s:textfield name="poids" label="poids du produit" />
<s:textfield name="stock" label="niveau du stock" />
<s:select list="categories" name="categorieId" listKey="id" listValue="libelle" />
<s:submit value="sauvegarder" />
</s:form>
</body>
</html>