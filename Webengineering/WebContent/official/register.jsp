<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MyWG - Registrieren</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainstyle.css">
<link rel="stylesheet" href="registrieren.css">
<script type="text/javascript" src="../scripts.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<c:choose>
				<c:when test="${empty userID}">
					<li class="nav-item"><a class="nav-link active" href="index.jsp">Home <i class="fas fa-home"></i></a></li>
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
				<div class="row">
					<div class="card mx-auto shadow mb-5 mt-5" style="border-radius: 8px;">
						<article class="card-body">
						<h4 class="card-title text-center mb-4 mt-1">Sign up</h4>
						<hr>
						<c:if test="${registrationUnsuccessful ne null}">
							<p class="message-error col">
								<c:out value="${registrationUnsuccessful}"></c:out>
							</p>
						</c:if>
						<form action="Register" method="POST">
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-length input-group-text"> Vorname:</span>
									</div>
									<input type="text" class="form-control" name="fname" id="fname" onkeyup='validateRegistration()'>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-length input-group-text"> Nachname:</span>
									</div>
									<input type="text" class="form-control" name="lname" id="lname" onkeyup='validateRegistration()'>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-length input-group-text"> Benutzername:</span>
									</div>
									<input type="text" class="form-control" name="uname" id="uname" onkeyup='validateRegistration()'>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-length input-group-text"> Email-Addresse:</span>
									</div>
									<input type="email" class="form-control" name="email" id="email" onkeyup='validateRegistration()'>
								</div>
								<c:if test="${emailWasIncorrectlyFormatted ne null}">
									<p class="message-error col">
										<c:out value="${emailWasIncorrectlyFormatted}"></c:out>
									</p>
								</c:if>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-length input-group-text"> Passwort:</span>
									</div>
									<input type="password" class="form-control" name="password1" id="password1" onkeyup='validateRegistration()'>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-length input-group-text"> Passwort wiederholen:</span>
									</div>
									<input type="password" class="form-control" name="password2" id="password2" onkeyup='validateRegistration()'>
								</div>
							</div>
							<c:if test="${passwordsDidNotMatch ne null}">
								<p class="message-error col">
									<c:out value="${passwordsDidNotMatch}"></c:out>
								</p>
							</c:if>
							<hr>
							<div class="form-group">
								<button id="submit" type="submit" class="btn btn-primary btn-block">Register</button>
							</div>
						</form>
						</article>
					</div>
				</div>
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