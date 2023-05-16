<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Unos nove ponude - sa slikom </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">
</head>
<body background="${pageContext.request.contextPath}/slike/slika8.jpg">

	<div class="divUnos">	
	
		<form:form modelAttribute = "naocareI" action = "/NaocareShop/administrator/saveNaocareImg" 
				   method = "post" enctype = "multipart/form-data">
		
			<table class="tabelica">
				<tr>
					<td> Naziv: </td>
					<td> <form:input type = "text" path = "naziv" /> </td>
				</tr>
				<tr> 
					<td> Cena: </td>
					<td> <form:input type = "text" path = "cena" /> </td>
				</tr>
				<tr>
					<td> Kategorija: </td>
					<td>
						<form:select path = "kategorija" items = "${kategorije}" 
									 itemValue = "idkategorije" itemLabel = "nazivKategorije"/>
					</td>
				</tr>
				<tr>
					<td> Brend: </td>
					<td>
						<form:select path = "brend" items = "${brendovi}" 
									 itemValue = "idbrend" itemLabel = "imeBrenda"/>
					</td>
				</tr>
				<tr>
					<td> Oblik: </td>
					<td>
						<form:select path = "oblik" items = "${oblici}" 
									 itemValue = "idoblik" itemLabel = "nazivOblika"/>
					</td>
				</tr>
				<tr>
					<td> Staklo: </td>
					<td>
						<form:select path = "staklo" items = "${stakla}" 
									 itemValue = "idstaklo" itemLabel = "vrstaStakla"/>
					</td>
				</tr>
				<tr>
					<td> Slika: </td>
					<td> <form:input type = "file" path = "slika" /> </td>
				</tr>
				<tr>
					<td></td>
					<td> <input type = "submit" value = "Unesi"> </td>
				</tr>
			</table>
		</form:form>
	</div>	

	<c:if test = "${!empty naocare}">		
		<p class="paragraf"> <b> ${poruka} </b></p>
	</c:if>
	<br>
	
	<p class="paragraf"> <a href = "/NaocareShop/unos/UnosNoviteta.jsp"> Povratak na prethodnu stranicu </a> </p>
	
</body>
</html>