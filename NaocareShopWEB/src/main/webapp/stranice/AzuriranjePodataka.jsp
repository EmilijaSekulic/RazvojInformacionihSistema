<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Azuriranje podataka </title>


<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style1.css">
</head>
<body  background="${pageContext.request.contextPath}/slike/slika8.jpg">

	<div class="divUnos">	
		
		<br><br>
		<h3 style="font-size:15px; font-family: cursive; text-align:center;"> <a href = "/NaocareShop/pocetna.jsp"> Povratak na pocetnu stranicu </a> </h3>
		<br>
		
		<table>
		
			<tr>
				<th> Naziv modela </th>
				<th> Cena </th>
				<th> Azuriranje naziva </th>
				<th> Azuriranje cene </th>
				<th> Uklanjanje ponude </th>
			</tr>		
		
			<c:forEach items = "${naocare}" var = "n">
			
				<tr>
					<td> ${n.naziv} </td>
					<td> ${n.cena} </td>
					<td> <a href = "/NaocareShop/administrator/azuriranjeNaziva?idN=${n.idnaocare}"> Azuriranje naziva </a></td>
					<td> <a href = "/NaocareShop/administrator/azuriranjeCene?idN=${n.idnaocare}"> Azuriranje cene </a></td>
					<td> <a href = "/NaocareShop/administrator/uklanjanjePodataka?idN=${n.idnaocare}"> Uklanjanje ponude </a></td>
				</tr>
				
			</c:forEach>	
		</table>
	</div>
		
</body>
</html>