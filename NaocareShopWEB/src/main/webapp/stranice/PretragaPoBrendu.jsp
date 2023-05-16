<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Pretraga po brendu </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">

</head>
<body background="${pageContext.request.contextPath}/slike/slika8.jpg">

	<div class="divUnos">	
			
		<form action = "/NaocareShop/korisnici/prikaziNaocareBrenda" method = "get">
			
			<table class="tabelica">
			
				<tr>
					<td> Odaberite brend: </td>
					<td>
						<select name = "brend">
							<c:forEach items = "${brendovi}" var = "b">
								<option value = "${b.idbrend}"> ${b.imeBrenda} </option>
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