<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Prikaz slike za odabrani model naocara </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style2.css">
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">
</head>
<body  background="${pageContext.request.contextPath}/slike/slika8.jpg">

	<div style = "text-align:center; justify-content: center; align-items: center; padding-top: 80px; padding-bottom: 50px;">	
		<c:if test = "${!empty slika}">
			<img src="data:image/jpeg;base64,${slika}" width="230" height="230" title="Slika naocara">
		</c:if>
	</div>
	
	<div style = "text-align:center; justify-content: center; align-items: center;">	
		<c:if test = "${empty slika}">
			<p style = "color:blue"> <b> ${poruka} </b></p>	
		</c:if>
	</div>
	<p class="paragraf"> <a href = "/NaocareShop/stranice/PrikazPonuda.jsp"> Povratak na prethodnu stranu </a> </p>
	
	
</body>
</html>