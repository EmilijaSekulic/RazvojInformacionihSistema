<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Naocare u zadatom rasponu cena </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">
</head>
<body background="${pageContext.request.contextPath}/slike/slika8.jpg">

	<div class="divUnos">	
	
		<form action = "/NaocareShop/korisnici/getZadateCene" method = "get">
		
			<table class="tabelica">
				
				<tr>
					<td> Cena od: </td>
					<td> <input type = "text" name = "cenaOd"> </td>
				</tr>
				<tr>
					<td> Cena do: </td>
					<td> <input type = "text" name = "cenaDo"> </td>
				</tr>
				<tr>
					<td></td>
					<td> <input type = "submit" value = "Prikazi"> </td>
				</tr>
			</table>	
		</form>
		<br><br><br>
		<h3 style = "text-align: center; color: red"> <a href = "/NaocareShop/pocetna.jsp"> Povratak na pocetnu stranicu </a> </h3>		
	</div>

</body>
</html>