<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="userPojo" class="main.java.pojos.UserPojo" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- META-DATA -->
<head>
<title>MyWG - Profil</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainstyle.css">
<link rel="shortcut icon" href="../resources/iconForREal.png">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark"> <!--  Navbar Toggle  -->
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<c:choose>
				<c:when test="${empty userID}">
					<li class="nav-item"><a class="nav-link" href="../official/index">Home <i class="fas fa-home"></i></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link" href="../official/IndexLoggedIn">Home <i class="fas fa-home"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="../group/groupOverview">Gruppen <i class="fas fa-users"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="../payment/paymentOverview">Zahlungen <i class="fas fa-receipt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${empty userID}">
					<li class="nav-item"><a class="nav-link" href="register.jsp">Registrieren <i class="fas fa-sign-in-alt"></i>
					</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link active" href="#">Profil <i class="fas fa-user"></i>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="../signOut">Abmelden <i class="fas fa-sign-in-alt"></i>
					</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	</nav>
	<div class="backgroundSide">
		<div class="container-fluid">
			<div class="backgroundMid">
				<div class="container ">
					<div class="overviewHeader">
						<h1>
							<u>Profil</u>
						</h1>
					</div>
					<div class="row justify-content-center">
						<div class="widget col-lg-10">
							<div class="container mt-3">
								<h2>Profilansicht</h2>
								<br>
								<!-- Nav tabs -->
								<ul class="nav nav-tabs">
									<li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#home">Profil</a></li>
									<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#menu1">Profil bearbeiten</a></li>
								</ul>

								<!-- Tab panes -->
								<div class="tab-content">
									<!-- MENU ANZEIGEN-->
									<div id="home" class="container tab-pane active">
										<br>
										<div class="row">
											<div class="col-md-6">
												<label>Username: </label>
											</div>
											<div class="col-md-6">
												<p>
													<c:out value="${userPojo.username}"></c:out>
												</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<label>Vorname: </label>
											</div>
											<div class="col-md-6">
												<p>
													<c:out value="${userPojo.firstName}"></c:out>
												</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<label>Nachname: </label>
											</div>
											<div class="col-md-6">
												<p>
													<c:out value="${userPojo.lastName}"></c:out>
												</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<label>E-mail: </label>
											</div>
											<div class="col-md-6">
												<p>
													<c:out value="${userPojo.email}"></c:out>
												</p>
											</div>
										</div>
									</div>
									<!-- MENU BEARBEITEN -->
									<div id="menu1" class="container tab-pane fade">
										<form action="EditProfile" method="post" accept-charset="UTF-8">
											<br>
											<div class="row">
												<div class="col-md-6">
													<label>Benutzername: </label>
												</div>
												<div class="col-md-6">
													<p>
														<input name="userName" placeholder="Benutzername">
													</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label>Vorname: </label>
												</div>
												<div class="col-md-6">
													<p>
														<input name="firstName" placeholder="Vorname">
													</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label>Nachname: </label>
												</div>
												<div class="col-md-6">
													<p>
														<input name="lastName" placeholder="Nachname">
													</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label>E-mail: </label>
												</div>
												<div class="col-md-6">
													<p>
														<input name="eMail" placeholder="E-Mail">
													</p>
												</div>
											</div>
											<div class="justify-content-center">
												<button class="btn btn-primary" type="submit">Profil Ändern</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid footer">
		<div class="footerCompany col-xs-6 mt-3">
			<p>
				<a class="m-2" href="../official/imprint.jsp">Impressum</a> <a class="m-2" href="../official/privacyPolicy.jsp">Privacy
					Policy</a>
			</p>
			<p>Ⓒ 2019 MyWG</p>
		</div>
	</div>
</body>
</html>