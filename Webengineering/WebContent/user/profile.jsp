<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- META-DATA -->
<head>
<title>MyWG - Profil</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainstyle.css">
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
					<li class="nav-item"><a class="nav-link" href="../official/index.jsp">Home <i class="fas fa-home"></i></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link" href="../official/IndexLoggedIn">Home <i class="fas fa-home"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="../group/groupOverview.jsp">Gruppen <i class="fas fa-users"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="../payment/paymentOverview.jsp">Zahlungen <i class="fas fa-receipt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${empty userID}">
					<li class="nav-item"><a class="nav-link" href="register.jsp">Registrieren <i class="fas fa-sign-in-alt"></i></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link active" href="#">Profil <i class="fas fa-user"></i></a></li>
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
					<div class="col-10 mx-auto mt-5 mb-5">
						<div class="container-fluid emp-profile shadow-lg">
							<form method="post">
								<div class="row">
									<div class="col-md-4">
										<div class="profile-img mb-4">
											<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog"
												alt="" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="profile-head">
											<h5>Kshiti Ghelani</h5>
											<h6>Web Developer and Designer</h6>
											<ul class="nav nav-tabs" id="myTab" role="tablist">
												<li class="nav-item"><a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab"
													aria-controls="home" aria-selected="true">About</a></li>
												<li class="nav-item"><a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab"
													aria-controls="profile" aria-selected="false">Edit Profile</a></li>
											</ul>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="profile-work">
											<p>WORK LINK</p>
											<a href="">Website Link</a><br /> <a href="">Bootsnipp Profile</a><br /> <a href="">Bootply Profile</a>
										</div>
									</div>
									<div class="col-md-6">
										<div class="tab-content profile-tab" id="myTabContent">
											<div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
												<div class="row">
													<div class="col-md-6">
														<label>Username</label>
													</div>
													<div class="col-md-6">
														<p>Kshiti123</p>
													</div>
												</div>
												<div class="row">
													<div class="col-md-6">
														<label>Name</label>
													</div>
													<div class="col-md-6">
														<p>Kshiti Ghelani</p>
													</div>
												</div>
												<div class="row">
													<div class="col-md-6">
														<label>Email</label>
													</div>
													<div class="col-md-6">
														<p>kshitighelani@gmail.com</p>
													</div>
												</div>
											</div>
											<div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
												<div class="col md-6">
													<form action="" method="POST">
														<div class="row">
															<div class="col-md-6">
																<label>Username</label>
															</div>
															<div class="col-md-6">
																<input placeholder="Username" id="uname">
															</div>
														</div>
														<div class="row">
															<div class="col-md-6">
																<label>Password</label>
															</div>
															<div class="col-md-6">
																<input placeholder="Password" id="password">
															</div>
														</div>
														<div class="row">
															<div class="col-md-6">
																<label>Nachname</label>
															</div>
															<div class="col-md-6">
																<input placeholder="Nachname" id="lname">
															</div>
														</div>
														<div class="row">
															<div class="col-md-6">
																<label>Vorname</label>
															</div>
															<div class="col-md-6">
																<input placeholder="Vorname" id="fname">
															</div>
														</div>
														<div class="row">
															<div class="col-md-6">
																<label>E-Mail</label>
															</div>
															<div class="col-md-6">
																<input placeholder="E-Mail" id="email">
															</div>
														</div>
														<button class="profile-edit-btn">Submit</button>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>
							</form>
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