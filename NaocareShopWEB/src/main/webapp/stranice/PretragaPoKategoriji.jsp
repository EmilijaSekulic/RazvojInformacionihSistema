<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Pretraga po kategoriji </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">

</head>
<body background="${pageContext.request.contextPath}/slike/slika8.jpg">

	<div class="divUnos">	
			
		<form action = "/NaocareShop/korisnici/prikaziNaocareIzabraneKategorije" method = "get">
			
			<table class="tabelica">
			
				<tr>
					<td> Odaberite kategoriju: </td>
					<td>
						<select name = "kategorija">
							<c:forEach items = "${kategorije}" var = "k">
								<option value = "${k.idkategorije}"> ${k.nazivKategorije} </option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td> <input type = "submit" value = "Prikazi"> </td>
				</tr>
			</table>
		</form>	
	</div>
	<br><br>

	<p class="paragraf"> <a href = "/NaocareShop/pocetna.jsp"> Povratak na pocetnu stranicu </a> </p>	
		
</body>
</html>