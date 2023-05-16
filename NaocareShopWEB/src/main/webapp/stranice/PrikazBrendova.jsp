<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Pretraga po brendu </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style2.css">
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">
</head>
<body background="${pageContext.request.contextPath}/slike/slika8.jpg">
	
	<div class="divUnos">
	
		<br><br>
		<h3 style="text-align: center;"> <a href = "/NaocareShop/pocetna.jsp"> Povratak na pocetnu stranicu </a> </h3>
		<br>
	
		<c:if test = "${!empty naocareBrenda}">
				
			<table>
				
					<tr>
						<th> Naziv modela naocara </th>
						<th> Kategorija </th>
						<th> Cena </th>
						<th> Prikaz slike </th>
					</tr>
				
					<c:forEach items = "${naocareBrenda}" var = "n">
				
						<tr>
							<td> ${n.naziv} </td>
							<td> ${n.kategorija.nazivKategorije} </td>
							<td> ${n.cena} </td>
							<td> <a href = "/NaocareShop/korisnici/prikazSlike?idNaocara=${n.idnaocare}"> Prikazi sliku </a> </td>
						</tr>
					</c:forEach>
			</table>
		</c:if>	
	</div>
	
	<c:if test = "${empty naocareBrenda}">
		<p class="paragraf"> ${nemaPonuda} </p> 
	</c:if>
	
	<div style = "text-align:center; justify-content: center; align-items: center;">	
		<c:if test = "${!empty slika}">
			<img src="data:image/jpeg;base64,${slika}" width="250" height="200" title="Slika naocara">
		</c:if>
	</div>
	
	<div style = "text-align:center; justify-content: center; align-items: center;">	
		<c:if test = "${empty slika}">
			<p style = "color:blue"> <b> ${poruka} </b></p>	
		</c:if>
	</div>		
		
</body>
</html>