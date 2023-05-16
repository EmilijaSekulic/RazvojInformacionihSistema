<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Izbor slike za ponudu </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">
</head>
<body background="${pageContext.request.contextPath}/slike/slika8.jpg">

	<div class="divUnos">	
	
		<form action = "/NaocareShop/administrator/unesiSliku" method = "post" enctype = "multipart/form-data" accept="image/png, image/jpeg, image/jpg">
		
			<table class="tabelica">
	
				<tr>
					<td> Slika: </td>
					<td> <input type = "file" name = slika> </td>
				</tr>
				<tr>
					<td></td>
					<td> <input type = "submit" value = "Sacuvaj sliku"> </td>
				</tr>
	
			</table>
		</form>	
	</div>
	
	<c:if test = "${!empty naocarePromenjene}">		
		<p class="paragraf"> <b> ${porukaOPromeni} </b></p>
	</c:if>
	<br><br>
	
	<p class="paragraf"> <a href = "/NaocareShop/unos/UnosNoviteta.jsp"> Povratak na prethodnu stranicu </a> </p>
	
</body>
</html>