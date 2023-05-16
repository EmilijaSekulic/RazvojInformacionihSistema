<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Prikaz ponuda </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style2.css">
</head>
<body  background="${pageContext.request.contextPath}/slike/slika8.jpg">

	<div class="divUnos">	
	
		<c:if test = "${!empty dodaci}">
	
			<br><br>
			<h3 style="font-size:15px; font-family: cursive; text-align:center;"> <a href = "/NaocareShop/pocetna.jsp"> Povratak na pocetnu stranicu </a> </h3>
			
			<table>
				<tr>
					<th> Naziv dodatka </th>
					<th> Cena </th>
				</tr>
				
				<c:forEach items = "${dodaci}" var = "d">
				
					<tr>
						<td> ${d.nazivDodatka} </td>
						<td> ${d.cena} </td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<br>
	
</body>
</html>