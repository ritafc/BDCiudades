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
	<h1>Lista de Ciudades</h1>
	 

<hr>


	
	 <c:forEach var="unPais" items="${listapaises}">
	 <br><br>
	 	<summary><span>Nombre del Pais: ${unPais.name}</span><span>Código del País: ${unPais.code}</span></summary>
	 	<details>
	 	<c:forEach var="unlenguaje" items="${unPais.languages}">
			<li><span>Idioma del País: ${unlenguaje.language}</span></li>
			<li><span>Idioma oficial: ${unlenguaje.official}</span></li>
			<li><span>Poblacion que lo habla: ${unlenguaje.percentaje} %</span></li>
			<hr>
		</c:forEach> 
		</details>
		
	</c:forEach> 





</body>
</html>