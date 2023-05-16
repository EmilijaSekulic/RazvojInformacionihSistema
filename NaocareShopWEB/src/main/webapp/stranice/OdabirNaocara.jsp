<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Odabir naocara </title>

<style>
	
	body{
		background-image: url("${pageContext.request.contextPath}/slike/slika8.jpg");
		height: 100%;
		background-position: center;
	  	background-repeat: no-repeat;
  		background-size: cover;
	}	
</style>

<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/stilovi/style.css">
</head>
<body>

	<div class="center" style="font-size:15px; text-align: center; font-family: cursive; text-align:center;">
	
		<h2 style = "text-align: center"> Kako odabrati okvir prema obliku lica? </h2>
		<br>
		
		<h3 style = "text-align: center"> Okruglo lice </h3>
		<br>
		
		<img src="${pageContext.request.contextPath}/slike/okruglo.jpg" width = "250" height = "250" class="center"/>
		<br>
		Sirina i duzina su jednake kod okruglog lica zato treba izabrati oblik naocara koji ce vizuelno izduziti Vase lice. 
		Izbegavajte okrugle naocare i po mogucnosti izaberite siroke suncane naocare sa kockastim okvirom.
		<br>
		
		<h3 style = "text-align: center"> Ovalno lice </h3>
		<br>
		
		<img src="${pageContext.request.contextPath}/slike/ovalno.jpg" width = "250" height = "250" class="center"/>
		<br>
		Ovalno lice je najzahvalnije za odabir suncanih naocara jer skoro svaki oblik naocara odgovara. Ovaj oblik krase 
		istaknute jagodice i brada koja je znatno uza od cela. Ovalnom obliku pristaju skoro svi oblici suncanih naocara kao i 
		razliciti stilovi. Ako treba bas nesto preporuciti predlazemo blago cetvrtaste okvire sa zaobljenim ivicama.
		<br>
		
		<h3 style = "text-align: center"> Duguljasto lice </h3>
		<br>
		
		<img src="${pageContext.request.contextPath}/slike/duguljasto.jpg" width = "250" height = "250" class="center"/>
		<br>
		Kao sto sam naziv govori ovo lice je duze nego sire i obicno je donji deo lica (vilica) najduzi deo. Za duguljasto lice 
		treba izabrati model naocara koji ce vizuelno skratiti Vase lice. Najbolji izbor su cetvrtaste i okrugle suncane naocare
		vecih dimenzija. 
		<br>
			
		<h3 style = "text-align: center"> Srcoliko lice </h3>
		<br>
		
		<img src="${pageContext.request.contextPath}/slike/srcoliko.jpg" width = "250" height = "250" class="center"/>
		<br>
		Kod srcolikog lica najbitnije je da se uskladi siroko celo i uska brada. Predlazemo da uzmete naocare nalik pilotskih 
		kojima je donji deo malo izduzen, takodje mozete izabrati naocare neobicnog izgleda kako bi vise usmerio paznju na oci.
		<br>
		
		<h3 style = "text-align: center"> Cetvrtasto lice </h3>
		<br>
		
		<img src="${pageContext.request.contextPath}/slike/cetvrtasto.jpg" width = "250" height = "250" class="center"/>
		<br>
		Izrazen donji deo vilice i siroko celo odnosno jednaka sirina i duzina je to sto odlikuje kockasto (ili cetvrtasto) 
		lice. Vama su potrebne naocare koje ce ublaziti te cetvrtaste crte lica i najbolji izbor su velike okrugle ili ovalne 
		suncane naocare sa tamnim staklima.	
		
		<br><br>
		<h3 style = "color:red"> <a href = "/NaocareShop/pocetna.jsp"> Povratak na pocetnu stranicu </a> </h3>
	</div>

</body>
</html>