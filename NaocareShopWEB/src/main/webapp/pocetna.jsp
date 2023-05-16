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
<title> Pocetna stranica </title>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">
</head>
<body>

	<div class="sidenav">
	
		<a href = "/NaocareShop/stranice/Onama.jsp"> O nama </a>
		<a href = "/NaocareShop/stranice/VaznostNaocara.jsp"> Vaznost naocara </a>
		<a href = "/NaocareShop/stranice/OdabirNaocara.jsp"> Pomoc pri odabiru naocara </a>
		<br>
		
		<security:authorize access = "isAuthenticated()">
		
			<a href = "/NaocareShop/administrator/unosNoviteta"> Unos novih modela </a>
			<a href = "/NaocareShop/administrator/azuriranjePodataka"> Azuriranje podataka </a>
			<br>
			
			<a href = "/NaocareShop/ucesnici/getPonude"> Pregled ponuda </a>
			<a href = "/NaocareShop/ucesnici/getDodaci"> Pregled dodataka za naocare </a>
			<a href = "/NaocareShop/korisnici/getBrendovi"> Pretraga po brendu </a>
			<a href = "/NaocareShop/korisnici/getKategorije"> Pretraga po kategoriji </a>
			<a href = "/NaocareShop/korisnici/kreirajPorudzbinu"> Porucivanje naocara </a>
			<a href = "/NaocareShop/ucesnici/prikaziOcene"> Pregled ocena i komentara </a>
			<br>
			
			<a href = "/NaocareShop/korisnici/getZadatiRasponCena"> Naocare u zadatom rasponu cena - izvestaj </a>
			<a href = "/NaocareShop/administrator/getZadateDatume"> Naocare isporucene u zadatom periodu - izvestaj </a>
			<br>
			<a href = "/NaocareShop/auth/logout"> Odjava korisnika </a>
			
		</security:authorize>
	</div>

	<div class="main" style="font-size:15px; font-family: cursive; text-align:center;">
		
		<img src="${pageContext.request.contextPath}/slike/typesOfGlasses.jpg" width = "350" height = "400" class="center"/>
		<br>
		
		<p>
			Naocare za sunce su nas omiljeni aksesoar i tokom letnjih i zimskih dana
			<br>
			U nasoj ponudi mozete da nadjete i muske naocare za sunce i zenske naocare za sunce poznatih svetskih brendova
			<br><br>
			
			Naocare za sunce nisu samo odlicna zastita od sunca, vec su i odlican aksesoar koji se savrseno uklapa uz svaki outfit
			<br>
			Setnja, posao ili poseban dogadjaj, naocare za sunce ce uvek dodati dozu stila vasem izgledu
			<br><br>
			
			Bez obzira da li ste ljubitelj klasicnih modela ili se odlucujete za raznobojne modele poslednjih trendova, 
			nasa internet prodavnica je pravi izbor za vas
		</p>
		
	</div>

</body>
</html>