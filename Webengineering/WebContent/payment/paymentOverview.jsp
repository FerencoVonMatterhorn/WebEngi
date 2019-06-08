<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="paymentOverview" class="main.java.beans.PaymentOverviewBean" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- META-DATA -->
<head>
<title>MyComp - einzelneGruppe</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainstyle.css">
<link rel="stylesheet" href="paymentOverviewStyle.css">
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
					<li class="nav-item"><a class="nav-link" href="../official/IndexLoggedIn.jsp">Home <i class="fas fa-home"></i></a></li>
					<!--  Gruppen  -->
					<li class="nav-item"><a class="nav-link" href="../group/groupOverview.jsp">Gruppen <i class="fas fa-users"></i></a></li>
					<!--  Zahlungen  -->
					<li class="nav-item"><a class="nav-link active" href="#">Zahlungen <i class="fas fa-receipt"></i></a></li>
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
					<li class="nav-item"><a class="nav-link" href="signOut">Abmelden <i class="fas fa-sign-in-alt"></i></a></li>
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

				<c:set var="itemCount" value="${paymentOverview.listSize -1}" />
				<c:set var="pageDefault" value="" />

				<c:forEach begin="1" end="${paymentOverview.pageSize}" var="i">
					<c:set var="decr" value="${paymentOverview.pageSize+1-i}" />

					<c:if test="${decr eq 1}">
						<c:set var="pageDefault" value="default" />
					</c:if>

					<div id="page${decr}" class="page ${pageDefault}">
						<c:forEach begin="1" end="5" var="j">
							<c:set var="decrItem" value="${5-j}" />
							<c:set var="index" value="${itemCount - decrItem}" />

							<p class="bg-dark singlePaymentInOverview">
								Beteiligte: Christian, Christian2, Kollerabs, Christian123 <br> Betrag:${paymentOverview.test.get(index)} <br>
								Typ: <br> Erstellt am: <br>
								<!-- if für Typ=Monatsabrechnung wenn -> Bezahlen bis -->
								<button type="button">Zur Zahlung</button>
							</p>


						</c:forEach>
					</div>

					<c:set var="itemCount" value="${itemCount -5}" />
				</c:forEach>

				<nav> <c:forEach begin="1" end="${paymentOverview.pageSize}" varStatus="loop">
					<a href="#page${loop.index}">${loop.index}</a>
				</c:forEach> </nav>
			</div>
		</div>
	</div>
	<!-- BODY ENDE -->


	<!--  Footer  -->
	<div class="container-fluid footer">
		<div class="footerCompany col-xs-6 mt-3">
			<p>
				<a href="../official/imprint.jsp">Impressum</a>
			</p>
			<p>Ⓒ 2019 MyCompName</p>
		</div>
	</div>
	<!--  Footer END  -->
</body>
</html>

