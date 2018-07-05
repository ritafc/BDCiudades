<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de Código de País</h1>
		<c:forEach var="uncodigo" items="${listaCountryCode}">
			<details>
			<summary> ${uncodigo.code}</summary>
			<ul>	
				<li><span>El Codigo de Pais es::  ${uncodigo.code}</span></li>
				<li><span>El lenguaje es::  ${uncodigo.language}</span></li>
				<li><span>Idioma :: ${uncodigo.official} </span></li>
				<li><span>Porcentaje ::${uncodigo.percentaje}</span></li>
			</ul>	
			</details>	
		</c:forEach>
	
</body>
</html>