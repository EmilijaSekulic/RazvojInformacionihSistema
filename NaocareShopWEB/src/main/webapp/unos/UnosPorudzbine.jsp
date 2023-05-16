<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Unos porudzbine </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">
</head>
<body background="${pageContext.request.contextPath}/slike/slika8.jpg">

	<div class="divUnos">	

		<form action = "/NaocareShop/korisnici/savePorudzbina" method = "post">
	
			<table class="tabelica">		
				<tr>
					<td> Odaberite proizvod/e koje zelite: </td>
					<td>
						<select name = "naocare" multiple>
							<c:forEach items = "${naocare}" var = "n">
								<option value = "${n.idnaocare}"> ${n.naziv} </option>
							</c:forEach>
						</select>
					</td>
				</tr>	
				<tr>
					<td> Email: </td>
					<td> <input type = "text" name = "email"> </td>
				</tr>
				<tr>
					<td> Adresa: </td>
					<td> <input type = "text" name = "adresa"> </td>
				</tr>
				<tr>
					<td> Datum isporuke: </td>
					<td> <input type="date" name="datumIsporuke"> (3 dana minimalno potrebno) </td>
				</tr>
				<tr>
					<td> Nacin placanja: </td>
					<td> <input type = "text" placeholder = "po prispecu/kartica" name = "nacinPlacanja"> </td>
				</tr>	
				<tr>
					<td> Odaberite ukoliko zelite i nesto od dodataka uz naocare: </td>
					<td>
						<select name = "dodaci" multiple>
							<c:forEach items = "${dodaci}" var = "d">
								<option></option>
								<option value = "${d.iddodatak}"> ${d.nazivDodatka}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td> <input type = "submit" value = "Potvrdi porudzbinu"> </td>
				</tr>
			</table>
		</form>
	</div>	
	
	<c:if test = "${!empty porudzbina}">	
		<p class="paragraf"> <b> ${porukaPorudzbina} </b></p>
	</c:if>
	
	<p class="paragraf"> <a href = "/NaocareShop/pocetna.jsp"> Povratak na pocetnu stranicu </a> </p>
	
</body>
</html>