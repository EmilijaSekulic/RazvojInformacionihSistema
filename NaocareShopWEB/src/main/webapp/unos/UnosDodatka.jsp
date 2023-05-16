<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Unos opreme </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">
</head>
<body background="${pageContext.request.contextPath}/slike/slika8.jpg">

	<div class="divUnos">	
	
		<form action = "/NaocareShop/administrator/saveDodatak" method = "post">
		
			<table class="tabelica">
				<tr>
					<td> Naziv dodatka: </td>
					<td> <input type = "text" name = "nazivDodatka"> </td>
				</tr>	
				<tr>
					<td> Cena: </td>
					<td> <input type = "text" name = "cena"> </td>
				</tr>	
				<tr>
					<td></td>
					<td> <input type = "submit" value = "Sacuvaj"> </td>
				</tr>
			</table>
		</form>
	</div>	
	
	
	<c:if test = "${!empty dodatak}">		
		<p class="paragraf"> <b> ${porukaDodatak} </b></p>
	</c:if>
	<br><br>
	
	<p class="paragraf"> <a href = "/NaocareShop/unos/UnosNoviteta.jsp"> Povratak na prethodnu stranicu </a> </p>
	
</body>
</html>