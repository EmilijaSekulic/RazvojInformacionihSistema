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
<title> Registracija korisnika </title>
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
				
					<h3 class="font-weight-bold py-3"> Registracija korisnika </h3>
					
					
					<sf:form action = "/NaocareShop/auth/register" modelAttribute = "korisnik" method = "post">
						
						<div class="form-row">
							<div class="col-lg-7">	
								<sf:input path="ime" placeholder="Ime korisnika" class="form-control my-1 p-2"/>
							</div>
						</div>
						
						<div class="form-row">
							<div class="col-lg-7">	
								<sf:input path="prezime" placeholder="Prezime korisnika" class="form-control my-1 p-2"/>
							</div>
						</div>
						
						<div class="form-row">
							<div class="col-lg-7">
								<sf:input path="username" placeholder="Username" class="form-control my-1 p-2"/>
							</div>
						</div>
						
						<div class="form-row">
							<div class="col-lg-7">	
								<sf:input type="password" path="password" placeholder="Password" class="form-control my-1 p-2"/>
							</div>
						</div>
						
						<div class="form-row">
							<div class="col-lg-7">	
								Odaberite ulogu:
								<sf:select path="naocareshopUlogas" items = "${uloge}" 
										   itemValue = "iduloga" itemLabel = "naziv" class="form-control my-1 p-2">
								</sf:select>
							</div>
						</div>
						
						<div class="form-row">
							<div class="col-lg-7">
								<input type="submit" class="btn1 mt-3 mb-5" value="Registrovanje"> 
							</div>
						</div>				

					</sf:form>
				</div>
			</div>
		</div>
	</section>			
				
</body>
</html>