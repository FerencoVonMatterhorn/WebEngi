<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="singleGroup" class="main.java.beans.SingleGroupBean" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MyComp - einzelneGruppe</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainstyle.css">
<script type="text/javascript" src="../scripts.js"></script>
<link rel="stylesheet" href="singleGroupStyle.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark"> <!--  Navbar Toggle  -->
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<!--  Navbar Items Links  -->
		<ul class="navbar-nav">
			<c:choose>
				<c:when test="${empty userID}">
					<!--  Home  -->
					<li class="nav-item"><a class="nav-link active" href="../official/index">Home <i class="fas fa-home"></i></a></li>
				</c:when>
				<c:otherwise>
					<!-- Home -->
					<li class="nav-item"><a class="nav-link" href="../official/IndexLoggedIn">Home <i class="fas fa-home"></i></a></li>
					<!--  Gruppen  -->
					<li class="nav-item"><a class="nav-link" href="../group/groupOverview">Gruppen <i class="fas fa-users"></i></a></li>
					<!--  Zahlungen  -->
					<li class="nav-item"><a class="nav-link" href="../payment/paymentOverview">Zahlungen <i class="fas fa-receipt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<!--  Navbar Items Rechts  -->
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${empty userID}">
					<!-- Registrieren -->
					<li class="nav-item"><a class="nav-link" href="register.jsp">Registrieren <i class="fas fa-sign-in-alt"></i>
					</a></li>
				</c:when>
				<c:otherwise>
					<!--  Profil  -->
					<li class="nav-item"><a class="nav-link" href="../user/profile">Profil <i class="fas fa-user"></i></a></li>
					<!-- Abmelden TODO: abmelden Servlet-->
					<li class="nav-item"><a class="nav-link" href="../signOut">Abmelden <i class="fas fa-sign-in-alt"></i>
					</a></li>
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
					<div class="overviewHeader">
						<h1>
							<c:out value="${singleGroup.getName()}"></c:out>
							:
						</h1>
						<p>
							<br> Beschreibung:
							<c:out value="${singleGroup.getDescription()}"></c:out>
							<br> Teilnehmer:
							<c:out value="${singleGroup.getUsers()}"></c:out>
							<br> <br>
						</p>
					</div>
					<div class="widget justify-content-center">
						<h5>Letzte Zahlungen der Gruppe:</h5>
						<p class="singlePaymentFromOverview">
							Beteiligte: CK, CK2, CK3, CK4, CK5, CK6 <br> Betrag:500€ <br>
							<button type="Button">Zur Zahlung</button>
							<br>
						</p>
						<p class="singlePaymentFromOverview">
							Beteiligte:CK, CK2, CK3, CK4, CK5, CK6 <br> Betrag:500€ <br>
							<button type="Button">Zur Zahlung</button>
							<br>
						</p>
						<p class="singlePaymentFromOverview">
							Beteiligte:CK, CK2, CK3, CK4, CK5, CK6 <br> Betrag:500€ <br>
							<button type="Button">Zur Zahlung</button>
							<br>
						</p>
						<p class="singlePaymentFromOverview">
							Beteiligte:CK, CK2, CK3, CK4, CK5, CK6 <br> Betrag:500€ <br>
							<button type="Button">Zur Zahlung</button>
							<br>
						</p>
						<p class="singlePaymentFromOverview">
							Beteiligte:CK, CK2, CK3, CK4, CK5, CK6 <br> Betrag:500€ <br>
							<button type="Button">Zur Zahlung</button>
						</p>
						<button class="btn btn-success" type="button" data-toggle="modal" data-target="#newPaymentModal">Neue Zahlung</button>
					</div>
				</div>
				<!-- modal zahlung start -->
				<div class="modal fade" id="newPaymentModal">
					<form name="createPayment" action="createPayment" method="POST" autocomplete="off">
						<div class="modal-dialog">
							<div class="modal-content">
								<!-- Modal Header -->
								<div class="modal-header">
									<h4 class="modal-title mx-auto">Neue Zahlung Erstellen</h4>
									<button type="button" class="close" data-dismiss="modal" onclick="clearPaymentModal()">&times;</button>
								</div>
								<!-- Modal body -->
								<div class="modal-body">
									<div class="form-group">
										<label for="paymentName">Name:</label> <input type="text" class="form-control" id="paymentName" name="paymentName"
											onkeyup="checkPaymentModal()">
									</div>
									<div class="form-group">
										<label for="paymentValue">Betrag:</label> <input type="text" class="form-control" id="paymentValue" name="paymentValue"
											onkeyup="checkPaymentModal()">
									</div>
									<div class="form-group">
										<label for="paymentdescription">Beschreibung:</label> <input type="text" class="form-control" id="paymentdescription"
											name="paymentdescription" onkeyup="checkPaymentModal()">
									</div>

									<hr>
									<p class="text-center">Teilnehmer</p>
									<div class="row mx-1 pb-3 text-center">
										<!-- LEFT -->
										<div class="col-md-* mr-1" id="leftModal">
											<input type="text" class="form-control autocomplete" id="P1" name="P1" placeholder="Name">
										</div>
										<!-- RIGHT -->
										<div class="col-md-*" id="rightModal">
											<input type="text" class="form-control" id="P1P" name="P1P" placeholder="Beteiligung in %"
												onkeyup="checkPaymentModal()">
										</div>
									</div>
									<a class="btn btn-secondary mb-4" style="color: #fff" onclick="addUser()">Teilnehmer Hinzufügen</a>
									<!-- Modal footer -->
									<div class="modal-footer">
										<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="clearPaymentModal()">Abbrechen</button>
										<button id="submitPayment" type="submit" class="btn btn-primary">Zahlung erstellen</button>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
				<!-- modal end -->
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
	<script type="text/javascript">
		var inp = document.getElementById("P1");
		searchUserForPayment(inp, inp.value);
	</script>
</body>
</html>