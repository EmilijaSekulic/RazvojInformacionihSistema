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
	
		<c:if test = "${!empty naocare}">
	
			<br><br>
			<h3 style="font-size:15px; font-family: cursive; text-align:center;"> <a href = "/NaocareShop/pocetna.jsp"> Povratak na pocetnu stranicu </a> </h3>
			
			<table>
				<tr>
					<th> Naziv modela naocara </th>
					<th> Kategorija </th>
					<th> Cena </th>
					<th> Brend </th>
					<th> Staklo </th>
					<th> Oblik </th>
					<th> Slika </th>
					<th> Komentar </th>
				</tr>
				
				<c:forEach items = "${naocare}" var = "n">
				
					<tr>
						<td> ${n.naziv} </td>
						<td> ${n.kategorija.nazivKategorije} </td>
						<td> ${n.cena} </td>
						<td> ${n.brend.imeBrenda} </td>
						<td> ${n.staklo.vrstaStakla} </td>
						<td> ${n.oblik.nazivOblika} </td>
						<td> <a href = "/NaocareShop/korisnici/prikazNaocara?idNaocara=${n.idnaocare}"> Prikaz slike </a> </td>
						<td> <a href = "/NaocareShop/korisnici/ostaviKomentar?idNaocara=${n.idnaocare}"> Ostavite komentar </a> </td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<br>
	
	<div style = "text-align:center; justify-content: center; align-items: center;">	
		<c:if test = "${!empty slika}">
			<img src="data:image/jpeg;base64,${slika}" width="200" height="150" title="Slika naocara">
		</c:if>
	</div>
	
	<div style = "text-align:center; justify-content: center; align-items: center;">	
		<c:if test = "${empty slika}">
			<p style = "color:blue"> <b> ${poruka} </b></p>	
		</c:if>
	</div>
	<br><br>	
	
</body>
</html>