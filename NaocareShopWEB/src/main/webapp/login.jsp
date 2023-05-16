<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Logovanje korisnika </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/styleIndex.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script></head>
<body style = "background-color: #d9d9ff;">
				
	<section class="Form my-4 mx-5">
		<div class="container">
			<div class="row no-gutters">
				<div class="col-lg-5">
					<img src="${pageContext.request.contextPath}/slike/girlWithGlasess.jpg" width = "450" height = "500">
				</div>
				
				<div class="col-lg-7  px-5 pt-5">
				
					<h2 class="font-weight-bold py-3"> Prijava korisnika </h2>
					
					<c:url var = "loginUrl" value = "/login" />
					<c:if test = "${not empty SPRING_SECURITY_LAST_EXCEPTION.message}">
					<div>
					<br>
						<h6 style = "color:red"> <b> Neispravan username/password! Molimo, pokusajte ponovo! </b> </h6>
					</div>
					</c:if>
					
					
					<form action = "${loginUrl}" method = "post">
						<div class="form-row">
							<div class="col-lg-7">	
								<input type="text" name="username" placeholder="Username" class="form-control my-3 p-4">
							</div>
						</div>
						
						<div class="form-row">
							<div class="col-lg-7">
								<input type="password" name="password" placeholder="Password" class="form-control my-3 p-4">
							</div>
						</div>
						
						<div class="form-row">
							<div class="col-lg-7">
								<input type = "hidden" name = "${_csrf.parameterName}" value = "${_csrf.token}" />
								<input type="submit" class="btn1 mt-3 mb-5" value="Logovanje"> 
							</div>
						</div>
						
						<p> Nemate nalog? <a href = "/NaocareShop/auth/registerUser"> Registracija korisnika </a> </p>
					</form>
				</div>
			</div>
		</div>
	</section>			
				
</body>
</html>