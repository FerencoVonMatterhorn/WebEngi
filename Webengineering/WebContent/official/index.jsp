<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--  META-DATA  -->
<head>
<title>MyWG - Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainstyle.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
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
			<c:choose>
				<c:when test="${empty userID}">
					<!--  Home  -->
					<li class="nav-item"><a class="nav-link active" href="index.jsp">Home <i class="fas fa-home"></i></a></li>
				</c:when>
				<c:otherwise>
					<!-- Home -->
					<li class="nav-item"><a class="nav-link" href="indexLoggedin.jsp">Home <i class="fas fa-home"></i></a></li>
					<!--  Gruppen  -->
					<li class="nav-item"><a class="nav-link" href="../group/groupOverview.jsp">Gruppen <i class="fas fa-users"></i></a></li>
					<!--  Zahlungen  -->
					<li class="nav-item"><a class="nav-link" href="../payment/paymentOverview.jsp">Zahlungen <i class="fas fa-receipt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<!--  Navbar Items Rechts  -->
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${empty userID}">
					<!-- Registrieren -->
					<li class="nav-item"><a class="nav-link" href="register.jsp">Registrieren <i class="fas fa-sign-in-alt"></i></a></li>
				</c:when>
				<c:otherwise>
					<!--  Profil  -->
					<li class="nav-item"><a class="nav-link" href="../user/profile.jsp">Profil <i class="fas fa-user"></i></a></li>
					<!-- Abmelden TODO: abmelden Servlet-->
					<li class="nav-item"><a class="nav-link" href="../signOut">Abmelden <i class="fas fa-sign-in-alt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<!--  Navbar Items END  -->
	</div>
	</nav>
	<!-- Navigationbar END-->

	<!--  BODY  -->
	<div class="backgroundSide">
		<div class="container-fluid">
			<div class="backgroundMid">
				<!--  Erste ROW  -->
				<div class="row center-block">
					<div class="col-7 mt-5 ml-5">
						<h1>MyWG - Was machen wir?</h1>
						<div class="ml-5 mt-4">
							<p>Wir verschaffen Ihnen einen überblick im Chaos.</p>
							<p>Monatliche Abrechnungen im Überblick.</p>
							<p>Rechnung abfotografieren, hochladen und sagen wer dir Geld schuldet.</p>
							<p>Ab jetzt zurücklehnen, denn den Rest übernehmen wir!</p>
						</div>
					</div>
					<!--  Login Form  -->
					<div class="col-3 card shadow mb-5 mt-5">
						<article class="card-body">
						<h4 class="card-title text-center mb-4 mt-1">Sign in</h4>
						<hr>
						<span id="message"></span>

						<form action="Login" method="POST">
							<!--  First input  -->
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"> <i class="fa fa-user"></i></span>
									</div>
									<input class="form-control" placeholder="Email or Username" type="text" name="emailOrName" required>
								</div>
							</div>
							<!--  Second input  -->
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"> <i class="fa fa-lock"></i></span>
									</div>
									<input class="form-control" placeholder="********" type="password" name="password" required>
								</div>
							</div>
							<!--  Actions  -->
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block">Login</button>
							</div>
							<p class="text-center">
								<a href="#" class="btn">Forgot password?</a>
							</p>
						</form>
						</article>
					</div>
					<!--  Login Form END  -->
				</div>
				<!--  Erste ROW END  -->


				<!--  Carousel Preview  -->
				<div id="myCarousel" class="carousel slide container" data-ride="carousel">

					<!--  Indicators  -->
					<ul class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
					</ul>

					<!--  The slideshow  -->
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="../resources/test1.jpg" width="1100" height="500">
							<div class="carousel-caption">
								<h3>Wir haben die richtige Lösung!</h3>
								<p>Auf einen Blick haben Sie alle ihre Rehcnungen, die diesen Monat anstehen!</p>
							</div>
						</div>
						<div class="carousel-item">
							<img src="../resources/test2.jpg" width="1100" height="500">
						</div>
					</div>

					<!--  Left and right controls  -->
					<a class="carousel-control-prev" href="#myCarousel" data-slide="prev"> <span class="carousel-control-prev-icon"></span>
					</a> <a class="carousel-control-next" href="#myCarousel" data-slide="next"> <span class="carousel-control-next-icon"></span>
					</a>
				</div>
				<!--  Carousel Preview END  -->
				<div class="placeholder mb-5"></div>
			</div>
		</div>
	</div>
	<div class="container-fluid footer">
		<div class="footerCompany col-xs-6 mt-3">
			<p>
				<a class="m-2" href="imprint.jsp">Impressum</a> <a class="m-2" href="privacyPolicy.jsp">Privace Policy</a>
			</p>
			<p>Ⓒ 2019 MyWG</p>
		</div>
	</div>
</body>
</html>