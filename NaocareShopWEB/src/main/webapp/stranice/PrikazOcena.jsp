<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Prikaz ocena i komentara </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style2.css">
</head>
<body background="${pageContext.request.contextPath}/slike/slika8.jpg">

	<div class="divUnos">	
					
		<br><br>			
		<h4 style="color: blue; font-size:20px; font-family: cursive; text-align:center;"> Prikaz postojecih komentara i ocena </h4>							
					
		<c:if test = "${!empty ocene}">
												
			<table>
				<tr>
					<th> Naocare </th>
					<th> Ocena </th>
					<th> Komentar </th>
					<th> </th>
				</tr>
				
				<c:forEach items = "${ocene}" var = "o">
				
					<tr>
						<td> ${o.naocare.naziv} </td>
						<td> ${o.ocena} </td>
						<td> ${o.komentar} </td>
						<td> <a href = "/NaocareShop/administrator/obrisiOcenu?idO=${o.idocena}"> Obrisi komentar </a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br><br><br>
		<h3 style = "text-align:center; color:blue"> <a href = "/NaocareShop/pocetna.jsp"> Povratak na pocetnu stranicu </a> </h3>		
	</div>
	
</body>
</html>