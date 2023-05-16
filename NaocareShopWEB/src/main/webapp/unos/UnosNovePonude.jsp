<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Unos nove ponude </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">
</head>
<body background="${pageContext.request.contextPath}/slike/slika8.jpg">


	<div class="divUnos">	
	
		<form action = "/NaocareShop/administrator/savePonuda" method = "post">
		
			<table class="tabelica">
				<tr>
					<td> Naziv: </td>
					<td> <input type = "text" name = "naziv"> </td>
				</tr>
				<tr> 
					<td> Cena: </td>
					<td> <input type = "text" name = "cena"> </td>
				</tr>
				<tr>
					<td> Kategorija: </td>
					<td>
						<select name = "kategorija">
							<c:forEach items = "${kategorije}" var = "k">
								<option value = "${k.idkategorije}"> ${k.nazivKategorije} </option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td> Brend: </td>
					<td>
						<select name = "brend">
							<c:forEach items = "${brendovi}" var = "b">
								<option value = "${b.idbrend}"> ${b.imeBrenda} </option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td> Oblik: </td>
					<td>
						<select name = "oblik">
							<c:forEach items = "${oblici}" var = "o">
								<option value = "${o.idoblik}"> ${o.nazivOblika} </option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td> Staklo: </td>
					<td>
						<select name = "staklo">
							<c:forEach items = "${stakla}" var = "s">
								<option value = "${s.idstaklo}"> ${s.vrstaStakla} </option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td> <input type = "submit" value = "Unesi"> </td>
				</tr>
			</table>
		</form>
	</div>	
		
	<c:if test = "${!empty naocare}">
		<p class="paragraf"> <b> ${porukaNaocare} </b></p>
	</c:if>
	<br>
		
	<p class="paragraf"> <a href = "/NaocareShop/unos/UnosNoviteta.jsp"> Povratak na prethodnu stranicu </a> </p>
	
</body>
</html>