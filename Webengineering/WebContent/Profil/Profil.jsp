<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- META-DATA -->
<head>
<title>MyComp - Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainStyle.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
	crossorigin="anonymous">


<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<!-- Navigationbar -->
	<nav class="navbar navbar-expand-md bg-dark navbar-dark"> <!-- Navbar Toggle -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!-- Navbar Toggle END -->
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<!-- Navbar Items Links-->
		<ul class="navbar-nav">
			<!-- Home -->
			<li class="nav-item active"><a class="nav-link" href="#asd">Home
					<i class="fas fa-home"></i>
			</a></li>
			<!--c:if test="${loggedin}"  JSP SCRIPT TO HIDE ELEMENTS-->
			<!-- Gruppen Dropdown-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#asd" id="navbardrop1"
				data-toggle="dropdown">Gruppen <i class="fas fa-users"></i></a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="asd">Gruppe 1</a> <a
						class="dropdown-item" href="asd">Gruppe 2</a> <a
						class="dropdown-item" href="asd">Gruppe 3</a>
				</div></li>
			<!-- Zahlungen -->
			<li class="nav-item"><a class="nav-link" href="#asd">Zahlungen
					<i class="fas fa-receipt"></i>
			</a></li>
		</ul>
		<!-- Navbar Items Rechts-->
		<ul class="navbar-nav ml-auto">
			<!-- Profil -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#asd" id="navbardrop2"
				data-toggle="dropdown">Benutzer <i class="fas fa-user"></i></a>
				<div class="dropdown-menu dropdown-menu-right">
					<a class="dropdown-item" href="#asd">Profil bearbeiten <i
						class="fas fa-user-edit"></i>
					</a> <a class="dropdown-item" href="#asd">Abmelden <i
						class="fas fa-sign-in-alt"></i>
					</a>
				</div></li>
			<!-- /c:if -->
			<li class="nav-item"><a class="nav-link" href="#asd">Registrieren
					<i class="fas fa-sign-in-alt"></i>
			</a></li>
		</ul>
		<!-- Navbar Items END -->
	</div>
	</nav>
	<!-- Navigationbar END-->

	<!-- BODY -->
	<div class="backgroundSide">
		<div class="container-fluid">
			<div class="backgroundMid">
				<div class="Profile">
					<div class="container emp-profile">
						<form method="post">
							<div class="row">
								<div class="col-md-4">
									<div class="profile-img">
										<img
											src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog"
											alt="" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="profile-head">
										<h5>Kshiti Ghelani</h5>
										<h6>Web Developer and Designer</h6>
										<p class="proile-rating">
											RANKINGS : <span>8/10</span>
										</p>
										<ul class="nav nav-tabs" id="myTab" role="tablist">
											<li class="nav-item"><a class="nav-link active"
												id="home-tab" data-toggle="tab" href="#home" role="tab"
												aria-controls="home" aria-selected="true">About</a></li>
											<li class="nav-item"><a class="nav-link"
												id="profile-tab" data-toggle="tab" href="#profile"
												role="tab" aria-controls="profile" aria-selected="false">Timeline</a>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-md-2">
									<input type="submit" class="profile-edit-btn" name="btnAddMore"
										value="Edit Profile" />
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<div class="profile-work">
										<p>WORK LINK</p>
										<a href="">Website Link</a><br /> <a href="">Bootsnipp
											Profile</a><br /> <a href="">Bootply Profile</a>
										<p>SKILLS</p>
										<a href="">Web Designer</a><br /> <a href="">Web
											Developer</a><br /> <a href="">WordPress</a><br /> <a href="">WooCommerce</a><br />
										<a href="">PHP, .Net</a><br />
									</div>
								</div>
								<div class="col-md-8">
									<div class="tab-content profile-tab" id="myTabContent">
										<div class="tab-pane fade show active" id="home"
											role="tabpanel" aria-labelledby="home-tab">
											<div class="row">
												<div class="col-md-6">
													<label>User Id</label>
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
											<div class="row">
												<div class="col-md-6">
													<label>Phone</label>
												</div>
												<div class="col-md-6">
													<p>123 456 7890</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label>Profession</label>
												</div>
												<div class="col-md-6">
													<p>Web Developer and Designer</p>
												</div>
											</div>
										</div>
										<div class="tab-pane fade" id="profile" role="tabpanel"
											aria-labelledby="profile-tab">
											<div class="row">
												<div class="col-md-6">
													<label>Experience</label>
												</div>
												<div class="col-md-6">
													<p>Expert</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label>Hourly Rate</label>
												</div>
												<div class="col-md-6">
													<p>10$/hr</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label>Total Projects</label>
												</div>
												<div class="col-md-6">
													<p>230</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label>English Level</label>
												</div>
												<div class="col-md-6">
													<p>Expert</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label>Availability</label>
												</div>
												<div class="col-md-6">
													<p>6 months</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12">
													<label>Your Bio</label><br />
													<p>Your detail description</p>
												</div>
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
		<!-- BODY ENDE -->



		<!-- Footer -->
		<div class="container-fluid footer">
			<div class="footerCompany col-xs-6 mt-3">
				<p>
					<a href="#impressum">Impressum</a>
				</p>
				<p>Ⓒ 2019 MyCompName</p>
			</div>
		</div>
		<!-- Footer ENDE-->
</body>
</html>