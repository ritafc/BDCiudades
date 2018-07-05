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
	 
<form action="" method="GET">
 <fieldset>
  <legend>Lista de Paises:</legend>
  <select name="pais" id="">
  <option value="" selected disabled>Seleccione un país...</option>
  <c:forEach var="unPais" items="${listapaises}">
    <option ${countryCode.equals(unPais.code)?"selected":""} value="${unPais.code}">${unPais.name}</option>
    </c:forEach>
  </select>
  <br><br>
  <input type="submit">
  </fieldset>
</form>
<br><br>
<hr>

<br><br>

	 <c:forEach var="unaCiudad" items="${listaciudades}">
	<a href="./editar?idcity=${unaCiudad.id}"><summary> ${unaCiudad.name}</summary></a>
	 <details>
			<li><span>ID: ${unaCiudad.id}</span></li>
			<li><span>Nombre de la Ciudad: ${unaCiudad.name}</span></li>
			<li><span>Distrito: ${unaCiudad.district}</span></li>
			<li><span>Poblacion: ${unaCiudad.population}</span></li>
			<li><span>Codigo Pais: ${unaCiudad.country.code}</span></li>
			<li><span>Nombre Pais: ${unaCiudad.country.name}</span></li>
		</details>
		<a href="./borrar?idcity=${unaCiudad.id}&code=${unaCiudad.country.code}">BORRAR</a>
		<hr>
	</c:forEach> 
	



</body>
</html>