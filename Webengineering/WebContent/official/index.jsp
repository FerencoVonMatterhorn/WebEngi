<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<c:choose>
				<c:when test="${empty userID}">
					<li class="nav-item"><a class="nav-link active" href="#">Home <i class="fas fa-home"></i></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link" href="../official/IndexLoggedIn">Home <i class="fas fa-home"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="../group/groupOverview.jsp">Gruppen <i class="fas fa-users"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="../payment/paymentOverview">Zahlungen <i class="fas fa-receipt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${empty userID}">
					<li class="nav-item"><a class="nav-link" href="register.jsp">Registrieren <i class="fas fa-sign-in-alt"></i></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link" href="../user/profile">Profil <i class="fas fa-user"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="../signOut">Abmelden <i class="fas fa-sign-in-alt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	</nav>
	<div class="backgroundSide">
		<div class="container-fluid">
			<div class="backgroundMid">
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
					<div class="col-3 card shadow mb-5 mt-5">
						<article class="card-body">
						<h4 class="card-title text-center mb-4 mt-1">Sign in</h4>
						<hr>
						<c:if test="${message ne null}">
							<p class="message-error" id="message">
								<c:out value="${message}"></c:out>
							</p>
						</c:if>
						<form action="Login" method="POST">
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"> <i class="fa fa-user"></i></span>
									</div>
									<input class="form-control" placeholder="Email or Username" type="text" name="emailOrName" required>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"> <i class="fa fa-lock"></i></span>
									</div>
									<input class="form-control" placeholder="********" type="password" name="password" required>
								</div>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block">Login</button>
							</div>
						</form>
						</article>
					</div>
				</div>


				<div id="myCarousel" class="carousel slide container" data-ride="carousel">
					<ul class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
					</ul>
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
					<a class="carousel-control-prev" href="#myCarousel" data-slide="prev"> <span class="carousel-control-prev-icon"></span>
					</a> <a class="carousel-control-next" href="#myCarousel" data-slide="next"> <span class="carousel-control-next-icon"></span>
					</a>
				</div>
				<div class="placeholder mb-5"></div>
			</div>
		</div>
	</div>
	<div class="container-fluid footer">
		<div class="footerCompany col-xs-6 mt-3">
			<p>
				<a class="m-2" href="imprint.jsp">Impressum</a> <a class="m-2" href="privacyPolicy.jsp">Privacy Policy</a>
			</p>
			<p>Ⓒ 2019 MyWG</p>
		</div>
	</div>
</body>
</html>