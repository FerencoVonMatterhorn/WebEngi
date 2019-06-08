<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--  META-DATA  -->
<head>
<title>MyWG - Registrieren</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainstyle.css">
<link rel="stylesheet" href="registrieren.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<script type="text/javascript">
	function check_pass() {
		if (document.getElementById('password1').value == document
				.getElementById('password2').value) {
			document.getElementById('submit').disabled = false;
		} else {
			document.getElementById('submit').disabled = true;
		}
	}
</script>
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
				<!--  Register Form  -->
				<div class="row">
					<div class="card mx-auto shadow mb-5 mt-5" style="border-radius: 8px;">
						<article class="card-body">
						<h4 class="card-title text-center mb-4 mt-1">Sign up</h4>
						<hr>
						<form action="Register" method="POST">
							<!--  First input  -->
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-length input-group-text"> First name:</span>
									</div>
									<input type="text" class="form-control" name="fname" required>
								</div>
							</div>
							<!--  Second input  -->
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-length input-group-text"> Last name:</span>
									</div>
									<input type="text" class="form-control" name="lname" required>
								</div>
							</div>
							<!--  Third input  -->
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-length input-group-text"> Username:</span>
									</div>
									<input type="text" class="form-control" name="uname" required>
								</div>
							</div>
							<!--  Fourth input  -->
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-length input-group-text"> Email address:</span>
									</div>
									<input type="email" class="form-control" name="email" required>
								</div>
							</div>
							<!--  Fifth input  -->
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-length input-group-text"> Password:</span>
									</div>
									<input type="password" class="form-control" name="password1" id="password1" onkeyup='check_pass();' required>
								</div>
							</div>
							<!--  Sixth input  -->
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-length input-group-text"> Repeat password:</span>
									</div>
									<input type="password" class="form-control" name="password2" id="password2" onkeyup='check_pass();' required>
								</div>
							</div>
							<span id="message"></span>
							<hr>
							<!--  Actions  -->
							<div class="form-group">
								<button id="submit" type="submit" class="btn btn-primary btn-block">Register</button>
							</div>
						</form>
						</article>
						<!--  Register Form END  -->
					</div>
				</div>
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