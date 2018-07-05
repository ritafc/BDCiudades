<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <!doctype html>
  <html lang="en">
  <head>
  	<meta charset="UTF-8" />
  	<title>Document</title>
  </head>
  <body>
  	<h1>Editar Ciudad</h1>
  	<section>
		<form action="" method="POST">
			<input type="hidden" name="id_ciudad" value="${city.id}">
			  Nombre de la Ciudad:<br>
  			<input type="text" name="name" value="${city.name}">
   			<br>
  			Distrito:<br>
  			<input type="text" name="distrito" value="${city.district}">
  			<br>
  			Población:<br>
  			<input type="text" name="population" value="${city.population}">
  			<br><br>
  			<h3>Pais</h3>
  			<br>
  			Codigo del Pais:<br>
  			<input type="text" name="countrycode"  value="${country.code}" placeholder="codigo del pais">
			<br>
  			Nombre del Pais:<br>
  			<input type="text" name="countryname"  value="${country.name}" placeholder="nombre del pais">
  			
  <input type="submit" value="Aceptar">
</form> 
  </section>
  </body>
  </html>