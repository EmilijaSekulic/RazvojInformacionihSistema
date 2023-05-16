<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Unos slike za ponudu </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style1.css">
</head>
<body background="${pageContext.request.contextPath}/slike/slika8.jpg">

	<div class="divUnos">	
	
		<c:if test = "${!empty naocare}">
			
			<table>
			
				<tr>
					<th> Naziv modela naocara </th>
					<th> Kategorija </th>
					<th> Cena </th>
					<th> Brend </th>
					<th> Slika </th>
				</tr>
				
				<c:forEach items = "${naocare}" var = "n">
				
					<tr>
						<td> ${n.naziv} </td>
						<td> ${n.kategorija.nazivKategorije} </td>
						<td> ${n.cena} </td>
						<td> ${n.brend.imeBrenda} </td>
						<td> <a href = "/NaocareShop/administrator/dodavanjeSlike?idNaocara=${n.idnaocare}"> Dodavanje slike </a> </td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	
	<c:if test = "${empty naocare}">
		<p class="paragraf"> Trenutno ne postoje naocare u ponudi koje nemaju sliku... </p> 
	</c:if>
	<br><br><br>
	
	<p class="paragraf"> <a href = "/NaocareShop/unos/UnosNoviteta.jsp"> Povratak na prethodnu stranicu </a> </p>
	
</body>
</html>