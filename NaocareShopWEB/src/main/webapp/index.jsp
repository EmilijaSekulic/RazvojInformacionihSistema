<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Prodavnica naocara - pocetna stranica </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/styleIndex.css">
</head>

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
				
					<h3 class="font-weight-bold py-3" style="font-family: cursive;  text-align: center"> SuncaneNaocareOnLine </h3>
					<br>
							
							<div class="col-lg-15" style = "font-size:20px; font-family: cursive;">	
								 Dobrodosli na sajt prodavnice suncanih naocara!
							</div>
							<br>
						
							<div class="col-lg-15">
								<p style = "font-size:20px; font-family: cursive;"> 
									Ukoliko zelite da nadjete idealne naocare za sebe, na pravom ste mestu!
								 </p>
							</div>
							<br>
							
							<div class="col-lg-15">
								<p style = "font-size:20px; font-family: cursive;"> 
									Da bi nastavili sa radom, morate biti prijavljeni, sto mozete uraditi preko sledeceg linka:
								 </p>
							</div>
							
							<div class="col-lg-15">	
								<p style = "font-size:20px; font-family: cursive; text-align: center"> <a href = "/NaocareShop/auth/loginPage"> Prijava korisnika </a> </p>
							</div>
				</div>
			</div>
		</div>
	</section>			
		
</body>
</html>