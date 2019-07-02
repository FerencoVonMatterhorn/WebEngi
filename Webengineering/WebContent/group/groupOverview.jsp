<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="groupOverView" class="main.java.beans.GroupOverViewBean" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MyWG - Gruppen</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainstyle.css">
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
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark"> <!--  Navbar Toggle  -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<c:choose>
				<c:when test="${empty userID}">
					<li class="nav-item"><a class="nav-link"
						href="../official/index">Home <i class="fas fa-home"></i></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="../official/IndexLoggedIn">Home <i class="fas fa-home"></i></a></li>
					<li class="nav-item"><a class="nav-link active" href="#">Gruppen
							<i class="fas fa-users"></i>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../payment/paymentOverview">Zahlungen <i
							class="fas fa-receipt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${empty userID}">
					<li class="nav-item"><a class="nav-link"
						href="../official/register.jsp">Registrieren <i
							class="fas fa-sign-in-alt"></i></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="../user/profile">Profil <i class="fas fa-user"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="../signOut">Abmelden
							<i class="fas fa-sign-in-alt"></i>
					</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	</nav>
	<div class="backgroundSide">
		<div class="container-fluid">
			<div class="backgroundMid">
				<div class="container">
					<div class="row row-offcanvas row-offcanvas-right">
						<div class="col-12 col-md-9">
							<div class="overviewHeader">
								<h1>Gruppenübersicht</h1>
								<p>This is an example to show the potential of an offcanvas
									layout pattern in Bootstrap. Try some responsive-range viewport
									sizes to see it in action.</p>
							</div>
							<div class="row">
								<div class="col-6 col-lg-4">
									<div class="widget">
										<h2>Gruppe 1</h2>
										<p>Donec id elit non mi porta gravida at eget metus. Fusce
											dapibus, tellus ac cursus commodo, tortor mauris condimentum
											nibh, ut fermentum massa justo sit amet risus. Etiam porta
											sem malesuada magna mollis euismod. Donec sed odio dui.</p>
										<p>
											<a class="btn btn-secondary" href="#" role="button">Mehr
												anzeigen &raquo;</a>
										</p>
									</div>
								</div>
								<!--/span-->
								<div class="col-6 col-lg-4">
									<div class="widget">
										<h2>Gruppe 2</h2>
										<p>Donec id elit non mi porta gravida at eget metus. Fusce
											dapibus, tellus ac cursus commodo, tortor mauris condimentum
											nibh, ut fermentum massa justo sit amet risus. Etiam porta
											sem malesuada magna mollis euismod. Donec sed odio dui.</p>
										<p>
											<a class="btn btn-secondary" href="#" role="button">Mehr
												anzeigen &raquo;</a>
										</p>
									</div>
								</div>
								<!--/span-->
								<div class="col-6 col-lg-4">
									<div class="widget">
										<h2>Gruppe 3</h2>
										<p>Donec id elit non mi porta gravida at eget metus. Fusce
											dapibus, tellus ac cursus commodo, tortor mauris condimentum
											nibh, ut fermentum massa justo sit amet risus. Etiam porta
											sem malesuada magna mollis euismod. Donec sed odio dui.</p>
										<p>
											<a class="btn btn-secondary" href="#" role="button">Mehr
												anzeigen &raquo;</a>
										</p>
									</div>
								</div>
								<c:forEach items="${groupOverView.groups}" var="group">
									<div class="col-6 col-lg-4">
										<div>
											<h2>
												<c:out value="${group.getGroupName()}"/>
											</h2>
											<p>
												<c:out value="${group.getGroupDescription()}"/>											
											</p>
										</div>
									</div>
								</c:forEach>
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
				<a class="m-2" href="../official/imprint.jsp">Impressum</a> <a
					class="m-2" href="../official/privacyPolicy.jsp">Privacy Policy</a>
			</p>
			<p>Ⓒ 2019 MyWG</p>
		</div>
	</div>
</body>
</html>