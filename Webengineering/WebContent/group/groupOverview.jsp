<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- META-DATA -->
<head>
<title>MyComp - Home</title>
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
			<c:choose>
				<c:when test="${empty userID}">
					<!--  Home  -->
					<li class="nav-item"><a class="nav-link" href="../official/index.jsp">Home <i class="fas fa-home"></i></a></li>
				</c:when>
				<c:otherwise>
					<!-- Home LoggedIn -->
					<li class="nav-item"><a class="nav-link" href="../official/indexLoggedIn.jsp">Home <i class="fas fa-home"></i></a></li>
					<!--  Gruppen  -->
					<li class="nav-item"><a class="nav-link active" href="#">Gruppen <i class="fas fa-users"></i></a></li>
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

	<!-- BODY -->
	<div class="backgroundSide">
		<div class="container-fluid">
			<div class="backgroundMid">
				<div class="container">
					<div class="row row-offcanvas row-offcanvas-right">
						<div class="col-12 col-md-9">
							<div class="jumbotron">
								<h1>Gruppenübersicht</h1>
								<p>This is an example to show the potential of an offcanvas layout pattern in Bootstrap. Try some responsive-range
									viewport sizes to see it in action.</p>
							</div>
							<div class="row">
								<div class="col-6 col-lg-4">
									<h2>Gruppe 1</h2>
									<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
										condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed
										odio dui.</p>
									<p>
										<a class="btn btn-secondary" href="#" role="button">Mehr anzeigen &raquo;</a>
									</p>
								</div>
								<!--/span-->
								<div class="col-6 col-lg-4">
									<h2>Gruppe 2</h2>
									<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
										condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed
										odio dui.</p>
									<p>
										<a class="btn btn-secondary" href="#" role="button">Mehr anzeigen &raquo;</a>
									</p>
								</div>
								<!--/span-->
								<div class="col-6 col-lg-4">
									<h2>Gruppe 3</h2>
									<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
										condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed
										odio dui.</p>
									<p>
										<a class="btn btn-secondary" href="#" role="button">Mehr anzeigen &raquo;</a>
									</p>
								</div>
							</div>
							<!--/row-->
						</div>
					</div>
					<!--/row-->
				</div>
				<!--/.container-->
			</div>
		</div>
	</div>
	<div class="container-fluid footer">
		<div class="footerCompany col-xs-6 mt-3">
			<p>
				<a class="m-2" href="../official/imprint.jsp">Impressum</a> <a class="m-2" href="../official/privacyPolicy.jsp">Privace Policy</a>
			</p>
			<p>Ⓒ 2019 MyWG</p>
		</div>
	</div>
</body>
</html>