<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Azuriranje naziva </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">
</head>
<body background="${pageContext.request.contextPath}/slike/slika8.jpg">

	
	<div class="divUnos">	

		
		<c:if test = "${!empty naocareNaziv}">	
	
			<h3 style = "color:red; text-align: center"> Azuriranje naziva modela naocara ${naocareNaziv.naziv} </h3>
			<br><br>
			
			<form action = "/NaocareShop/administrator/saveNaziv" method="post">
			
				<table class="tabelica">
				
					<tr>
						<td> Nov naziv naocara: </td>
						<td> <input type="text" name = "naziv"> </td>
					</tr>
					<tr>
						<td></td>
						<td> <input type = "submit" value = "Promeni"></td>
					</tr>
				</table>
			</form>
		</c:if>
	</div>	
	<br><br>
	<h3 style = "color:blue; text-align: center"> <a href = "/NaocareShop/stranice/AzuriranjePodataka.jsp"> Povratak na prethodnu stranicu </a> </h3>
		
</body>
</html>