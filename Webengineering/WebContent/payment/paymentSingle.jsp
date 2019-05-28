<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--  META-DATA  -->
<head>
<title>MyWG - Zahlung</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainstyle.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
</head>
<body>
	<!--  Navigationbar  -->
	<nav class="navbar navbar-expand-md bg-dark navbar-dark"> <!--  Navbar Toggle  -->
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!--  Navbar Toggle END  -->
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<!--  Navbar Items Links  -->
		<ul class="navbar-nav">
			<!--  Home  -->
			<li class="nav-item"><a class="nav-link" href="../Startseite/Index.jsp">Home <i class="fas fa-home"></i></a></li>
			<!--  Gruppen  -->
			<li class="nav-item"><a class="nav-link" href="../Gruppenuebersicht/Gruppenuebersicht.jsp">Gruppen <i
					class="fas fa-users"></i></a></li>
			<!--  Zahlungen  -->
			<li class="nav-item"><a class="nav-link active" href="../Zahlungsuebersicht/Zahlungsuebersicht.jsp">Zahlungen <i
					class="fas fa-receipt"></i></a></li>
		</ul>
		<!--  Navbar Items Rechts  -->
		<ul class="navbar-nav ml-auto">
			<!--  Profil  -->
			<li class="nav-item"><a class="nav-link" href="../Profil/Profil.jsp">Profil <i class="fas fa-user"></i></a></li>
			<!--  Abmelden; TODO: abmelden.jsp erstellen  -->
			<li class="nav-item"><a class="nav-link" href="#abmelden">Abmelden <i class="fas fa-sign-in-alt"></i></a></li>
		</ul>
		<!--  Navbar Items END  -->
	</div>
	</nav>
	<!-- Navigationbar END-->

	<!-- BODY -->
	<div class="backgroundSide">
		<div class="container-fluid">
			<div class="backgroundMid">
				<div class="container">
					<!--  row Überschrift  -->
					<div class="row justify-content-center">
						<h1 class="pt-5 text-center">Hier kommt die Zahlungsüberschrift mit JSP hin</h1>
					</div>
					<!--  row Überschrift END  -->
					<!--  row Table  -->
					<div class="row col-10 mx-auto mt-5 mb-5">
						<table class="table table-hover table-striped">
							<thead>
								<tr>
									<th>Beteiligter</th>
									<th>% Anteil</th>
									<th>Betrag</th>
								</tr>
							</thead>
							<tbody>
								<!--  ENDE DER DYNAMISCHEN ERSTELLUNG  -->
							</tbody>
						</table>
					</div>
					<!--  row Table END  -->
				</div>
			</div>
		</div>
	</div>
	<!--  BODY END  -->


	<!--  Footer  -->
	<div class="container-fluid footer">
		<div class="footerCompany col-xs-6 mt-3">
			<p>
				<a href="#impressum">Impressum</a>
			</p>
			<p>Ⓒ 2019 MyCompName</p>
		</div>
	</div>
	<!--  Footer END  -->
</body>
</html>