<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Editar Ciudad</h1>
<form action="" method="POST">
<input type="hidden" name="id_ciudad" value="${city.id}">
  Nombre de la Ciudad:<br>
  <input type="text" name="name" value="${city.name}">
  <br>
  Codigo de la Ciudad:<br>
  <input type="text" name="countrycode" value="${city.code}">
   <br>
  Distrito:<br>
  <input type="text" name="distrito" value="${city.district}">
   <br>
  Población:<br>
  <input type="text" name="population" value="${city.population}">
  <br><br>
  <input type="submit" value="Editar">
</form> 
</body>
</html>