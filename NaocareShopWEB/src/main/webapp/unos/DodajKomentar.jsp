<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Ostavljanje komentara </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">
</head>
<body background="${pageContext.request.contextPath}/slike/slika8.jpg">

	<div class="divUnos">	
	
		<h3 style = "text-align:center; color:red"> Dodavanje komentara za odabrane naocare </h3>		
		<br><br>
	
		<form action = "/NaocareShop/korisnici/dodajKomentar" method = "post">
		
			<table class="tabelica">
				<tr>
					<td> Unesite ocenu za izabrani proizvod: </td>
					<td> <input type = "text" name = "ocena" placeholder = "1-10"> </td>
				</tr>
				<tr>
					<td> Unesite komentar za proizvod: </td>
					<td> <textarea rows="10" cols="15" name = "komentar"></textarea>
				</tr>
				<tr>
					<td> <input type = "submit" value = "Unesite komentar"> </td>
				</tr>
			</table>
		</form>
	</div>	
	
	<c:if test = "${!empty ocena}">	
		<p class="paragraf"> ${porukaOcena} </p>
	</c:if>
	<br>
	<h3 style = "text-align:center; color:blue"> <a href = "/NaocareShop/pocetna.jsp"> Povratak na pocetnu stranicu </a> </h3>
	
</body>
</html>